class LoopTest{
    public static void main(String[] a){
      Fac n;
      int t;
      int t1;
      n = new Fac();
      t = 64;
      t1 = n.ComputeFac(t);
      System.out.println(t1);

    }
}

class Fac {
  int oo;
    public int ComputeFac(int num){

        int i; int j ;
  int k;
  int sum;
  int sum2;
  int k1;
  int k2;
  int [] a;
  int [] b;
  int [] c;
  int kk;
  int m;
  int ret;
  boolean t1;
  boolean t2;
  boolean t12;
  ret = 0;
  t1 = true;
  t2 = true;
        m = num + num;
  a = new int[m];
  b = new int[m];
  c = new int[m];
  k = 4; sum = 0;
  i = 4;
  /* LICM */
    for (j=0;j<num;j=j+1) {
      {
      if(t1) {
        if(t2)
          k = 1 + 5;
        else
          k = 3;
      }
      else {
        k = 2 + i;
      }
    }
      sum = k + k;
      oo = 5*3;
      sum = sum + k;

      for(i = 0; i < num; i = i+1){
        if(t1) {
          k1 = 2*k;
        }
        else {
          k1 = 7;
        }
        sum = sum + k;
      }
    }

  /* LICM */
  for (i=0;i<num;i=i+1)
    for (j=0;j<num;j=j+1) {
      k = 5;
      sum = sum + j;
    }

  // loop distribution succeeds
  /* LOOPDISTRIBUTE */
    for (j=0;j<num;j=j+1) {
      a[j] = j;
      sum = sum + j;
    }
  // loop distribution succeeds
  /* LOOPDISTRIBUTE */
    for (j=1;j<num;j=j+1) {
      {
      k = 2*j;
      a[k] = j; // first statement goes inside the first loop
      }

      kk = 2*j;
      k1 = kk + 1;        // rest goes
      k2 = a[k1];      // inside the
                      // second loop
    }


    // // loop distribution Fails
    // /* LOOPDISTRIBUTE */
    // for (j=0;j<num;j=j+1) {
    //   a[j] = j;

    //   k = j+1;
    //   kk = a[k];

    //   b[j] = kk;
    // }

  // /* LOOPUNROLL 4 */
  //   for (j=0;j<16;j=j+1) {
  //     a[i] = j;
  //     sum = sum + j;
  //   }

  // loop tile succeeds
  /* LOOPTILE 4 4  */
  for (i=0;i<64;i=i+1)
    for (j=0;j<64;j=j+1) {
      // k1 = 2*i;
      // k = k1 + 1;
      // kk = a[k];
      // a[k1] = kk;
      //System.out.println(i);
      k1 = 2*i;
      a[k1] = 1;
    }
     /* LOOPUNROLL 4 */
    for(i = 0; i < 64;i = i+1) {
      ret = a[i];
      System.out.println(ret);
    }

        return ret ;
    }
}
