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
    public int ComputeFac(int num){

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
  ret = 0;
        m = num + num;
  a = new int[m];
  b = new int[m];
  c = new int[m];
  k = 4; sum = 0;

  /* LICM */
    for (j=0;j<num;j=j+1) {
      k = 5;
      sum = sum + j;
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
      a[j] = j; // first statement goes inside the first loop

      k = j-1;        // rest goes
      kk = a[k];      // inside the
      b[j] = kk;      // second loop
    }

    // loop distribution Fails
    /* LOOPDISTRIBUTE */
    for (j=0;j<num;j=j+1) {
      a[j] = j;

      k = j+1;
      kk = a[k];

      b[j] = kk;
    }

  /* LOOPUNROLL 4 */
    for (j=0;j<16;j=j+1) {
      a[i] = j;
      sum = sum + j;
    }

  // loop tile succeeds
  /* LOOPTILE 4 4  */
  for (i=0;i<64;i=i+1)
    for (j=0;j<64;j=j+1) {
      k = i + j;
      kk = a[k];
      a[i] = kk;
    }
    /* LOOPUNROLL 4 */
    for(i = 0; i < 12;i = i+1) {
      ret = a[i];
      System.out.println(ret);
    }

    // loop distribution succeeds
  /* LOOPDISTRIBUTE */
    for (j=0;j<num;j=j+1) {
      System.out.println(j);

      ret = a[j];
      System.out.println(ret);
    }

        return ret ;
    }
}
