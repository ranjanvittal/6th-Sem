class Licm {
    public static void main(String[] a){
        Fac1 n;
        int t;
        int t1;
        n = new Fac1();
        t = 64;
        t1 = n.ComputeFac1(t);
        System.out.println(t1);

    }
}

class Fac1 {
    public int ComputeFac1(int num) {

    int i; int j ;
    int k;
    int sum;

    int m;
    int ret;
    int a1;
    int a2;
    int a3;
    int a4;
    ret = 0;
    a1 = 0;
    a2 = 0;
    a3 = 0;
    a4 = 0;
    m = num + num;

    k = 4; sum = 0;

    /* LICM */
    // sum = sum+i to be moved outside the j loop

    for (i = 0;i < num; i = i+1)
      for (j = 0;j<num;j = j+1) {
          k = 5;
          sum = sum + i;
      }

    a2 = 0;
    System.out.println(sum);

    /* LICM */
    // All the 4 statements go outside the loop

    for ( k = 0; k < num; k = k+1) {
        a1 = a2 + 1;
        a3 = a1;
        a4 = a3 + 1;
        a3 = a4;
    }
    System.out.println(a1);
    System.out.println(a2);
    System.out.println(a3);
    System.out.println(a4);
    return a1;
}
}
