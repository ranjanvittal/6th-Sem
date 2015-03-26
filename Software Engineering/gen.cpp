#include <iostream>
using namespace std;
int e = 0;

class OneTime {
  static OneTime *fp;
  static bool flag;
public:
    OneTime() {
        if(flag) {
            fp = this;
            flag = false;
        }
        if(!flag)
          this = fp;
    }
};
bool OneTime::flag = true;
int main() {
    int i;
    OneTime one;
    OneTime two;
}

