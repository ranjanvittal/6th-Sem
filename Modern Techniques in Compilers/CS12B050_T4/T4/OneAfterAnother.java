class OneAfterAnother {
    public static void main(String[] argvs){
        int t;
        int t1;
        int[] a;
        int[] b;
        int[] c;
        int i;
        int j;
        int k;
        int twenty;
        twenty = 20;
        a = new int[twenty];
        b = new int[twenty];
        c = new int[twenty];
        t = 64;
        t1 = 0;
        System.out.println(t1);

        /* LICM */
        // The j loop goes outside the i loop
        for ( i = 0; i < 20; i = i + 1) {
            /* LOOPDISTRIBUTE */
            // succeeds
            for (j = 0 ; j < 20; j = j + 1) {
                t1 = j+1;
                a[j] = t1;
                /* LOOPUNROLL 4 */
                for (k = 0; k < 20; k = k + 1) {
                    t1 = k+j;
                    c[k] = t1;
                }
            }
            b[i] = i;
        }
        for(i = 0; i < 20; i = i + 1) {
            t1 = a[i];
            System.out.println(t1);
            t1 = b[i];
            System.out.println(t1);
            t1 = c[i];
            System.out.println(t1);
        }
        t1 = 12;
        System.out.println(t1);
    }
}
