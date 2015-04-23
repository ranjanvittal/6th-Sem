/* udpclient.cpp */

#include <sys/types.h>
#include <sys/socket.h>
#include <sys/select.h>
#include <sys/time.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <stdio.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>
#include <stdlib.h>
#include <fcntl.h>
#include <iostream>
#include <list>

using namespace std;
#define ll long long
ll CURRENT_TIME() {
    timeval tv;
    gettimeofday(&tv, NULL);
    ll current_time = tv.tv_usec + tv.tv_sec*1000000;
    return current_time;
}

timeval select_time_out;
ll TIME_OUT = 300000;
#define OVERALL_MAX 2000

ll start_time;
// int sequence_no_wraparound;
// int window_wraparound;
// #define SEQUENCE_NO_TO_WINDOW_NO(sequence_no) ((sequence_no_wraparound*MAX_SEQUENCE_NO + sequence_no)%WINDOW_SIZE)
// #define WINDOW_NO_TO_SEQUENCE_NO(window_no) ((window_wraparound*WINDOW_SIZE + window_no)%MAX_SEQUENCE_NO)

/*
Command Line Arguments
Port No :argv[1]
IP address :argv[2]
 */


// UDP connections and server address.
int sock;
struct sockaddr_in server_addr;
socklen_t addr_len = sizeof (struct sockaddr);


//parameters
bool db = false;
char receiver_name_or_ip[50] = {0};
int port_no = -1;
int sequence_no_length;
int MAX_PACKET_LENGTH;
int PACKET_GEN_RATE;
int MAX_PACKETS;
int WINDOW_SIZE;
int BUFFER_SIZE;
int MAX_WINDOW;
int MAX_SEQUENCE_NO;
ll retransmissions = 0;
ll sum_packet_length = 0;

// Packet structure
struct Packet {
    int sequence_no;
    char value[OVERALL_MAX];
    int message_size;
    ll expiry_time;
    int packet_no;
    int number_of_sends;
    ll first_send;
    ll generated_time;

    int size() {
        return message_size + 4;
    }

    bool check_expired() {
        if(number_of_sends > 0 )
            return expiry_time < CURRENT_TIME();
        return false;
    }

    int window() {
        return packet_no/WINDOW_SIZE;
    }
};




list<Packet> sender_list;

ll next_packet_gen;
ll next_packet = 0;
int current_window = 0;
int ack_received_in_current_window = 0;
int overall_ack_received = 0;
ll sum_rtt = 0;

void send_sender_list() {
    int i;
    list<Packet>::iterator it;
    for(it = sender_list.begin(); it != sender_list.end(); it++) {
        bool check_current_window = (*it).window() == current_window;
        bool if_expired =  check_current_window && (*it).check_expired();
        bool if_not_sent = check_current_window && !(*it).number_of_sends;
        bool to_be_sent = if_expired || if_not_sent;

        if(to_be_sent) {
            if((*it).number_of_sends == 10) {
                ll average_rtt = sum_rtt/overall_ack_received;
                ll end_time = CURRENT_TIME();
                double total_time = (end_time - start_time)*1.0/1000000;
                int packet_gen_rate = next_packet/total_time;
                printf("Packet %d with sequence no %d exceeded maximum number of sends\n", (*it).packet_no, (*it).sequence_no);
                cout << "Packet gen rate : " << packet_gen_rate << "\n";
                cout << "Average Packet length : " << sum_packet_length/next_packet << "\n";
                cout << "Retransmission ratio : " << 1 + retransmissions*1.0/overall_ack_received << "\n";
                cout << "Average RTT : " << average_rtt / 1000 << " : " << average_rtt%1000 << "\n";
                exit(0);
            }

            if(if_expired) {
                // cout << "Packet " << (*it).packet_no << " expired\n";
                retransmissions++;
            }
            if(if_not_sent)
                (*it).first_send = CURRENT_TIME();



            // cout << "Sender list sequence no : " << (*it).sequence_no << "\n";
            sendto(sock, (void*) &(*it), (*it).size(), 0,
            (struct sockaddr *) &server_addr, sizeof (struct sockaddr));
            (*it).number_of_sends++;
            (*it).expiry_time = CURRENT_TIME() + TIME_OUT;

            // cout << "\n\n";
        }
    }

}
ll GEN_PACKET_TIME;

void packet_gen() {

    if(CURRENT_TIME() >= next_packet_gen) {
        // cout << (next_packet_gen - start_time)/1000000.0 << "\n";
        // cout << (CURRENT_TIME() - start_time)/1000000.0 << "\n";
        ll packets_number = (CURRENT_TIME() - next_packet_gen)/GEN_PACKET_TIME + 1;
        int i;
        // cout << "Packets number : " << packets_number << "\n";
        for(i = 0; i < packets_number; i++) {
            Packet* new_packet = new Packet;
            new_packet->message_size = (rand() % (MAX_PACKET_LENGTH - 40 + 1)) + 40;
            new_packet->number_of_sends = 0;

            if(sender_list.size() < BUFFER_SIZE) {
                new_packet->packet_no = next_packet;
                new_packet->sequence_no = next_packet%(MAX_SEQUENCE_NO);
                new_packet->generated_time = CURRENT_TIME();
                // cout << "Next packet : " << next_packet << "\n";
                next_packet++;
                sender_list.push_back(*new_packet);
            }
            else {
                delete new_packet;
                break;
            }
        }
        if( i != packets_number)
            next_packet_gen = next_packet_gen + i*GEN_PACKET_TIME;
        else
            next_packet_gen = CURRENT_TIME() + GEN_PACKET_TIME;
        // cout << (next_packet_gen - start_time)/1000000.0 << "\n";
        // cout << "\n\n";
    }

}

void receive_acks() {
    fd_set read_flags;

    FD_ZERO(&read_flags);

    FD_SET(sock, &read_flags);
    while(1) {
        select(sock+1, &read_flags, (fd_set*) 0,(fd_set*) 0, &select_time_out);
        char ack[WINDOW_SIZE];
        if(FD_ISSET(sock, &read_flags)) {
            recvfrom(sock, ack, 1040, 0,
                (struct sockaddr *) &server_addr, &addr_len);
            ack[WINDOW_SIZE] = 0;
            // cout << "Ack received in receive_acks : " << ack << "\n";

            list<Packet>::iterator it;
            // cout << "Sender size in receive_acks : " << sender_list.size() << "\n";
            for(it = sender_list.begin(); it != sender_list.end();) {
                if(ack[((*it).packet_no)%WINDOW_SIZE] == '1' && (*it).window() == current_window) {
                    ack_received_in_current_window++;
                    overall_ack_received++;
                    ll sequence_no = (*it).sequence_no;
                    ll received_time = CURRENT_TIME();

                    ll rtt =  received_time - (*it).first_send;
                    sum_rtt = sum_rtt + rtt;
                    if(overall_ack_received == 10)
                        TIME_OUT = sum_rtt/5;
                    if(db) {
                        ll generated_time_less_start_time = (*it).generated_time - start_time;
                        cout << "Seq "<<sequence_no << ":\t" << "Time Generated: " << generated_time_less_start_time/1000;
                        cout << ":" << generated_time_less_start_time%1000 << "\tRTT: "<< rtt/1000 << ":" << rtt%1000;
                        cout <<"\tNumber of Attempts: " << (*it).number_of_sends << "\n";
                    }
                    sum_packet_length += (*it).size();
                    it = sender_list.erase(it);
                }
                else
                    it++;
            }
            // cout << "\n\n";
        }
        else
            break;
    }

}

bool check_all_ack_received() {
    return ack_received_in_current_window == WINDOW_SIZE;
}

void move_to_next_window() {
    current_window++;
    // cout << current_window << "\n";
    // cout << MAX_WINDOW << "\n";
    if(current_window >= MAX_WINDOW) {
        printf("All packets transmitted successfully\n");
        ll average_rtt = sum_rtt/overall_ack_received;
        ll end_time = CURRENT_TIME();
        double total_time = (end_time - start_time)*1.0/1000000;
        // cout << total_time << "\n";
        int packet_gen_rate = next_packet/total_time;
        cout << "Packet gen rate : " << packet_gen_rate << "\n";
        cout << "Average Packet length : " << sum_packet_length/MAX_PACKETS << "\n";
        cout << "Retransmission ratio : " << 1 + retransmissions*1.0/MAX_PACKETS << "\n";
        cout << "Average RTT : " << average_rtt / 1000 << " : " << average_rtt%1000 << "\n";
        exit(0);
    }
    ack_received_in_current_window = 0;
}




int main(int argc, char *argv[]) {
    struct hostent *host;
    char send_data[1024];
    fd_set read_flags, write_flags;
    int i;
    for(i = 1;i < argc; i++) {
        if(!strcmp(argv[i],"-d"))
            db=true;
        else if(!strcmp(argv[i],"-s")) {
            i++;
            strcpy(receiver_name_or_ip,argv[i]);
        }
        else if(!strcmp(argv[i],"-p")) {
            i++;
            port_no = atoi(argv[i]);
        }
        else if(!strcmp(argv[i],"-n")) {
            i++;
            sequence_no_length = atoi(argv[i]);
        }
        else if(!strcmp(argv[i],"-L")) {
            i++;
            MAX_PACKET_LENGTH = atoi(argv[i]);
        }
        else if(!strcmp(argv[i],"-R")) {
            i++;
            PACKET_GEN_RATE=atoi(argv[i]);
        }
        else if(!strcmp(argv[i],"-N")) {
            i++;
            MAX_PACKETS = atoi(argv[i]);
        }
        else if(!strcmp(argv[i],"-W")) {
            i++;
            WINDOW_SIZE = atoi(argv[i]);
        }
        else if(!strcmp(argv[i],"-B")) {
            i++;
            BUFFER_SIZE = atoi(argv[i]);
        }
    }

    if(!strlen(receiver_name_or_ip) || (port_no == -1)
        || (sequence_no_length == -1) || (MAX_PACKET_LENGTH == -1) || (PACKET_GEN_RATE == -1)
        || (MAX_PACKETS == -1) || (WINDOW_SIZE == -1) || (BUFFER_SIZE == -1)
    ) {
        // cout << "insufficient arguments given\n" <<"execution terminated\n";
        exit(0);
    }

    host = (struct hostent *) gethostbyname(receiver_name_or_ip);

    if ((sock = socket(AF_INET, SOCK_DGRAM, 0)) == -1) {
        perror("socket");
        exit(1);
    }

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(port_no);
    server_addr.sin_addr = *((struct in_addr *) host->h_addr);
    bzero(&(server_addr.sin_zero), 8);

    i = 0;

    MAX_WINDOW = MAX_PACKETS/WINDOW_SIZE;
    GEN_PACKET_TIME = 1000000.0/PACKET_GEN_RATE;

    int fcntl_flags;
    if ((fcntl_flags = fcntl(sock, F_GETFL, 0)) < 0)
    {
        printf("fcntl failed !\n");
        exit(0);
    }


    if (fcntl(sock, F_SETFL, fcntl_flags | O_NONBLOCK) < 0)
    {
        printf("fcntl failed !\n");
        exit(0);
    }

    MAX_SEQUENCE_NO = 1;
    for(i = 0; i < sequence_no_length; i++)
        MAX_SEQUENCE_NO *= 2;

    select_time_out.tv_sec = 0;
    select_time_out.tv_usec = 5;
    start_time = CURRENT_TIME();

    // cout << start_time << "\n";
    next_packet_gen = CURRENT_TIME();
    while (1) {
        receive_acks();
        packet_gen();
        send_sender_list();
        if(check_all_ack_received())
            move_to_next_window();
        //usleep(100*1000);
    }
}
struct Hello {
    int id;

    int edge[1];
} ;

Node* p = malloc(sizeof(Node) + ... )
