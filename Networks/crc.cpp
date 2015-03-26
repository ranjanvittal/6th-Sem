#include <iostream>
#include <fstream>
#include <time.h>
#include <stdlib.h>

using namespace std;

#define ll long long

ll getkthbit(ll n, ll k) {
    return (n >> (64 - k)) & 1;
}

char* print_binary(ll n, ll start) {
    ll i = start;
    char* a = (char*) malloc(100*sizeof(char));
    int j = 0;
    while(i <= 64) {
        a[j] = '0' + getkthbit(n, i);
        i++;
        j++;
    }
    a[j] = '\0';
    return a;
}

ll divide(ll n, ll p) {
    ll i = 10;
    ll k = 0;
    ll x;
    k = n >> 55;
    while(i <= 64) {
        ll b = getkthbit(k, 56);
        if(b)
            k = k^p;
        k = k << 1;
        k = k ^ getkthbit(n, i);
        i++;
    }
    return k;
}
void convert(long long int &my_n, char* gen) {
    my_n = 0;
    int i;
    for(i = 0; i < strlen(gen); i++) {
        my_n = my_n << 1;
        my_n = my_n ^ (gen[i] - '0');
    }
}
int main(int argc, char* argv[]) {
    ll n;
    n = 1000;
    ll my_n = 0;
    char gen[45];

    srand(time(NULL));
    int i;
    FILE* fp = fopen(argv[1], "r");
    ofstream fout(argv[2]);
     while(!feof(fp)) {
        if(!feof(fp)) {
            fscanf(fp, "%s", gen);
            if(feof(fp))
                break;
        }
        if(strlen(gen) < 2)
            break;
        int j;
        for(j = 0; j < 10; j++) {
            fout << "Original String : " << gen << endl;
            convert(my_n, gen);
            ll crc_n = divide(my_n, 263);
            crc_n = (my_n << 8)^crc_n;
            fout << "Original String with CRC :";
            fout << print_binary(crc_n, 25) << endl;
            ll k = (rand() % 40);
            ll corrupted = crc_n ^ 1 << k;
            fout << "Corrupted String : ";
            fout << print_binary(corrupted, 25) << endl;
            fout << "Number of errors introduced : 1" << endl;
            if(divide(corrupted, 263)) {
                fout << "CRC Check: " << "Failed\n\n";
            }
            else {
                fout << "CRC Check: " << "Passed\n\n";
            }
            int k1;
            k1 = (rand()%40);
            while(k1 == k) {
                k1 = (rand()%40);
            }
            ll corrupted2 = corrupted ^ 1 << k1;
            fout << "Original String : " << gen << endl;
            fout << "Original String with CRC :";
            fout << print_binary(crc_n, 25) << endl;
            fout << "Corrupted String : ";
            fout << print_binary(corrupted2, 25) << endl;
            fout << "Number of errors introduced : 2" << endl;
            if(divide(corrupted2, 263)) {
                fout << "CRC Check: " << "Failed\n\n";
            }
            else {
                fout << "CRC Check: " << "Passed\n\n";
            }
            int k_3 = (rand()%9 + 1);
            k_3 *= 2;
            k_3 += 2;
            long long int corrupted3 = (1 << k_3) - 1;
            fout << "Original String : " << gen << endl;
            fout << "Original String with CRC :";
            fout << print_binary(crc_n, 25) << endl;
            fout << "Corrupted String : ";
            fout << print_binary(corrupted3, 25) << endl;
            fout << "Number of errors introduced : " << k_3 - 1 << endl;
            corrupted3 = crc_n^corrupted3;
            if(divide(corrupted3, 263)) {
                fout << "CRC Check: " << "Failed\n\n";
            }
            else {
                fout << "CRC Check: " << "Passed\n\n";
            }
        }
    }

    fout.close();
    fclose(fp);
}
