#include <iostream>
using namespace std;
int main() {
    int a;
    int b;
    int c;
    int i;
    int d;
    int h[18];
    int val;
    int ans_val;
    int ans[2][2][2];

    for(a = 0; a < 2; a++)
            for(b = 0; b < 2; b++)
                for(c = 0; c < 2; c++)
                    ans[a][b][c] = 1;
    ans[0][0][0] = 0;


    for(i = 0; i < 1<<18; i++) {
        ans_val = 0;
        for(a = 0; a < 2; a++) {
            for(b = 0; b < 2; b++) {
                for(c = 0; c < 2; c++) {
                    for(d = 0; d < 18; d++)
                        h[d] = (1<<d&i)>0;
                    val = 0;
                    val += h[0]*a;
                    val += h[1]*b;
                    val += h[2]*c;
                    val += h[3]*(!a);
                    val += h[4]*(!b);
                    val += h[5]*(!c);
                    val += h[6]*a*b;
                    val += h[7]*b*c;
                    val += h[8]*c*a;
                    val += h[9]*(!a)*(!b);
                    val += h[10]*(!b)*(!c);
                    val += h[11]*(!c)*(!a);
                    val += h[12]*(a)*(!b);
                    val += h[13]*(b)*(!c);
                    val += h[14]*(c)*(!a);
                    val += h[15]*(!a)*b;
                    val += h[16]*(!b)*c;
                    val += h[17]*(!c)*a;
                    if((val%2) == ans[a][b][c])
                        ans_val++;
                }
            }
        }
        //cout << ans_val << endl;
        if(ans_val == 7) {
            for(int v = 0; v < 18; v++)
                cout << h[v] << " ";
            cout << endl;
            break;
        }
    }

}
