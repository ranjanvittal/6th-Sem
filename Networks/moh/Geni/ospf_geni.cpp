#include <iostream>
#include <cstdlib>
#include <pthread.h>
#include <unistd.h>
//#include <mutex>
#include <vector>
#include <sys/time.h>
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
#include <fstream>
#include <time.h>
#include <queue>
#include <map>
#include <sstream>
using namespace std;
#define NUM_THREADS     4
#define NUM_MINS_TO_RUN 5
#define PB push_back
typedef pair <int,int> ii;
typedef pair <double, pair <int,int> > iii;
typedef vector< vector<pair<double,int> > > vvii;
typedef vector <int> vi;
#define sc second
#define fs first
typedef long long int lli;
const int INF = 1<<30;
//std::mutex mtx;
double  adjacency_matrix[500][500];
lli prev_hello_time = 0;
lli prev_lsa_time = 0;
lli prev_graph_time = 0;

int neighbor[500];

vi latest_seq_num;
int num_of_neighbors;
int num_nodes = 0;
int num_edges = 0;
int node_id = -1;
int hi = 1 * 1000000;
int lsai = 5 * 1000000;
int spfi = 10 * 1000000;
lli time_out = 0;
lli start_time = 0;
int sock;
int seq_num = 1;
struct sockaddr_in server_addr, client_addr, send_addr;
struct hostent *host;
int  bytes_read;
unsigned int addr_len;
void * recv_data;
char infile_name[100],outfile_name[100];
lli last_time_hello_sent[500];

struct hello_pkt {
  int identifier;
  int scrid;

};
struct hello_reply_pkt{
  int identifier;
  int j;
  int i;
  int val;

};

struct lsa_pkt{
  int identifier;
  int scrid;
  int seq_num;
  int num_entries;
  double hack[2];
};
struct hello_pkt H;
struct hello_reply_pkt H_Reply;
struct lsa_pkt * to_send_lsa;
struct lsa_pkt *recved_lsa;

lli get_time(){
	timeval tv;
  gettimeofday(&tv, NULL);
  lli curr_time = tv.tv_usec + tv.tv_sec*1000000;
  return curr_time;
}

string get_addr(int val){
  char a[100];
  sprintf(a,"node-%d",val);
  string b(a);
  return b;
}
void hello()
{
	if (get_time() >= prev_hello_time + hi){
    prev_hello_time = get_time();
    int i;
    cout<<"hello sending"<<endl;
    for (i=0;i<num_of_neighbors;i++){
      cout<<neighbor[i]<<" ";
      last_time_hello_sent[neighbor[i]] = get_time();
      host = (struct hostent *) gethostbyname(get_addr(neighbor[i]).c_str()); 
      cout << get_addr(neighbor[i]).c_str() <<endl;
      server_addr.sin_addr = *((struct in_addr *) host->h_addr);
      sendto(sock, (void*)&H, sizeof(H), 0, (struct sockaddr *) &server_addr, sizeof (struct sockaddr));

    }


    cout << "hello sent" << endl;
		
	}
  
   
}


bool received_hello(void* recv_data, int bytes_read) {
    bool done = bytes_read == sizeof(hello_pkt);
    if (done){
        
        hello_pkt* recv_hello = (hello_pkt*)recv_data;
        int id = recv_hello->scrid;
        cout<<"Recieved Hello from "<<id<<endl;
        H_Reply.i = id;
        int i,j;
        int random_nu;

            //cout << "received hello" << endl;
            // for(i=0;i<num_nodes;i++){
            //   for(j=0;j<num_nodes;j++)
            //     cout<<adjacency_matrix[i][j]<<" ";
            // cout<<endl;
            //}
            H_Reply.val = 0;

          

        /////////////////////////// Send H_Reply pkt
        server_addr.sin_port = htons(20000+28);
        host = (struct hostent *) gethostbyname(get_addr(id).c_str()); 
        server_addr.sin_addr = *((struct in_addr *) host->h_addr);
        int byt = sendto(sock, (void*)&H_Reply, sizeof(H_Reply), 0, (struct sockaddr *) &server_addr, sizeof (struct sockaddr));
        cout << byt << endl;
        //cout<<"Val sent was "<<random_nu<<endl;
        cout << "received hello mudil" << endl;
        
      }
      return done;
}

bool received_hello_reply(void* recv_data, int bytes_read) {
  bool done = bytes_read == sizeof(hello_reply_pkt);
  if (done){
        hello_reply_pkt *recv_reply = (hello_reply_pkt*)recv_data;
        
            
        cout<<"Received Hello reply from "<<recv_reply->j<<" and the val is "<<recv_reply->val<<endl;
		cout<< " val set is "<<(get_time()-last_time_hello_sent[recv_reply->j])*1.00/1000<<endl;
        adjacency_matrix[node_id][recv_reply->j] = (get_time()-last_time_hello_sent[recv_reply->j])*1.00/1000.0;
        int i,j;
        // for(i=0;i<num_nodes;i++){
        //       for(j=0;j<num_nodes;j++)
        //         cout<<adjacency_matrix[i][j]<<" ";
        //     cout<<endl;
        //     }
        

      }
      return done;
}

bool received_lsa(void* recv_data, int bytes_read) {
    bool done = false;
    if (bytes_read != -1) {
          
          lsa_pkt* recved_lsa = (lsa_pkt*)recv_data;
          cout << "BOOM LSA" << endl;
          cout << recved_lsa->scrid << endl;
          cout << recved_lsa->seq_num << endl;
          cout << latest_seq_num[recved_lsa->scrid] << endl;
          if(recved_lsa->seq_num > latest_seq_num[recved_lsa->scrid]){
            latest_seq_num[recved_lsa->scrid] = recved_lsa->seq_num ;

            int i,j;
            cout << "bytes received : " << bytes_read << endl;
            cout << " src id : " << recved_lsa-> scrid << endl;
            cout << " num_entries : " << recved_lsa->num_entries << endl;
            for (i=0;i<recved_lsa->num_entries;i++){
              adjacency_matrix[recved_lsa->scrid][int(recved_lsa->hack[2*i])] = recved_lsa->hack[2*i+1];
            }
            cout << "lsa middle"<<endl;
            for(i=0;i<num_of_neighbors;i++)
              if(neighbor[i]!= recved_lsa->scrid){
                server_addr.sin_port = htons(20000+28);
                host = (struct hostent *) gethostbyname(get_addr(neighbor[i]).c_str()); 
                server_addr.sin_addr = *((struct in_addr *) host->h_addr);
                cout<<"Forwarding lsa to : "<< neighbor[i] << endl;
                sendto(sock, (void*)recv_data, bytes_read, 0, (struct sockaddr *) &server_addr, sizeof (struct sockaddr));
              }
              for(i=0;i<num_nodes;i++){
                for(j=0;j<num_nodes;j++)
                  cout<<adjacency_matrix[i][j]<<" ";
              cout<<endl;
              }
              cout << "if lsa mudiyil" << endl;
              done = true;
          }
          cout << "lsa mudil" << endl;
          
    }
    return done;
}

void listen()
{
	
      bytes_read = recvfrom(sock, recv_data, 1024, MSG_DONTWAIT,(struct sockaddr *) &client_addr, &addr_len);// TO BE CHANGED
      bool is_hello = received_hello(recv_data, bytes_read);
      bool is_hello_rcv = received_hello_reply(recv_data, bytes_read);
      if(!is_hello && !is_hello_rcv)
          bool g = received_lsa(recv_data, bytes_read);
	
}
void lsa()
{
	 if(get_time() >= prev_lsa_time + lsai){
    prev_lsa_time = get_time();
		
    int i,j;
    to_send_lsa->identifier = 3;
    to_send_lsa->scrid = node_id;
    to_send_lsa->seq_num = seq_num;
    seq_num++;
    int ct=0;
    
    cout<<"sending lsa start"<<endl;

    for(j=0;j<num_nodes;j++)
        cout<<adjacency_matrix[node_id][j]<<" ";

    cout<<endl;
    for(i=0;i<num_nodes;i++){
      if(adjacency_matrix[node_id][i] !=-1){
        to_send_lsa->hack[2*ct] = i;
        to_send_lsa->hack[2*ct+1] = adjacency_matrix[node_id][i];
        ct++;
      }
    }


    to_send_lsa->num_entries = ct;
    cout << to_send_lsa->num_entries << endl;
    for (i=0;i<num_of_neighbors;i++){
      server_addr.sin_port = htons(20000+28);
      host = (struct hostent *) gethostbyname(get_addr(neighbor[i]).c_str()); 
      server_addr.sin_addr = *((struct in_addr *) host->h_addr);
      cout << "I am here sending to : " << neighbor[i] << endl;
      int byt = sendto(sock, (void*) to_send_lsa, sizeof(lsa_pkt)+2*num_of_neighbors*sizeof(double), 0, (struct sockaddr *) &server_addr, sizeof (struct sockaddr));
      cout << byt << endl;
    }
    cout << "lsa sent num entries : " << " " << to_send_lsa->num_entries << endl;

    cout << " src id : " << to_send_lsa->scrid << " " << endl;

    


	}
 
}
void graph()
{
  int i,j;
	if (get_time() >= prev_graph_time + spfi){
    prev_graph_time = get_time();
	cout<< "entered dj"<<endl;	

    vvii G(num_nodes);
    vi P(num_nodes,-1);
    
      
      cout << num_nodes << endl;
    for (i=0;i<num_nodes;i++) {
      
      for (j=0;j<num_nodes;j++) {
        cout << adjacency_matrix[i][j] << " ";
        if(adjacency_matrix[i][j] >=0)
          G[i].PB(make_pair(adjacency_matrix[i][j],j));
      }
      cout << endl;
    }
		
    vector < double > D(num_nodes,INF);
    priority_queue<iii,vector<iii>,greater<iii> > Q;
    D[node_id]=0;
    Q.push(iii(0,ii(node_id,-1)));
    while(!Q.empty()){
      iii top = Q.top();
      Q.pop();
      int v = top.sc.fs; double d = top.fs;
        //cout << v << " " << d << endl;
      if(d<=D[v]){
        P[v] = top.sc.sc;
        vector <pair<double,int> >::iterator it;
        for(it=G[v].begin();it<G[v].end();it++){
          int v2 = it->sc; double cost = it->fs;
          if(D[v2] > D[v]+cost ) {
            D[v2] = D[v] + cost;
            Q.push(iii(D[v2],ii(v2,v)));
              //cout << D[v2] << endl;
          }
        }
      }
    }
 fstream fil;
  
  
  string out (outfile_name);
  
	stringstream ss;
	ss << out << "-" << node_id << ".txt";
	out = ss.str();
	cout << out<<endl;
  fil.open(out.c_str(),std::fstream :: app | std::fstream :: out );

  
  fil<<"Routing table for Node Id "<<node_id<<" Time = "<<int((get_time()- start_time)*1/1000000)<<" seconds"<<endl;
  fil<<" Destination \t Path \t Cost"<<endl;
  cout<<"Writting something to output"<<endl;
  for (i=0;i<num_nodes;i++){
    if (i!= node_id && P[i]!=-1){
      fil<<i<<" \t";
      fil<<node_id;
      vector<int> temp;
      int node = i;
      while(node!=-1){
        temp.PB(node);
        node = P[node];

      }
      vector <int>::iterator it;
      int j;
      for (j = temp.size()-2; j>=0;j--)
        fil<<"-"<<temp[j];
      fil<<"\t";
      fil<<D[i]<<endl;

    }
  }

  fil.close();
  cout<< "leaving DJ"<< endl;

  }

}


int main (int argc, char *argv[])
{
   srand (time(NULL));
   start_time = get_time();
   time_out = get_time() +	NUM_MINS_TO_RUN * 60 * 1000000;
   recv_data = malloc(2000*sizeof(int));

   to_send_lsa = (lsa_pkt*) malloc(sizeof(lsa_pkt)+2*num_of_neighbors*sizeof(double));
   recved_lsa = (lsa_pkt*) malloc(sizeof(lsa_pkt)+2*500*sizeof(int));

   int i,j;
   for(i=1;i<argc;i++){
      if(argv[i][0]=='-'){
  switch(argv[i][1]){
    case 'i':node_id = atoi(argv[i+1]);i++;break;
    case 'h':hi = atoi(argv[i+1]) * 1000000;i++;break;
    case 'a':lsai = atoi(argv[i+1]) * 1000000;i++;break;
    case 's':spfi = atoi(argv[i+1]) * 1000000;i++;break;
      case 'f':strcpy(infile_name,argv[i+1]);i++;break;
      case 'o':strcpy(outfile_name,argv[i+1]);i++;break;

  }
      }
    }

  fstream fil;
  string out (outfile_name);
	stringstream ss;
	ss << out << "-" << node_id << ".txt";
	out = ss.str();
  fil.open(out.c_str() ,std::fstream :: out);
  fil.close();

  if (node_id == -1){
    cout<<"NODE ID NOT GIVEN" << endl;
    exit(0);
  }
  fstream fin;
    fin.open(infile_name,std::fstream :: in);
  fin>>num_nodes;

  fin>>num_edges;
  //Initialize adjacency_matrix
  // adjacency_matrix = (volatile int**)malloc((num_nodes+2)*sizeof(int*));
  // for (i=0;i<num_nodes;i++)
  //   adjacency_matrix[i] = (int*)malloc((num_nodes+2)*sizeof(int));
  for(i=0;i<num_nodes;i++)
    for(j=0;j<num_nodes;j++)
      adjacency_matrix[i][j] = -1;
  //Initialize latest_seq_num
  for(i=0;i<num_nodes;i++)
    latest_seq_num.PB(-1);

  int x,y,a,b;
    i = 0;
  //neighbor = (int*) malloc(num_nodes*sizeof(int));
  while(i < num_edges){
    fin>>x>>y;
      ////cout << x << " " << y << " " << a << " " << b << endl;
    if (x == node_id ){
      neighbor[num_of_neighbors] = y;
      
      num_of_neighbors++;
      cout << x << " " << y << " " << endl;
    }
    if (y == node_id ){
      neighbor[num_of_neighbors] = x;
      
      num_of_neighbors++;
      cout << x << " " << y << " " <<  endl;
    }
      i++;
  }

  for(i=0;i<num_nodes;i++){
    for(j=0;j<num_nodes;j++)
      cout<<adjacency_matrix[i][j]<<" ";
    cout<<endl;
  }

   

   //setting hello pkt
   H.identifier = 1;
   H.scrid = node_id;
   //setting hello reply pkt
   H_Reply.identifier = 2;
   H_Reply.j = node_id;


   //read input file, compute neighbors, update number of neighbors

   //Creating sockets

   

   //TO BE CHANGED FOR GENI

   if ((sock = socket(AF_INET, SOCK_DGRAM, 0)) == -1) {
        perror("socket");
        exit(1);
    }

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(20000+28);
    //host = (struct hostent *) gethostbyname(get_addr(node_id).c_str()); 
    server_addr.sin_addr.s_addr = INADDR_ANY;
    bzero(&(server_addr.sin_zero), 8);

    if (bind(sock, (struct sockaddr *) &server_addr,
            sizeof (struct sockaddr)) == -1) {
        perror("Bind");
        exit(1);
    }

  
    
    while(get_time() <= time_out){
      hello();
      listen();
      lsa();
      graph();
    }

    cout << "bye" << endl;
}
