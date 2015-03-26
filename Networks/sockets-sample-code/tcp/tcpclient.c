/* tcpclient.c */

#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <netdb.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <ctype.h>
#include <dirent.h>

/*
argv[2]: ipaddress of server
argv[1]: port no of server
 */
#define LS 1
#define CD 2
#define LCD 3
#define GET 4
#define PUT 5
#define PWD 6
#define QUIT 7
typedef struct command command_type;
#define MAX_LENGTH 300

struct command {
    int code;
    char* name;
};

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

int parse_name(char* p) {
    char* s = p;
    remove_whitespace(&s);
    char name[MAX_LENGTH];
    if(*s == '\0')
        return 1;
    if(!((*s >= 'a' && *s <= 'z') || (*s == '.') || (*s == '/') || (*s == '~')))
        return -1;
    while((*s >= '0' && *s <= '9') || (*s >= 'a' && *s <= 'z') || (*s == '.') || (*s == '/') || (*s == '~')) {
        s++;
    }
    remove_whitespace(&s);
    if(*s == '\0')
        return 1;
    printf("%s\n", s);
    return -1;
}

struct command parse(char* s) {
    remove_whitespace(&s);
    struct command com;
    if(s[0] == 'l' && s[1] == 's') {
        com.name = strdup(s + 2);
        com.code = LS;
        if(*(s+2) != ' ' && *(s+2) != '\0') {
            printf("Error\n");
            com.code = -1;
            return com;
        }
        remove_whitespace(&s);
        if(parse_name(s) == 1) {
            return com;
        }
        else {
            printf("%sError\n", s + 2);
            com.code = -1;
            return com;
        }
    }
    if(s[0] == 'c' && s[1] == 'd') {
        com.code = CD;
        com.name = strdup(s + 2);
        if(*(s+2) != ' ' && *(s+2) != '\0') {
            printf(" Error %d \n", *(s+2));
            com.code = -1;
            return com;
        }
        if(parse_name(s+2) == 1) {
            return com;
        }
        else {
            printf("Error\n");
            com.code = -1;
            return com;
        }
    }
    if(s[0] == 'l' && s[1] == 'c' && s[2] == 'd') {
        com.code = LCD;
        com.name = strdup(s + 3);
        if(*(s+3) != ' ' && *(s+3) != '\0') {
            printf("Error %d \n", *(s+3));
            com.code = -1;
            return com;
        }
        if(parse_name(s+3) == 1) {
            return com;
        }
        else {
            printf("Error\n");
            com.code = -1;
            return com;
        }
    }

    if(s[0] == 'g' && s[1] == 'e' && s[2] == 't') {
        com.code = GET;
        com.name = strdup(s+3);
        if(*(s+3) != ' ' && *(s+3) != '\0') {
            printf("Error\n");
            com.code = -1;
            return com;
        }
        if(parse_name(s+3) == 1) {
            return com;
        }
        else {
            printf("Error\n");
            com.code = -1;
            return com;
        }
    }

    if(s[0] == 'p' && s[1] == 'u' && s[2] == 't') {
        com.code = PUT;
        com.name = strdup(s+3);
        if(*(s+3) != ' ' && *(s+3) != '\0') {
            printf("Error\n");
            com.code = -1;
            return com;
        }
        if(parse_name(s+3) == 1) {
            return com;
        }
        else {
            printf("Error\n");
            com.code = -1;
            return com;
        }
    }

    if(s[0] == 'p' && s[1] == 'w' && s[2] == 'd') {
        com.code = PWD;
        remove_whitespace(&s);
        s = s+3;
        if(*s == '\0') {
            return com;
        }
        else {
            printf("Error\n");
            com.code = -1;
            return com;
        }
    }

    if(s[0] == 'q' && s[1] == 'u' && s[2] == 'i' && s[3] == 't') {
        com.code = QUIT;
        s = s+4;
        remove_whitespace(&s);
        if(*s == '\0') {
            return com;
        }
        else {
            printf("fError *s\n");
            com.code = -1;
            return com;
        }
    }
    printf("Error\n");
    exit(0);
}

char* convert(command_type com) {
    if(com.code == LS) {
        char p[MAX_LENGTH];
        strcpy(p, "NLST ");
        return strdup(strcat(p, com.name));
    }
    if(com.code == CD) {
        char p[MAX_LENGTH];
        strcpy(p, "CWD ");
        return strdup(strcat(p, com.name));
    }
    if(com.code == GET) {
        char p[MAX_LENGTH];
        strcpy(p, "RETR ");
        return strdup(strcat(p, com.name));
    }
    if(com.code == PUT) {
        char p[MAX_LENGTH];
        strcpy(p, "STOR ");
        return strdup(strcat(p, com.name));
    }

    if(com.code == PWD)
        return strdup("PWD");
    if(com.code == QUIT)
        return strdup("QUIT");
}

int
main(int argc, char *argv[]) {

    int sock, bytes_received, connected;
    char send_data[1024], recv_data[1024];
    struct hostent *host;
    struct sockaddr_in server_addr;
    int sin_size;
    if (argc < 3) {
        printf("Enter PortNo");
        exit(0);
    }

    host = gethostbyname(argv[1]);

    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
        perror("Socket");
        exit(1);
    }

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(atoi(argv[2]));
    server_addr.sin_addr = *((struct in_addr *) host->h_addr);
    bzero(&(server_addr.sin_zero), 8);

    if (connect(sock, (struct sockaddr *) &server_addr,
            sizeof (struct sockaddr)) == -1) {
        perror("Connect");
        exit(1);
    }

    while(1) {
        command_type command1;
        char s[MAX_LENGTH];
        char p[MAX_LENGTH];
        char f[MAX_LENGTH];
        int send_data = 0;
        int current_send;
        f[0] = '\0';
        int i = 0;
        s[0] = getc(stdin);
        while(s[i] != '\n') {
            s[++i] = getc(stdin);
        }
        s[i] = '\0';
        command1 = parse(s);
        strcpy(p, convert(command1));

        sin_size = sizeof (struct sockaddr_in);
        if(command1.code == LCD){}
        else {
            mysend(p, sock);
            if(command1.code == GET){
                char* s = command1.name;
                remove_whitespace(&s);
                FILE* fp = fopen(s, "a");
                char receive_data[MAX_LENGTH];
                myrecv(receive_data, sock);
                fprintf(fp, "%s", receive_data);
                fclose(fp);

            }
            else if(command1.code == PUT){}
            else if(command1.code == CD){
                char dummy[343];
                myrecv(dummy, sock);
                if(dummy[0] == 'E')
                    printf("%s\n", dummy);
            }
            else if(command1.code == PWD){
                char result[MAX_LENGTH];
                myrecv(result, sock);
                printf("%s\n", result);
            }
            else if(command1.code == LS) {
                char listing[MAX_LENGTH];
                myrecv(listing, sock);
                printf("%s",listing);
            }
    // #define LS 1
    // #define CD 2
    // #define LCD 3
    // #define GET 4
    // #define PUT 5
    // #define PWD 6
    // #define QUIT 7
            else if(command1.code == QUIT) {
                printf("Exiting ...\n");
                exit(0);
            }


        }

    }

    close(sock);

    return 0;
}
