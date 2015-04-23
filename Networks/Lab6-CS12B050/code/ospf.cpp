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
#define INF 400000000

mutex mass;

volatile int c = 1;

int sock;
ll start_time;
struct sockaddr_in send_addr;
socklen_t addr_len = sizeof (struct sockaddr);



volatile int* parent;
volatile int* cost;
string outfile;
typedef pair<pair<int, int>, int> priority_use;

#define time_diff(a, b) ( ((a)-(b))/1000000 )

class Priority
{
    public:
        bool operator() (const priority_use& lhs, const priority_use& rhs) const
        {
            return (lhs.first.second > rhs.first.second);
        }
} priority;

typedef priority_queue<priority_use, std::vector<priority_use>, Priority> priority_type;

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
long long int lsa_interval = 5000000 ;
long long int djikstra_interval = 20000000;
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

volatile LSA* mylsa;
volatile int mylsa_size;


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
        else if(size != -1 && size > sizeof(HelloReceive)){
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
    pthread_exit(NULL);
}

void *send_lsa(void* useless) {
    while(CURRENT_TIME() < overall_stop) {
        usleep(lsa_interval);
        int i;
        mass.lock();

        for(i = 0; i < neighbour_size; i++) {
            mylsa->neighbour[i + neighbour_size] = access(current_node, neighbour_list[i]);
        }

        mylsa->sequence_no += 1;
        mylsa->number_of_entries = neighbour_size;

        for(i = 0; i < neighbour_size; i++)
            mysend((void*) mylsa, mylsa_size, neighbour_list[i]);
        mass.unlock();
    }
    pthread_exit(NULL);
}

void *djikstra(void* useless) {
    while(CURRENT_TIME() < overall_stop) {
        usleep(djikstra_interval);
        mass.lock();
        priority_type pq;
        vector<vector<pair<int, int> > > adjlist;
        int i;
        int j;
        adjlist.clear();

        for( i = 0; i < graph_size; i++) {
            vector<pair<int, int> > current_row;
            current_row.clear();
            for( j = 0; j < graph_size; j++) {
                if(access(i, j) != -1 && i != j) {
                    pair<int, int> g;
                    g.first = j;
                    g.second = access(i, j);
                    current_row.push_back(g);
                }
            }
            adjlist.push_back(current_row);
        }

        bool visited[graph_size];
        for(i = 0; i < graph_size; i++)
            visited[i] = false;

        pq.push(make_pair(make_pair(current_node, 0), -1));
        pair<pair<int, int>, int> top;

        while(!pq.empty()) {
            top = pq.top();

            pair<int, int> next_guy;
            if(!visited[top.first.first]) {
                for(j = 0; j < adjlist[top.first.first].size(); j++) {
                    next_guy = adjlist[top.first.first][j];
                    pq.push(make_pair(make_pair(next_guy.first,
                        top.first.second + next_guy.second), top.first.first)
                    );
                }
                visited[top.first.first] = true;
                parent[top.first.first] = top.second;
                cost[top.first.first] = top.first.second;
            }
            pq.pop();
        }


        fstream f;
        f.open(outfile, std::fstream::app | std::fstream::out);
        f << endl;
        ll current_time = CURRENT_TIME();
        f << "Routing Table for Node No. " << current_node <<
        " at Time " << time_diff(current_time, start_time) << endl;
        f << "Destination\t\tPath\t\t\tCost" << endl;

        string parent_info;
        string cn = to_string(current_node);

        for(i = 0; i < graph_size; i++) {
            int temp = i;
            parent_info = "";
            while(temp != current_node) {
                parent_info =  "-" + to_string(temp) + parent_info;
                temp = parent[temp];
            }
            parent_info = cn + parent_info;
            if(cost[i] != 0 && cost[i] != -1)
                f<< i << "\t\t\t" << parent_info << "\t\t\t" << cost[i] << endl;
        }

        mass.unlock();

    }
    pthread_exit(NULL);
}

int main (int argc, char** argv)
{
    int rc;
    int i;
    int j;
    struct hostent *host;

    char* infile;
    char* of;

    pthread_t lsa_thread;
    pthread_t djikstra_thread;
    pthread_t hello_thread;
    pthread_t listen_thread;

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
            of = strdup(argv[i]);
        }
        else if(!strcmp(argv[i], "-h")) {
            i++;
            hello_interval = atoi(argv[i])*1000000;
        }
        else if(!strcmp(argv[i], "-a")) {
            i++;
            lsa_interval = atoi(argv[i])*1000000;
        }
        else if(!strcmp(argv[i], "-s")) {
            i++;
            djikstra_interval = atoi(argv[i])*1000000;
        }
    }

    outfile = string(of) + "-" + to_string(current_node) + ".txt";
    fstream f2;
    f2.open(outfile, std::fstream::out);
    f2.close();
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



    i = 0;
    while(i < edges) {
        f >> vertex1 >> vertex2 >> mincost >> maxcost;
        if(vertex1 == current_node || vertex2 == current_node) {

            if(vertex2 == current_node)
                node = vertex1;
            else
                node = vertex2;
            neighbour_list.push_back(node);
            neighbour_lower_costs[node] = mincost;
            neighbour_upper_costs[node] = maxcost;

            set(node, current_node, mincost);
            set(current_node, node, mincost);

            neighbour_size++;
        }
        i++;
    }

    for(i = 0; i < graph_size; i++)
        sequence_no_map[node] = -1;

    mylsa = (LSA*) malloc(sizeof(LSA) + sizeof(int)*(2*neighbour_size-1));
    mylsa_size = sizeof(LSA) + sizeof(int)*(2*neighbour_size-1);
    mylsa->srcid = current_node;
    mylsa->number_of_entries = neighbour_size;
    mylsa->sequence_no = 0;

    for(i = 0; i < neighbour_size;i++) {
        mylsa->neighbour[i] = neighbour_list[i];
        mylsa->neighbour[i+neighbour_size] = 0;
    }

    start_time = CURRENT_TIME();
    ll stop_now = 5*60000000;
    overall_stop = CURRENT_TIME() + stop_now;


    // Initialize and set thread joinable
    // pthread_attr_init(&attr);
    // pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_JOINABLE);
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

    rc = pthread_create(&listen_thread, NULL, my_listen, gen);
    rc = pthread_create(&hello_thread, NULL, send_hello, gen);
    rc = pthread_create(&lsa_thread, NULL, send_lsa, gen);
    rc = pthread_create(&djikstra_thread, NULL, djikstra, gen);


   // free attribute and wait for the other threads

    pthread_exit(NULL);

}
