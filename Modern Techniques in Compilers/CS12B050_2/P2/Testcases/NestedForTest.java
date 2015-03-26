class NestedForTest{
    public static void main(String[] a){
        System.out.println(new Fac().ComputeFac(4));
    }
}

class Fac {
    public int ComputeFac(int num){
        int[] a;
        int i;
        int j;
        int temp;
        a = new int[10];
        a[0] = 10;
        a[1] = 9;
        a[2] = 8;
        a[3] = 7;
        a[4] = 6;
        a[5] = 5;
        a[6] = 4;
        a[7] = 3;
        a[8] = 2;
        a[9] = 1;

        for(i = 0; i < 9; i = i+1)
            for(j = i+1; j < 10; j = j+1)
                if((a[j]) < (a[i])) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                else
                    temp = 1;

        for(i = 0; i < 10; i = i+1)
            System.out.println(a[i]);
        return 1;

    }
}
