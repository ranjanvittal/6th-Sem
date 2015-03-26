/* udpserver.c */


#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>
#include <stdlib.h>



/*
Port No has to be given as command line argument
 */

struct s {
    int g;
};
int f(struct s a){return 1;}

int main() {
    int* a;
    f(a);
    return 0;
}
