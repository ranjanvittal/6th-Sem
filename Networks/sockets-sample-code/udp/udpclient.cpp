/* udpclient.c */

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <stdio.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>
#include <stdlib.h>

/*
Command Line Arguments
Port No :argv[1]
IP address :argv[2]
 */

int BUFFER_SIZE;
int WINDOW_SIZE;
int MAX_PACKETS;

struct Packet {
    int sequence_no;
    char* value;
};

int main(int argc, char *argv[]) {
    int sock;
    struct sockaddr_in server_addr;
    struct hostent *host;
    char send_data[1024];

    if (argc < 2) {
        printf("Enter PortNo");
        exit(0);
    }

    host = (struct hostent *) gethostbyname((char *) argv[2]);

    if ((sock = socket(AF_INET, SOCK_DGRAM, 0)) == -1) {
        perror("socket");
        exit(1);
    }

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(atoi(argv[1]));
    server_addr.sin_addr = *((struct in_addr *) host->h_addr);
    bzero(&(server_addr.sin_zero), 8);

    int i = 0;
    MAX_PACKETS = 10;
    WINDOW_SIZE = 5;
    socklen_t addr_len = sizeof (struct sockaddr);
    while (i < MAX_PACKETS) {
        printf("Type a word to send(q or Q to quit):");
        Packet packet;
        int ack;
        scanf("%s", send_data);
        packet.sequence_no = i%WINDOW_SIZE;
        //packet.value = gen_junk();
        packet.value = send_data;
        printf("Here\n");

        sendto(sock, (void*) &packet, sizeof(packet), 0,
            (struct sockaddr *) &server_addr, sizeof (struct sockaddr));

        printf("Here\n");

        recvfrom(sock, &ack, 1024, 0,
                (struct sockaddr *) &server_addr, &addr_len);
        printf("ack %d received\n", ack);
        i++;
    }
}
