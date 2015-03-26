class LoopTile{
    public static void main(String[] a){
        Fac3 n;
        int t;
        int t1;
        int nine_thousand;
        n = new Fac3();
        t = 64;
        nine_thousand = 9000;
        n.num = nine_thousand;
        t1 = n.ComputeFac3();
        System.out.println(t1);

    }
}

class Fac3 {
    int num;
    public int ComputeFac3(){
      int i; int j ;
      int k;
      int sum;
      int sum2;
      int [] a;
      int [] b;
      int [] c;
      int kk;
      int m;
      int ret;
      int k1;
      int k2;
      k1 = 0;
      k2 = 0;
      ret = 0;
      m = num + num;
      a = new int[m];
      b = new int[m];
      c = new int[m];

      // loop tile succeeds
      /* LOOPTILE 4 4 */
      for (i = 0; i < 64; i = i+1)
        for (j = 0; j < 64; j = j+1) {
            k1 = i*10;
            k1 = k1*2;
            k2 = i*6;
            k2 = k2 + 1;
            k2 = a[k2];
            a[k1] = k2;
        }

      // loop tile fails because non linear array index
      /* LOOPTILE 4 4  */
      for (i = 0; i < 64; i = i+1)
        for (j = 0; j < 64; j = j+1) {
            k1 = i;
            k1 = k1*k1;
            k2 = i*6;
            k2 = k2 + 1;
            k2 = a[k2];
            a[k1] = k2;
        }

      // loop tile fails
      // due to dependency issue
      // specifically : a[2*2 + 4] = a[2*4 + 2]. But a[10] should have been
      // assigned when i = 0, j = 10 which wouldnot be done because
      // of tile size.
      /* LOOPTILE 4 4  */
      for (i = 0; i < 64; i = i+1)
        for (j = 0; j < 64; j = j+1) {
            k1 = i*2;
            k1 = k1 + j;
            k2 = j*2;
            k2 = k2 + i;
            k2 = a[k2];
            k2 = k2 + 1;
            a[k1] = k2;//a[2*i+j] = a[2*j+i]+1;
        }

        return ret ;
    }
}
