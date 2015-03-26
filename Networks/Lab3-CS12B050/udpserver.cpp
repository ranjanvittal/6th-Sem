/* udpserver.cpp */

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
#include <map>

using namespace std;

#define ll long long

#define OVERALL_MAX 2000
#define BIG 1000000007
/*
Port No has to be given as command line argument
 */

struct Packet {
    int sequence_no;
    char value[OVERALL_MAX];
};

ll CURRENT_TIME() {
    timeval tv;
    gettimeofday(&tv, NULL);
    ll current_time = tv.tv_usec + tv.tv_sec*1000000;
    return current_time;
}

bool db = false;
int port_no = -1;
int sequence_no_length = -1;
int MAX_PACKETS = -1;
int WINDOW_SIZE = -1;
int BUFFER_SIZE = -1;
double PACKET_ERROR_RATE = -1;
ll pack_error_mod_number;
ll MAX_SEQUENCE_NO;
int current_buffer;

bool inbetween_sequence_no(int elem, int min, int max) {
    if(elem >= min && elem <= max)
        return true;
    if(max < WINDOW_SIZE-1 && (elem <= max || elem >= min))
        return true;
    return false;
}
int main(int argc, char *argv[]) {
    int sock, connected;
    int bytes_read;
    struct sockaddr_in server_addr, client_addr;
    int i;
    for(i = 1;i < argc; i++) {
        if(!strcmp(argv[i],"-d"))db=true;
        else if(!strcmp(argv[i],"-p")) {
            i++;
            port_no=atoi(argv[i]);
        }
        else if(!strcmp(argv[i],"-n")) {
            i++;
            sequence_no_length = atoi(argv[i]);
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
        else if(!strcmp(argv[i],"-e")) {
            i++;
            PACKET_ERROR_RATE = atof(argv[i]);
            pack_error_mod_number = (ll) 1.0/PACKET_ERROR_RATE;
        }
    }

    if((port_no == -1)
        ||(sequence_no_length == -1) || (PACKET_ERROR_RATE == -1)
        ||(MAX_PACKETS == -1)||(WINDOW_SIZE==-1)||(BUFFER_SIZE==-1)) {
        cout << "insufficient arguments given\n" <<"execution terminated\n";
        exit(0);
    }

    if ((sock = socket(AF_INET, SOCK_DGRAM, 0)) == -1) {
        perror("Socket");
        exit(1);
    }

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(port_no);
    server_addr.sin_addr.s_addr = INADDR_ANY;
    bzero(&(server_addr.sin_zero), 8);

    if (bind(sock, (struct sockaddr *) &server_addr,
            sizeof (struct sockaddr)) == -1) {
        perror("Bind");
        exit(1);
    }

    socklen_t addr_len = sizeof (struct sockaddr);
    printf("\nUDPServer Waiting for client on port %d\n", port_no);
    fflush(stdout);
    i = 0;
    int min_sequence_no = 0;
    int max_sequence_no = WINDOW_SIZE - 1;
    char ack[WINDOW_SIZE+1];
    ack[WINDOW_SIZE] = 0;
    for(i = 0; i < WINDOW_SIZE; i++)
        ack[i] = '0';

    MAX_SEQUENCE_NO = 1;
    for(i = 0; i < sequence_no_length; i++)
        MAX_SEQUENCE_NO = MAX_SEQUENCE_NO*2;

    i = 0;
    int next_to_receive = 0;
    map <int, ll> window_map;
    int l = 1;
    ll start_time;
    current_buffer = BUFFER_SIZE;
    while (i < MAX_PACKETS) {
        Packet packet;

        recvfrom(sock, &packet, OVERALL_MAX, 0,
                (struct sockaddr *) &client_addr, &addr_len);
        if(l) {
            start_time = CURRENT_TIME();
            l = 0;
        }
        //cout << "Sequence no : " << packet.sequence_no << "\n";

        int error_no = rand() % BIG;
        double error_match = PACKET_ERROR_RATE*BIG;

        //cout << "Error no : " << error << "\n";
        if(error_no > error_match) {
            if(inbetween_sequence_no(packet.sequence_no, min_sequence_no, max_sequence_no)) {


                int window_no;
                if(packet.sequence_no >= min_sequence_no)
                    window_no = packet.sequence_no - min_sequence_no;
                else
                    window_no = WINDOW_SIZE -1 - max_sequence_no + window_no;

                if(window_no != next_to_receive && current_buffer == 1) {
                    continue;
                }

                if(ack[window_no] == '0') {
                    ack[window_no] = '1';
                    i++;
                }

                current_buffer--;
                window_map[window_no] = CURRENT_TIME() - start_time;
                if(window_no == next_to_receive) {
                    int j = window_no;
                    while(j < WINDOW_SIZE && window_map.find(j) != window_map.end()) {
                        int sequence_no = (j + min_sequence_no)%MAX_SEQUENCE_NO;
                        if(db)
                            cout << "Seq " << sequence_no << ":\tTime Received: " << window_map[j]/1000 << ":" << window_map[j]%1000 << "\n";
                        j++;
                        current_buffer++;
                    }
                    next_to_receive = j%WINDOW_SIZE;
                }

                sendto(sock, ack,
                    WINDOW_SIZE, 0,
                    (struct sockaddr *) &client_addr,
                    sizeof (struct sockaddr)
                );
                int it;
                int ct = 0;

                for(it = 0; it < WINDOW_SIZE; it++)
                    if(ack[it] == '1')
                        ct++;

                if(ct == WINDOW_SIZE) {
                    for(it = 0; it < WINDOW_SIZE; it++)
                        ack[it] = '0';
                    min_sequence_no = (min_sequence_no + WINDOW_SIZE)%(MAX_SEQUENCE_NO);
                    max_sequence_no = (max_sequence_no + WINDOW_SIZE)%(MAX_SEQUENCE_NO);
                    window_map.erase(window_map.begin(), window_map.end());
                    current_buffer = BUFFER_SIZE;
                }
            }
        }
    }
    return 0;
}
