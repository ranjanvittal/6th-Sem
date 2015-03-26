class LoopUnroll {
    public static void main(String[] argvs){

        int t;
        int t1;
        int[] a;
        int i;
        int m;
        int k1;
        m = 101;
        a = new int[m];

        for(i = 0; i < m; i = i+1)
            a[i] = i;

        /* LOOPUNROLL 4 */
        for(i = 0; i < 100; i = i + 1) {
            k1 = a[i];
            k1 = k1*2;
            a[i] = k1;
            t = i;
            t = t+1;
            t1 = i+2;
            k1 = a[t1];
            a[t] = k1;
        }

        for (i = 0; i < m; i = i + 1) {
            t1 = a[i];
            System.out.println(t1);
        }
        t1 = 0;
        System.out.println(t1);
    }
}
