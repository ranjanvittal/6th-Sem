/* ftpserver.c */

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

int remove_whitespace(char** s) {
    while(*(*s) == ' ' || *(*s) == '\t' || *(*s) == '\n') {(*s)++;}
    return 1;
}

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

void receive_file(char* s, int connected)
{
    char* p = s;
    remove_whitespace(&p);
    FILE* fp = fopen(p, "w");
    char receive_data[MAX_LENGTH];
    int i;
    for(i = 0; i < MAX_LENGTH; i++)
        receive_data[i] = 0;
    char a = 0;
    char b = 0;
    int len = 0;
    while(1) {
        len = recv(connected, receive_data, 1000, 0);
        receive_data[len] = 0;
        b = receive_data[0];

        if(len == 1 && a == '@' && b == '$')
            break;
        if(len>=2 && receive_data[len-2] == '@' && receive_data[len-1] == '$') {
            int i = 0;
            while(i < len - 2)
                fputc(receive_data[i++], fp);
            break;
        }
        a = receive_data[len-1];
        int i = 0;
        while(i < len) {
            fputc(receive_data[i++], fp);
        }
    }
    fclose(fp);
}

void send_file(FILE* fp, int connected)
{
    char send_data[MAX_LENGTH];

    int len = 0;
    int jj = 1000;
    while(1) {
        send_data[0] = '\0';
        int i = 0;
        int fl = 0;
        //printf("Point  7 %d\n",jj++);

        while(i < 1000) {
          //  printf("Point 11 %d\n",jj++);

            char x[2];
            char a = fgetc(fp);
            if(feof(fp)) {
                fl = 1;
                break;
            }
            //printf("Point 12:%c: %d %d\n",a,jj++,i);

            x[0] = a;
            x[1] = '\0';

            strcat(send_data, x);
            //printf("Point 13 %d\n",jj++);

            i++;
        }
        //printf("%s\n", send_data);
        int ii=0;
        len = 0;
        int length = strlen(send_data);
        while(len < strlen(send_data)) {
            len += send(connected, send_data + len, length - len, 0);
        }
        //printf("Point 1\n")
        //printf("Point 6  %d\n",jj++);

        if(fl == 1)
            break;
    }
    //printf("Point 4 %d\n",jj++);

    send(connected, "@", 1, 0);
    send(connected, "$", 1, 0);
    fclose(fp);
}

int check_home_and_current(char* home) {
    char* home_id = home;
    char current1[1000];
    char* current;
    getcwd(current1, MAX_LENGTH-4);
    current = current1;
    while(*home_id == *current && *home_id != 0) {
        home_id++;
        current++;
    }
    return *home_id == 0;
}



int
main(int argc, char *argv[]) {
    int sock, connected, bytes_received, true = 1;
    char send_data[1024], recv_data[1024];

    struct sockaddr_in server_addr, client_addr;
    unsigned int sin_size;
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
    char home[MAX_LENGTH];
    getcwd(home, MAX_LENGTH-4);
    while(1) {

        myrecv(receive_command, connected);
        char* s;
        char cwd[1000];
        getcwd(cwd, MAX_LENGTH-4);
        char listing[MAX_LENGTH];
        listing[0] = '\0';
        s = receive_command;
        printf("%s\n", s);
        if(receive_command[0] == 'N') {
            s = s+4;
            remove_whitespace(&s);
            if(*s == '~') {
                s++;
                chdir(home);
                remove_whitespace(&s);
            }
            if(*s == '/') {
                chdir(home);
                s++;
            }

            remove_whitespace(&s);
            DIR *dir;
            struct dirent *dp;
            char * file_name;
            if(*s == '\0') {
                dir = opendir(".");
            }
            else
                dir = opendir(s);
            if(dir == NULL)
                send(connected, "N", 1, 0);
            else {
                send(connected, "Y", 1, 0);
                while ((dp=readdir(dir)) != NULL) {
                    if ( !strcmp(dp->d_name, ".") || !strcmp(dp->d_name, "..") || !strcmp(dp->d_name, ".DS_Store")){}
                    else {
                        file_name = dp->d_name; // use it
                        strcat(listing, file_name);
                        strcat(listing, "\n");
                    }
                }
                closedir(dir);
                strcat(listing, "\n");
                mysend(listing, connected);
            }
            chdir(cwd);
        }
        // #define NLST 1 -
        // #define CWD 2 ---
        // #define RETR 3 -
        // #define STOR 4
        // #define QUIT 5 ---
        // #define PWD 6 ---
        else if(*s == 'Q') {
            printf("Exiting ...\n");
            exit(0);
        }
        else if(*s == 'C') {
            s = s+3;
            remove_whitespace(&s);
            if(*s == '\0')
                chdir(home);
            if(*s == '~') {
                s++;
                remove_whitespace(&s);
            }
            if(*s == '/') {
                chdir(home);
                s++;
            }

            remove_whitespace(&s);
            if(*s == 0) {
                chdir(home);
                mysend("/", connected);
                strcpy(cwd, home);
                continue;
            }

            if(chdir(s) < 0) {
                printf("E1\n");
                mysend("@\n", connected);
            }
            else {

                int flag = check_home_and_current(home);
                if(flag) {
                    char name[100];
                    getcwd(name, 90);
                    char* s1 = name;
                    char* home_id = home;
                    while(*s1 == *home_id && *home_id != 0) {
                        s1++;
                        home_id++;
                    }
                    if(*s1 != 0)
                        mysend(s1, connected);
                    else
                        mysend("/", connected);
                    strcpy(cwd, name);
                }
                else {
                    printf("E2\n");
                    mysend("@\n", connected);
                    chdir(cwd);
                }

            }
        }
        else if(*s == 'P') {
            char name[MAX_LENGTH];
            getcwd(name, MAX_LENGTH-4);
            char* s1 = name;
            char* home_id = home;
            while(*s1 == *home_id && *home_id != 0) {
                s1++;
                home_id++;
            }
            if(*s1 != 0)
                mysend(s1, connected);
            else
                mysend("/", connected);
        }
        else if(*s == 'R') {
            s = s+4;
            remove_whitespace(&s);
            FILE* fp = fopen(s, "r");
            if(fp == NULL) {
                mysend("Error\n", connected);
            }
            else {
                mysend("File Name Ok\n", connected);
                send_file(fp, connected);
            }
        }
        else if(*s == 'S') {
            char flag[2];
            s = s + 4;
            remove_whitespace(&s);
            recv(connected, flag, 1, 0);
            if(flag[0] == 'Y')
                receive_file(s, connected);
        }
    }

    close(sock);
    close(connected);
    return 0;
}
