class T4 {
    public static void main(String[] argv){
        int a;
        int b;
        int c;
        A j;
        boolean b1;

        j = new A();
        a = 10;
        b = 0-4;
        c = 0-6;
        /*INLINE*/
        b1 = j.checkEqualCube(a, b, c);
        System.out.println(b1);
    }
}

class A {


    public boolean checkEqualCube(int a, int b, int c) {
        boolean b1;
        boolean b2;
        boolean b3;
        /*INLINE*/
        b1 = this.checkZero(a, b, c);
        /*INLINE*/
        b2 = this.checkEqual2(a, b, c);
        b1 = b1&b2;
        return b1;
    }

    public boolean checkZero(int a, int b, int c) {
        boolean b1;
        boolean b2;
        boolean b3;
        int zero;
        zero = 0;
        c = a+c;
        c = b+c;
        /*INLINE*/
        b3 = this.checkEqual(c, zero);
        return b3;
    }

    public boolean checkEqual(int a, int b) {
        boolean b1;
        boolean b2;
        boolean b3;
        b1 = a < b;
        b2 = b < a;
        b1 = !b1;
        b2 = !b2;
        b3 = b1 & b2;
        return b3;
    }

    public boolean checkEqual2(int a, int b, int c) {
        boolean b1;
        boolean b2;
        boolean b3;
        /*INLINE*/
        b1 = this.checkEqual(a, b);
        /*INLINE*/
        b2 = this.checkEqual(b, c);
        b3 = b1 & b2;
        return b3;

    }
}
