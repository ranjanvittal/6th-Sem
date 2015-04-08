class T1{
    public static void main(String[] a){
        Fac32 n;
        int t;
        int t1;
        int id1;
        int nine_thousand;
        n = new Fac32();
        t = 64;
        nine_thousand = 9000;
        n.num = nine_thousand;
        id1 = 23;
        /*INLINE*/
        t1 = n.ComputeFac3();
        System.out.println(t1);

    }
}

class Fac3 {
    int num;
    int [] a;
    int gg;

    public int assignArray() {
      int i;
      int j;
      int k1;
      int k2;
      int zero;
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
        zero = 0;
        return zero;
    }
    public int ComputeFac3(){
      int i; int j ;
      int k;
      int sum;
      int sum2;
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

      System.out.println(num);
      for (i = 0; i < 64; i = i+1)
        for (j = 0; j < 64; j = j+1) {
            k1 = i*10;
            k1 = k1*2;
            k2 = i*6;
            k2 = k2 + 1;
            k2 = a[k2];
            a[k1] = k2;
        }

      for (i = 0; i < 64; i = i+1)
        for (j = 0; j < 64; j = j+1) {
            k1 = i;
            k1 = k1*k1;
            k2 = i*6;
            k2 = k2 + 1;
            k2 = a[k2];
            a[k1] = k2;
        }
      /*INLINE*/
      gg = this.assignArray();
      ret = a[60];
        return ret ;
    }
}

class Fac31 extends Fac3 {
    int num;
    int [] a;

    public int assignArray() {
      int i;
      int j;
      int k1;
      int k2;
      int zero;
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
        zero = 0;
        return zero;
    }
    public int ComputeFac3(){
      int i; int j ;
      int k;
      int sum;
      int sum2;
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


      for (i = 0; i < 64; i = i+1)
        for (j = 0; j < 64; j = j+1) {
            k1 = i*10;
            k1 = k1*2;
            k2 = i*6;
            k2 = k2 + 1;
            k2 = a[k2];
            a[k1] = k2;
        }

      for (i = 0; i < 64; i = i+1)
        for (j = 0; j < 64; j = j+1) {
            k1 = i;
            k1 = k1*k1;
            k2 = i*6;
            k2 = k2 + 1;
            k2 = a[k2];
            a[k1] = k2;
        }
      /*INLINE*/
      this.assignArray();
      ret = a[60];
        return ret ;
    }
}

class Fac32 extends Fac31 {
    int num;
    int [] a;

    public int assignArray() {
      int i;
      int j;
      int k1;
      int k2;
      int zero;
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
        zero = 0;
        return zero;
    }

    public int ComputeFac3(){
      int i; int j ;
      int k;
      int sum;
      int sum2;
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


      for (i = 0; i < 64; i = i+1)
        for (j = 0; j < 64; j = j+1) {
            k1 = i*10;
            k1 = k1*2;
            k2 = i*6;
            k2 = k2 + 1;
            k2 = a[k2];
            a[k1] = k2;
        }

      for (i = 0; i < 64; i = i+1)
        for (j = 0; j < 64; j = j+1) {
            k1 = i;
            k1 = k1*k1;
            k2 = i*6;
            k2 = k2 + 1;
            k2 = a[k2];
            a[k1] = k2;
        }
      /*INLINE*/
      this.assignArray();
      ret = a[60];
        return ret ;
    }

}
