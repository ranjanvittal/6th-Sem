#include <iostream>
#include <cstdlib>
#include <unistd.h>
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


volatile ll c = 1;

ll sock;
ll start_time;
struct sockaddr_in send_addr;
socklen_t addr_len = sizeof (struct sockaddr);

string to_string(int id) {
    char a[40];
    sprintf(a, "%d", id);
    string b(a);
    return b;
}

volatile ll* parent;
volatile ll* cost;

string outfile;
typedef pair<pair<ll, ll>, ll> priority_use;

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



ll CURRENT_TIME() {
    timeval tv;
    gettimeofday(&tv, NULL);
    ll current_time = tv.tv_usec + tv.tv_sec*1000000;
    return current_time;
}



// parameters

ll graph_size;
ll current_node;
ll hello_interval = 1000000 ;
ll lsa_interval = 5000000 ;
ll djikstra_interval = 20000000;
ll overall_stop;
ll djikstra_time;
ll hello_time;
ll lsa_time;

// node information

volatile ll* adjacency;


vector<ll> neighbour_list;

map<ll, ll> neighbour_lower_costs;

map<ll, ll> neighbour_upper_costs;

ll neighbour_size;

// Listen usage
map<ll, ll> sequence_no_map;





ll access(ll i, ll j) {
    return adjacency[graph_size*i + j];
}

#define set(i, j, expr) { adjacency[(graph_size)*(i) + (j)] = (expr);}

struct Hello {
   ll srcid;
};

struct HelloReceive {
   ll j;
   ll i;
   ll cost;
};

struct LSA {
   ll srcid;
   ll sequence_no;
   ll number_of_entries;
   ll neighbour[1];
};

// Node LSA

volatile LSA* mylsa;
volatile ll mylsa_size;
map<ll, ll> time_sent;

void* gen = (void*) malloc(1040);

int mysend(void* object, int size, ll id) {
    string host_name = "node-" + to_string(id);
    //cout << "sending to " << host_name << endl;
    struct hostent *host;
    host = (struct hostent *) gethostbyname(host_name.c_str());
    send_addr.sin_family = AF_INET;
    send_addr.sin_port = htons(20050);
    send_addr.sin_addr = *((struct in_addr *) host->h_addr);
    return sendto(sock, (void*) object, size, 0,
        (struct sockaddr *) &send_addr, sizeof (struct sockaddr));
    //cout << "bytes sent" << k << endl;
}

ll my_recv(void* gen) {
    return recvfrom(sock, gen, 1040, MSG_DONTWAIT,
        (struct sockaddr *) &send_addr, &addr_len);
}

void my_listen() {
   if(CURRENT_TIME() < overall_stop) {
        ll size = my_recv(gen);
		if(size != -1)
			//cout << " Size : " << size << endl;
        if(size == sizeof(Hello)) {
            // hello
			//cout << "hello start" << endl;
            Hello* h = (Hello*) gen;
            ll node = h->srcid;
            //cout << "Node : " << node << " " << endl;
            HelloReceive hr;
            hr.j = current_node;
            int hello_sent = mysend((void*) &hr, sizeof(hr), node);
            //cout << "Hello Sent : " << hello_sent << endl;
			//cout << "hello end" << endl;
        }
        else if(size == sizeof(HelloReceive)) {
            HelloReceive* hr = (HelloReceive*) gen;
			//cout << "hr start"<< endl;
            ll node = hr->j;
            ll now_time = CURRENT_TIME() - time_sent[node];
            set(node, current_node, now_time);
            set(current_node, node, now_time);
            //cout << "Cost : " << now_time << " from node-" << node << endl;
			//cout << "hr end" << endl;
        }
        else if(size != -1 && size > sizeof(HelloReceive)){
            //lsa receive
			//cout << "lsa receive start " << endl;
            LSA* lsa = (LSA*) gen;
            ll node = lsa->srcid;
            ll sequence_no = lsa->sequence_no;
            ll number_of_entries = lsa->number_of_entries;
            ll i;
            ll node2;
            ll nodecost;
            //cout<< "Number of entries " <<number_of_entries <<endl;
            if(sequence_no > sequence_no_map[node]) {
                for(i = 0; i < number_of_entries; i++) {

                    node2 = lsa->neighbour[i];
                    nodecost = lsa->neighbour[i+number_of_entries];
                    //cout << "node: "<< node2 <<" node cost " << nodecost <<endl;
                    set(node2, node, nodecost);
                    set(node, node2, nodecost);
                }
                sequence_no_map[node] = sequence_no;


                for(i = 0; i < neighbour_size; i++)
                    if(neighbour_list[i] != node)
                        mysend((void*) lsa, size, neighbour_list[i]);
				//cout << "lsa receive end " << endl;
            }
        }
    }
}


void send_hello() {
    ll i;
        if( CURRENT_TIME() > hello_time) {
            hello_time = CURRENT_TIME() + hello_interval;
            Hello h;
            h.srcid = current_node;
            for(i = 0; i < neighbour_size; i++) {
                int g = mysend((void*) &h, sizeof(h), neighbour_list[i]);
                time_sent[neighbour_list[i]] = CURRENT_TIME();
                //cout << "Sending hello to " << neighbour_list[i] << " Sent : " << g << endl;
            }
        }
}

void send_lsa() {
        if(CURRENT_TIME() > lsa_time) {
            lsa_time = CURRENT_TIME() + lsa_interval;
			//cout << "HEE" << endl;
            ll i;
            for(i = 0; i < neighbour_size; i++) {
                mylsa->neighbour[i + neighbour_size] = access(current_node, neighbour_list[i]);
            }

            mylsa->sequence_no += 1;
            mylsa->number_of_entries = neighbour_size;

            for(i = 0; i < neighbour_size; i++)
                mysend((void*) mylsa, mylsa_size, neighbour_list[i]);
            //cout << "end hee" << endl;
        }
}

void djikstra() {
        if(CURRENT_TIME() > djikstra_time) {
            djikstra_time = CURRENT_TIME() + djikstra_interval;
            //cout << "dj" << endl;
            priority_type pq;
            vector<vector<pair<ll, ll> > > adjlist;
            ll i;
            ll j;
            adjlist.clear();

            for( i = 0; i < graph_size; i++) {
                vector<pair<ll, ll> > current_row;
                current_row.clear();
                for( j = 0; j < graph_size; j++) {
                    if(access(i, j) != -1 && i != j) {
                        pair<ll, ll> g;
                        g.first = j;
                        g.second = access(i, j);
                        current_row.push_back(g);
                    }
                }
                adjlist.push_back(current_row);
            }
            //cout << "DJ 1"<<endl;
            bool visited[graph_size];
            for(i = 0; i < graph_size; i++)
                visited[i] = false;

            pq.push(make_pair(make_pair(current_node, 0), -1));
            pair<pair<ll, ll>, ll> top;

            while(!pq.empty()) {
                top = pq.top();

                pair<ll, ll> next_guy;
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

            //cout << "DJ 2"<<endl;

            fstream f;
            f.open(outfile.c_str(), std::fstream::app | std::fstream::out);
            f << endl;
            ll current_time = CURRENT_TIME();
            f << "Routing Table for Node No. " << current_node <<
            " at Time " << time_diff(current_time, start_time) << endl;
            f << "Destination\t\tPath\t\t\tCost" << endl;

            string parent_info;
            string cn = to_string(current_node);
            //cout << "DJ 3"<<endl;
            for(i = 0; i < graph_size; i++) {
                ll temp = i;
                parent_info = "";
                //cout << " HERE " << " DJ 4 " << temp << endl;
                while(temp != current_node) {
                    parent_info =  "-" + to_string(temp) + parent_info;
                    temp = parent[temp];
                  //  cout << temp << endl;
                }
                //cout << " HERE " << " DJ 4 " << temp << endl;
                parent_info = cn + parent_info;
                if(cost[i] != 0 && cost[i] != -1)
                    f<< i << "\t\t\t" << parent_info << "\t\t\t" << cost[i] << endl;
            }
            //cout << "end dj" << endl;
        }
}

int main (int argc, char** argv)
{
    ll rc;
    ll i;
    ll j;
    struct hostent *host;

    char* infile;
    char* of;

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
    f2.open(outfile.c_str(), std::fstream::out);
    f2.close();
    fstream f;
    ll edges;
    f.open(infile, std::fstream::in);
    f >> graph_size;
    f >> edges;
    adjacency = (ll*) malloc(sizeof(ll)*(graph_size)*(graph_size));
    i = 0;
    ll vertex1;
    ll vertex2;
    ll mincost;
    ll maxcost;
    ll node;

    for(i = 0; i < graph_size; i++)
        for(j = 0; j < graph_size; j++)
            set(i, j, -1);



    i = 0;
    while(i < edges) {
        f >> vertex1 >> vertex2;
        if(vertex1 == current_node || vertex2 == current_node) {

            if(vertex2 == current_node)
                node = vertex1;
            else
                node = vertex2;
            neighbour_list.push_back(node);

           // set(node, current_node, INF);
           // set(current_node, node, INF);

            neighbour_size++;
        }
	set(vertex1, vertex2, INF);
	set(vertex2, vertex1, INF);
        i++;
    }

    for(i = 0; i < graph_size; i++)
        sequence_no_map[node] = -1;

    mylsa = (LSA*) malloc(sizeof(LSA) + sizeof(ll)*(2*neighbour_size-1));
    mylsa_size = sizeof(LSA) + sizeof(ll)*(2*neighbour_size-1);
    mylsa->srcid = current_node;
    mylsa->number_of_entries = neighbour_size;
    mylsa->sequence_no = 0;

    for(i = 0; i < neighbour_size;i++) {
        mylsa->neighbour[i] = neighbour_list[i];
        mylsa->neighbour[i+neighbour_size] = 0;
    }

    start_time = CURRENT_TIME();
    ll stop_now = 320000000;
    overall_stop = CURRENT_TIME() + stop_now;

    ll id = 0;

    if ((sock = socket(AF_INET, SOCK_DGRAM, 0)) == -1) {
        perror("socket");
        exit(1);
    }


    string host_name = "node-" + to_string(current_node);
    //host = (struct hostent *) gethostbyname(host_name.c_str());

    send_addr.sin_family = AF_INET;
    send_addr.sin_port = htons(20050);
    //send_addr.sin_addr = *((struct in_addr *) host->h_addr);
    send_addr.sin_addr.s_addr = INADDR_ANY;
    bzero(&(send_addr.sin_zero), 8);

    if (bind(sock, (struct sockaddr *) &send_addr,
            sizeof (struct sockaddr)) == -1) {
        perror("Bind");
        exit(1);
    }

    void* gen;

    parent = (ll*) malloc(sizeof(ll)*graph_size);
    cost = (ll*) malloc(sizeof(ll)*graph_size);

    for(i = 0; i < graph_size; i++) {
        parent[i] = -2;
        cost[i] = -1;
    }

    cost[current_node] = 0;
    parent[current_node] = -1;

    lsa_time = start_time;
    hello_time = start_time;
    djikstra_time = start_time + djikstra_interval;

    while(CURRENT_TIME() < overall_stop) {
        send_hello();
        my_listen();
        send_lsa();
        djikstra();
    }

   // free attribute and wait for the other threads


}
