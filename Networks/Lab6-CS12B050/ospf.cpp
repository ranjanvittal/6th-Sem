#include <iostream>
#include <cstdlib>
#include <pthread.h>
#include <unistd.h>
#include <mutex>
#include <sys/types.h>
#include <sys/socket.h>
#include <sys/select.h>
#include <sys/time.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <stdlib.h>
#include <fcntl.h>
#include <list>
#include <vector>
#include <map>
#include <fstream>
#include <queue>
#include <utility>

using namespace std;

#define ll long long
#define NUM_THREADS 4
mutex mass;

volatile int c = 1;

int sock;
struct sockaddr_in send_addr;
socklen_t addr_len = sizeof (struct sockaddr);

volatile int* parent;
volatile int* cost;

void mysend(void* object, int size, int id) {
    send_addr.sin_port = htons(20000 + id);
    sendto(sock, (void*) object, size, 0,
        (struct sockaddr *) &send_addr, sizeof (struct sockaddr));
}

int my_recv(void* gen) {
    return recvfrom(sock, gen, 1040, MSG_DONTWAIT,
        (struct sockaddr *) &send_addr, &addr_len);
}

ll CURRENT_TIME() {
    timeval tv;
    gettimeofday(&tv, NULL);
    ll current_time = tv.tv_usec + tv.tv_sec*1000000;
    return current_time;
}



// parameters

int graph_size;
int current_node;
long long int hello_interval = 1000000 ;
long long int lsa_interval = 2000000 ;
long long int djikstra_interval = 5000000;
long long int overall_stop;

// node information

volatile int* adjacency;


vector<int> neighbour_list;

map<int, int> neighbour_lower_costs;

map<int, int> neighbour_upper_costs;

int neighbour_size;

// Listen usage
map<int, int> sequence_no_map;





int access(int i, int j) {
    return adjacency[graph_size*i + j];
}

#define set(i, j, expr) { adjacency[(graph_size)*(i) + (j)] = (expr);}

struct Hello {
   int srcid;
};

struct HelloReceive {
   int j;
   int i;
   int cost;
};

struct LSA {
   int srcid;
   int sequence_no;
   int number_of_entries;
   int neighbour[1];
};

// Node LSA

LSA* mylsa;
int mylsa_size;

// void *wait(void *t)
// {
//    int i;
//    long tid;

//    tid = (long)t;

//    mtx.lock();
//    cerr << "Sleeping in thread " << endl;
//    cerr << "Thread with id : " << tid << "  ...exiting " << endl;
//    mtx.unlock();
//    pthread_exit(NULL);
// }

void* gen = (void*) malloc(1040);

void *my_listen(void* useless) {
   while(CURRENT_TIME() < overall_stop) {
        int size = my_recv(gen);

        if(size == sizeof(Hello)) {
            // hello
            Hello* h = (Hello*) gen;
            int node = h->srcid;
            HelloReceive hr;
            hr.j = current_node;
            hr.i = node;
            c = 34;
            int low_cost = neighbour_lower_costs[node];
            int high_cost = neighbour_upper_costs[node];
            int diff = high_cost - low_cost + 1;
            int cost;

            if(diff == 1)
                cost = high_cost;
            else
                cost = low_cost + (rand() % diff);

            hr.cost = cost;

            mysend((void*) &hr, sizeof(hr), node);
        }
        else if(size == sizeof(HelloReceive)) {
            HelloReceive* hr = (HelloReceive*) gen;
            int node = hr->j;
            mass.lock();
            set(node, current_node, hr->cost);
            set(current_node, node, hr->cost);
            mass.unlock();
        }
        else if(size > sizeof(HelloReceive)){
            //lsa receive
            LSA* lsa = (LSA*) gen;
            int node = lsa->srcid;
            int sequence_no = lsa->sequence_no;
            int number_of_entries = lsa->number_of_entries;
            int i;
            int node2;
            int nodecost;

            if(sequence_no > sequence_no_map[node]) {
                mass.lock();
                for(i = 0; i < number_of_entries; i++) {
                    node2 = lsa->neighbour[i];
                    nodecost = lsa->neighbour[i+number_of_entries];
                    set(node2, node, nodecost);
                    set(node, node2, nodecost);
                }
                sequence_no_map[node] = sequence_no;
                mass.unlock();

                for(i = 0; i < neighbour_size; i++)
                    if(neighbour_list[i] != node)
                        mysend((void*) lsa, size, neighbour_list[i]);
            }
        }
    }
    printf("exiting listen\n");
    pthread_exit(NULL);
}

void *send_hello(void* useless) {
    int i;
    while(CURRENT_TIME() < overall_stop) {
        Hello h;
        h.srcid = current_node;
        for(i = 0; i < neighbour_size; i++) {
            mysend((void*) &h, sizeof(h), neighbour_list[i]);
        }

        usleep(hello_interval);
    }
    printf("exiting send hello\n");
    pthread_exit(NULL);
}

void *send_lsa(void* useless) {
    while(CURRENT_TIME() < overall_stop) {
        usleep(lsa_interval);
        int i;
        mass.lock();
        for(i = 0; i < neighbour_size; i++)
            mylsa->neighbour[i + neighbour_size] = access(current_node, neighbour_list[i]);

        for(i = 0; i < neighbour_size; i++)
            mysend((void*) mylsa, mylsa_size, neighbour_list[i]);
        mass.unlock();
    }
    printf("exiting send lsa\n");
    pthread_exit(NULL);
}

void *djikstra(void* useless) {
    while(CURRENT_TIME() < overall_stop) {
        usleep(djikstra_interval);
        mass.lock();
        priority_queue<pair<pair<int, int>, int> > pq;
        vector<vector<pair<int, int> > > adjlist;
        int i;
        int j;
        adjlist.clear();

        for( i = 0; i < graph_size; i ++ ) {
            for( j = 0; j < graph_size; j++)
                cerr << access(i, j) << " ";
            cerr << endl;
        }

        for( i = 0; i < graph_size; i++) {
            vector<pair<int, int> > current_row;
            current_row.clear();
            cerr << "HERE" << endl;
            for( j = 0; j < graph_size; j++) {
                if(access(i, j) != -1 && i != j) {
                    pair<int, int> g;
                    g.first = j;
                    g.second = access(i, j);
                    current_row.push_back(g);
                    cerr << i << " " << j << " "<< access(i, j) << endl;
                }
            }
            cerr << "LEAVING" << endl;
            adjlist.push_back(current_row);
        }

        bool visited[graph_size];
        for(i = 0; i < graph_size; i++)
            visited[i] = false;

        pq.push(make_pair(make_pair(current_node, 0), -1));
        pair<pair<int, int>, int> top;

        while(!pq.empty()) {
            top = pq.top();
            pq.pop();
            pair<int, int> next_guy;
            if(!visited[top.first.first]) {
                for(j = 0; j < adjlist[top.first.first].size(); j++) {
                    next_guy = adjlist[top.first.first][i];
                    pq.push(make_pair(make_pair(next_guy.first,
                        top.first.second + next_guy.second), top.first.first)
                    );
                }
                visited[top.first.first] = true;
                parent[top.first.first] = top.second;
                cost[top.first.first] = top.first.second;
            }
        }

        for(i = 0; i < graph_size; i++) {
            for(j = 0; j < graph_size; j++)
                cout << access(i, j) << " ";
            cout << endl;
        }
        cerr << "--------";

        for(i = 0; i < graph_size; i++)
            cerr << cost[i] << " ";

        cerr << "--------";

        mass.unlock();
        // for(i = 0; i < graph_size; i++)
        //     cerr << parent[i] << " " << cost[i] << endl;

    }
    printf("exiting djikstra\n");
    pthread_exit(NULL);
}

int main (int argc, char** argv)
{
    int rc;
    int i;
    int j;
    struct hostent *host;

    char* infile;
    char* outfile;

    pthread_t threads[NUM_THREADS];
    pthread_attr_t attr;

    void *status;

    for(i = 1;i < argc; i++) {
        if(!strcmp(argv[i], "-i")) {
            i++;
            current_node = atoi(argv[i]);
        }
        else if(!strcmp(argv[i], "-f")) {
            i++;
            infile = strdup(argv[i]);
        }
        else if(!strcmp(argv[i], "-o")) {
            i++;
            outfile = strdup(argv[i]);
        }
        else if(!strcmp(argv[i], "-h")) {
            i++;
            hello_interval = atoi(argv[i]);
        }
        else if(!strcmp(argv[i], "-a")) {
            i++;
            lsa_interval = atoi(argv[i]);
        }
        else if(!strcmp(argv[i], "-s")) {
            i++;
            djikstra_interval = atoi(argv[i]);
        }
    }

    fstream f;
    int edges;
    f.open(infile, std::fstream::in);
    f >> graph_size;
    f >> edges;
    adjacency = (int*) malloc(sizeof(int)*(graph_size)*(graph_size));
    i = 0;
    int vertex1;
    int vertex2;
    int mincost;
    int maxcost;
    int node;

    for(i = 0; i < graph_size; i++)
        for(j = 0; j < graph_size; j++)
            set(i, j, -1);

    for(i = 0; i < graph_size; i ++)
        set(i, i, 0);

    i = 0;
    while(i < edges) {
        f >> vertex1 >> vertex2 >> mincost >> maxcost;
        cerr << vertex1 << " " << vertex2 << " "  << mincost << " " << maxcost;
        if(vertex1 == current_node || vertex2 == current_node) {

            if(vertex2 == current_node)
                node = vertex1;
            else
                node = vertex2;
            neighbour_list.push_back(node);
            neighbour_lower_costs[node] = mincost;
            neighbour_upper_costs[node] = maxcost;
            sequence_no_map[node] = -1;
            set(node, current_node, 0);
            set(current_node, node, 0);

            neighbour_size++;
        }
        i++;
    }
    cerr << neighbour_size << "DD";

    mylsa = (LSA*) malloc(sizeof(LSA) + sizeof(int)*(2*neighbour_size-1));
    mylsa_size = sizeof(LSA) + sizeof(int)*(2*neighbour_size-1);
    mylsa->srcid = current_node;
    mylsa->number_of_entries = neighbour_size;
    mylsa->sequence_no = 0;
    for(i = 0; i < neighbour_size;i++) {
        mylsa->neighbour[i] = neighbour_list[i];
        mylsa->neighbour[i+neighbour_size] = 0;
    }


    overall_stop = CURRENT_TIME() + 20000000;



    // Initialize and set thread joinable
    pthread_attr_init(&attr);
    pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_JOINABLE);
    int id = 0;

    if ((sock = socket(AF_INET, SOCK_DGRAM, 0)) == -1) {
        perror("socket");
        exit(1);
    }



    host = (struct hostent *) gethostbyname("localhost");

    send_addr.sin_family = AF_INET;
    send_addr.sin_port = htons(20000+current_node);
    send_addr.sin_addr = *((struct in_addr *) host->h_addr);
    bzero(&(send_addr.sin_zero), 8);

    if (bind(sock, (struct sockaddr *) &send_addr,
            sizeof (struct sockaddr)) == -1) {
        perror("Bind");
        exit(1);
    }

    void* gen;

    parent = (int*) malloc(sizeof(int)*graph_size);
    cost = (int*) malloc(sizeof(int)*graph_size);

    for(i = 0; i < graph_size; i++) {
        parent[i] = -2;
        cost[i] = -1;
    }

    cost[current_node] = 0;
    parent[current_node] = -1;

    rc = pthread_create(&threads[0], NULL, my_listen, gen);
    rc = pthread_create(&threads[1], NULL, send_hello, gen);
    rc = pthread_create(&threads[2], NULL, send_lsa, gen);
    rc = pthread_create(&threads[3], NULL, djikstra, gen);


   // free attribute and wait for the other threads

    cerr << "Main: program exiting." << endl;
    pthread_exit(NULL);

    pthread_attr_destroy(&attr);
}
