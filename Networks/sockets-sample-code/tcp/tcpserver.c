/* tcpserver.c */

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>
#include <dirent.h>

#define MAX_LENGTH 1030
#define NLST 1
#define CWD 2
#define RETR 3
#define STOR 4
#define QUIT 5
#define PWD 6

void myrecv(char* receive_data, int connected) {
    char recv_data[MAX_LENGTH];
    int bytes_received = 0, bytes = 0;
    recv(connected, recv_data, 1, 0);
    receive_data[0] = recv_data[0];
    recv(connected, recv_data, 1, 0);
    receive_data[1] = recv_data[0];
    receive_data[2] = '\0';
    bytes_received = 2;
    while (1) {
        bytes = recv(connected, recv_data, 1024, 0);
        recv_data[bytes] = '\0';
        bytes_received += bytes;
        strcat(receive_data, recv_data);
        if(receive_data[bytes_received - 2] == '@' && receive_data[bytes_received - 1] == '$')
            break;
    }
    receive_data[bytes_received-2] = '\0';
}

void mysend(char* send1, int connected) {
    char send_data[MAX_LENGTH];
    strcpy(send_data, send1);
    strcat(send_data, "@$");
    int len = strlen(send_data);
    int bytes_sent = 0, bytes = 0;
    while(bytes_sent != len) {
        bytes = send(connected, send_data + bytes_sent, len - bytes_sent, 0);
        bytes_sent += bytes;
    }
}

int remove_whitespace(char** s) {
    while(*(*s) == ' ' || *(*s) == '\t' || *(*s) == '\n') {(*s)++;}
    return 1;
}

int
main(int argc, char *argv[]) {
    int sock, connected, bytes_received, true = 1;
    char send_data[1024], recv_data[1024];

    struct sockaddr_in server_addr, client_addr;
    int sin_size;
    if (argc < 2) {
        printf("Enter PortNo");
        exit(0);
    }

    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
        perror("Socket");
        exit(1);
    }

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(atoi(argv[1]));
    server_addr.sin_addr.s_addr = INADDR_ANY;
    bzero(&(server_addr.sin_zero), 8);

    if (bind(sock, (struct sockaddr *) &server_addr, sizeof (struct sockaddr)) == -1) {
        perror("Unable to bind");
        exit(1);
    }

    if (listen(sock, 5) == -1) {
        perror("Listen");
        exit(1);
    }

    printf("\nTCPServer Waiting for client on port %s\n", argv[1]);
    fflush(stdout);

    sin_size = sizeof (struct sockaddr_in);
    connected = accept(sock, (struct sockaddr *) &client_addr, &sin_size);
    printf("\n I got a connection from (%s , %d)\n", inet_ntoa(client_addr.sin_addr), ntohs(client_addr.sin_port));
    char receive_command[MAX_LENGTH];
    receive_command[0] = '\0';
    bytes_received = 0;
    while(1) {
        myrecv(receive_command, connected);
        char* s;
        char listing[MAX_LENGTH];
        listing[0] = '\0';
        s = receive_command;
        if(receive_command[0] == 'N') {
            s = s+4;
            remove_whitespace(&s);
            DIR *dir;
            struct dirent *dp;
            char * file_name;
            if(*s == '\0') {
                dir = opendir(".");
            }
            else
                dir = opendir(s);
            while ((dp=readdir(dir)) != NULL) {
                if ( !strcmp(dp->d_name, ".") || !strcmp(dp->d_name, "..") || !strcmp(dp->d_name, ".DS_Store")){}
                else {
                    file_name = dp->d_name; // use it
                    strcat(listing, file_name);
                    strcat(listing, "\n");
                }
            }
            closedir(dir);
            mysend(listing, connected);
        }
    // #define NLST 1 -
    // #define CWD 2 -
    // #define RETR 3
    // #define STOR 4
    // #define QUIT 5 ---
    // #define PWD 6 ---
        if(*s == 'Q') {
            printf("Exiting ...\n");
            exit(0);
        }
        if(*s == 'C') {
            s = s+3;
            remove_whitespace(&s);
            printf(":%s\n", s);
            if(chdir(s) < 0) {
                mysend("Error\n", connected);
            }
            else
                mysend("Success\n", connected);
        }
        if(*s == 'P') {
            char name[MAX_LENGTH];
            getcwd(name, MAX_LENGTH-4);
            mysend(name, connected);
        }
        if(*s == 'R') {
            s = s+4;
            remove_whitespace(&s);
            FILE* fp = fopen(s, "r");
            char send_data[MAX_LENGTH];
            int len = 0;
            while(!eof(fp)) {
                char a = fgetc(fp);
                send_data[len++] = a;
            }
            send_data[len] = '\0';
            mysend(send_data, connected);
        }
    }

    close(connected);
    close(sock);
    return 0;
}
