class LoopDistribute {
    public static void main(String[] a){
        Fac2 n;
        int t;
        int t1;
        n = new Fac2();
        t = 64;
        t1 = n.ComputeFac2(t);
        System.out.println(t1);

    }
}

class Fac2 {
    public int ComputeFac2(int num) {

        int i; int j ;
    int k;
    int sum;
    int sum2;

    int m;
    int ret;
    int m1;
    int a1;
    int a2;
    int a3;
    int a4;
    int k1;
    int k2;
    int[] a;
    int[] b;
    ret = 0;
    m = num + num;
    k = 4; sum = 0;
    m1 = m*8;
    a = new int[m1];
    b = new int[m1];
    a1 = 0;
    // LOOP Distribution succeeds
    /* LOOPDISTRIBUTE */
    for( i = 0; i  < m; i = i + 1) {
        for( j = 0; j < m; j = j + 1) {
            a1 = a1 + 1;

            for (k = 0; k < m; k = k + 1)
                System.out.println(k);
        }
    }

    // LOOP Distribution fails
    /* LOOPDISTRIBUTE */
    for( i = 0; i  < m; i = i + 1) {
        for( j = 0; j < m; j = j + 1) {
            a1 = a1 + 1;

            for (k = 0; k < a1; k = k + 1)
                System.out.println(k);
        }
    }

    // Loop Distribution succeeds
    /* LOOPDISTRIBUTE */
    for( i = 0 ; i < m ; i = i+1) {
        k1 = i*2;
        a[k1] = i;

        k2 = i*2;
        k2 = k2 + 1;
        k2 = a[k2];
        b[k2] = k2;
    }

    // Loop Check
    for(i = 0; i < m1; i = i+1) {
        k1 = a[i];
        System.out.println(k1);
        k2 = b[i];
        System.out.println(k2);
    }

    // Loop Distribution fails
    /* LOOPDISTRIBUTE */
    for( i = 0; i < m; i = i+1) {
        k1 = i*2;
        a[k1] = i;

        k2 = i*4;
        k2 = a[k2];
        b[k2] = k2;
    }

    // Loop Check
    for(i = 0; i < m1; i = i+1) {
        k1 = a[i];
        System.out.println(k1);
        k2 = b[i];
        System.out.println(k2);
    }

    k1 = 5;
    return  k1;
}
}
