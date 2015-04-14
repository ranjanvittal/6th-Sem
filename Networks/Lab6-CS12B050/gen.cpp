#include <iostream>
#include <cstdlib>
#include <pthread.h>
#include <unistd.h>
#include <mutex>

using namespace std;

#define NUM_THREADS 4
mutex mass;

// parameters

int size;
int node;
long long int hello_interval = 1000 ;
long long int lsa_interval = 5000;
long long int djikstra_interval = 20000;

int* adjacency;




#define access(adjacency, i, j) {adjacency[(size)*(i) + (j)]}

struct HelloReceive {
   int j;
   int i;
   int cost;
};

struct LSA {
   int srcid;
   int sequence_no;
   int no_of_entries;
   int neighbour_cost[1];
};

struct Hello {
   int srcid;
};


void *wait(void *t)
{
   int i;
   long tid;

   tid = (long)t;

   mtx.lock();
   cout << "Sleeping in thread " << endl;
   cout << "Thread with id : " << tid << "  ...exiting " << endl;
   mtx.unlock();
   pthread_exit(NULL);
}

void *my_listen(void* useless) {
   thread_exit(NULL);
}

void *send_hello(void* useless) {
   usleep(hello_interval);
   thread_exit(NULL);
}
void *send_lsa(void* useless) {
   usleep(lsa_interval);
   thread_exit(NULL);
}

void *djikstra(void* useless) {
   usleep(djikstra_interval);
   thread_exit(NULL);
}

int main ()
{
   int rc;
   int i;
   pthread_t threads[NUM_THREADS];
   pthread_attr_t attr;
   void *status;

   // Initialize and set thread joinable
   pthread_attr_init(&attr);
   pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_JOINABLE);
   int id = 0;

   rc = pthread_create(&threads[0], NULL, my_listen, (void*) id++);
   rc = pthread_create(&threads[1], NULL, hello, (void*) id++);
   rc = pthread_create(&threads[2], NULL, send_lsa, (void *) id++);
   rc = pthread_create(&threads[3], NULL, djikstra, (void *) id++);



   // free attribute and wait for the other threads
   pthread_attr_destroy(&attr);

   cout << "Main: program exiting." << endl;
   pthread_exit(NULL);
}
