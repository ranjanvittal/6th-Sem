/* -*- Mode:C++; c-file-style:"gnu"; indent-tabs-mode:nil; -*- */
/*
 * Copyright (c) 2010 Adrian Sai-wah Tam
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as
 * published by the Free Software Foundation;
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * Author: Adrian Sai-wah Tam <adrian.sw.tam@gmail.com>
 */

#define NS_LOG_APPEND_CONTEXT \
  if (m_node) { std::clog << Simulator::Now ().GetSeconds () << " [node " << m_node->GetId () << "] "; }

#include "tcp-mine.h"
#include "ns3/log.h"
#include "ns3/trace-source-accessor.h"
#include "ns3/simulator.h"
#include "ns3/abort.h"
#include "ns3/node.h"

namespace ns3 {

NS_LOG_COMPONENT_DEFINE ("TcpMine");

NS_OBJECT_ENSURE_REGISTERED (TcpMine);

TypeId
TcpMine::GetTypeId (void)
{

  //***************************************** CHANGE THIS

  static TypeId tid = TypeId ("ns3::TcpMine")
    .SetParent<TcpSocketBase> ()
    .AddConstructor<TcpMine> ()
    .AddAttribute ("ReTxThreshold", "Threshold for fast retransmit",
                    UintegerValue (3),
                    MakeUintegerAccessor (&TcpMine::m_retxThresh),
                    MakeUintegerChecker<uint32_t> ())
    .AddTraceSource ("CongestionWindow",
                     "The TCP connection's congestion window",
                     MakeTraceSourceAccessor (&TcpMine::m_cWnd),
                     "ns3::TracedValue::Uint32Callback")
    .AddTraceSource ("SlowStartThreshold",
                     "TCP slow start threshold (bytes)",
                     MakeTraceSourceAccessor (&TcpMine::m_ssThresh),
                     "ns3::TracedValue::Uint32Callback")
  ;
  return tid;
}
//***************************************** CHANGE THIS

TcpMine::TcpMine (void) : m_retxThresh (3), m_inFastRec (false)
{
  NS_LOG_FUNCTION (this);
}

TcpMine::TcpMine (const TcpMine& sock)
  : TcpSocketBase (sock),
    m_cWnd (sock.m_cWnd),
    m_ssThresh (sock.m_ssThresh),
    m_initialCWnd (sock.m_initialCWnd),
    m_initialSsThresh (sock.m_initialSsThresh),
    m_retxThresh (sock.m_retxThresh),
    m_inFastRec (false)
{
  NS_LOG_FUNCTION (this);
  NS_LOG_LOGIC ("Invoked the copy constructor");
}

TcpMine::~TcpMine (void)
{
}

/* We initialize m_cWnd from this function, after attributes initialized */
int
TcpMine::Listen (void)
{
  NS_LOG_FUNCTION (this);
  InitializeCwnd ();
  return TcpSocketBase::Listen ();
}

/* We initialize m_cWnd from this function, after attributes initialized */
int
TcpMine::Connect (const Address & address)
{
  NS_LOG_FUNCTION (this << address);
  InitializeCwnd ();
  return TcpSocketBase::Connect (address);
}

/* Limit the size of in-flight data by cwnd and receiver's rxwin */
uint32_t
TcpMine::Window (void)
{
  NS_LOG_FUNCTION (this);
  return std::min (m_rWnd.Get (), m_cWnd.Get ());
}

Ptr<TcpSocketBase>
TcpMine::Fork (void)
{
  return CopyObject<TcpMine> (this);
}

/* New ACK (up to seqnum seq) received. Increase cwnd and call TcpSocketBase::NewAck() */
void
TcpMine::NewAck (const SequenceNumber32& seq)
{
  NS_LOG_FUNCTION (this << seq);
  NS_LOG_LOGIC ("TcpMine receieved ACK for seq " << seq <<
                " cwnd " << m_cWnd <<
                " ssthresh " << m_ssThresh);

  // Check for exit condition of fast recovery
  if (m_inFastRec)
    { // RFC2001, sec.4; RFC2581, sec.3.2
      // First new ACK after fast recovery: reset cwnd
      m_cWnd = m_ssThresh;
      m_inFastRec = false;
      NS_LOG_INFO ("Reset cwnd to " << m_cWnd);
    };

  // Increase of cwnd based on current phase (slow start or congestion avoidance)
  if (m_cWnd < m_ssThresh)
    { // Slow start mode, add one segSize to cWnd. Default m_ssThresh is 65535. (RFC2001, sec.1)
      m_cWnd += m_segmentSize;
      NS_LOG_INFO ("In SlowStart, updated to cwnd " << m_cWnd << " ssthresh " << m_ssThresh);
    }
  else
    { // For one full window the cWnd increases by 1/4 cWnd
      // Congestion avoidance mode, increase by (segSize*segSize)/cwnd. (RFC2581, sec.3.1)
      // To increase cwnd for one segSize per RTT, it should be (ackBytes*segSize)/cwnd
      // I do all this if cWnd is already really high
      if(m_cWnd.Get() >= 60000) {
        double adder = static_cast<double> (m_segmentSize * m_segmentSize) / m_cWnd.Get ();
        adder = std::max (1.0, adder);
        m_cWnd += static_cast<uint32_t> (adder);
      }
      // I slowly do exponential increase here as well if cWnd is not already high.
      else {
        m_cWnd += m_segmentSize/4;
      }
      NS_LOG_INFO ("In CongAvoid, updated to cwnd " << m_cWnd << " ssthresh " << m_ssThresh);
    }

  // Complete newAck processing
  TcpSocketBase::NewAck (seq);
}

// Fast recovery and fast retransmit
void
TcpMine::DupAck (const TcpHeader& t, uint32_t count)
{
  NS_LOG_FUNCTION (this << "t " << count);
  if (count == m_retxThresh && !m_inFastRec)
    { // triple duplicate ack triggers fast retransmit (RFC2581, sec.3.2)
      m_ssThresh = std::max (2 * m_segmentSize, 4*BytesInFlight () / 5);//changed
      m_cWnd = m_ssThresh;
      m_inFastRec = true;
      NS_LOG_INFO ("Triple dupack. Reset cwnd to " << m_cWnd << ", ssthresh to " << m_ssThresh);
      DoRetransmit ();
    }
  else if (m_inFastRec)
    { // In fast recovery, inc cwnd for every additional dupack (RFC2581, sec.3.2)
      m_cWnd += m_segmentSize/2;
      NS_LOG_INFO ("Increased cwnd to " << m_cWnd);
      SendPendingData (m_connected);
    };
}

// Retransmit timeout
void TcpMine::Retransmit (void)
{
  NS_LOG_FUNCTION (this);
  NS_LOG_LOGIC (this << " ReTxTimeout Expired at time " << Simulator::Now ().GetSeconds ());
  m_inFastRec = false;

  // If erroneous timeout in closed/timed-wait state, just return
  if (m_state == CLOSED || m_state == TIME_WAIT) return;
  // If all data are received (non-closing socket and nothing to send), just return
  if (m_state <= ESTABLISHED && m_txBuffer->HeadSequence () >= m_highTxMark) return;

  // According to RFC2581 sec.3.1, upon RTO, ssthresh is set to half of flight
  // size and cwnd is set to 1*MSS, then the lost packet is retransmitted and
  // TCP back to slow start
  m_ssThresh = std::max (2 * m_segmentSize, 3*BytesInFlight () / 4);//changed
  m_cWnd = std::max(m_cWnd.Get()/8, m_segmentSize);//changed
  m_nextTxSequence = m_txBuffer->HeadSequence (); // Restart from highest Ack
  NS_LOG_INFO ("RTO. Reset cwnd to " << m_cWnd <<
               ", ssthresh to " << m_ssThresh << ", restart from seqnum " << m_nextTxSequence);
  DoRetransmit ();                          // Retransmit the packet
}

void
TcpMine::SetSegSize (uint32_t size)
{
  NS_ABORT_MSG_UNLESS (m_state == CLOSED, "TcpMine::SetSegSize() cannot change segment size after connection started.");
  m_segmentSize = size;
}

void
TcpMine::SetInitialSSThresh (uint32_t threshold)
{
  NS_ABORT_MSG_UNLESS (m_state == CLOSED, "TcpMine::SetSSThresh() cannot change initial ssThresh after connection started.");
  m_initialSsThresh = threshold;
}

uint32_t
TcpMine::GetInitialSSThresh (void) const
{
  return m_initialSsThresh;
}

void
TcpMine::SetInitialCwnd (uint32_t cwnd)
{
  NS_ABORT_MSG_UNLESS (m_state == CLOSED, "TcpMine::SetInitialCwnd() cannot change initial cwnd after connection started.");
  m_initialCWnd = cwnd;
}

uint32_t
TcpMine::GetInitialCwnd (void) const
{
  return m_initialCWnd;
}

void
TcpMine::InitializeCwnd (void)
{
  /*
   * Initialize congestion window, default to 1 MSS (RFC2001, sec.1) and must
   * not be larger than 2 MSS (RFC2581, sec.3.1). Both m_initiaCWnd and
   * m_segmentSize are set by the attribute system in ns3::TcpSocket.
   */
  m_cWnd = m_initialCWnd * m_segmentSize;
  m_ssThresh = m_initialSsThresh;
}

} // namespace ns3
