class T2 {
    public static void main(String[] argv){
        int a;
        int b;
        int c;
        Gen j;
        j = new Gen();
        a = 1;
        b = 2;
        c = 4;
        /*INLINE*/
        c = j.addThree(a, b, c);
        /*INLINE*/
        c = j.multiplyThree(a, b, c);
        System.out.println(c);
    }
}

class Gen {
    public int addThree(int a, int b, int c) {
        c = b + c;
        c = a + c;
        return c;
    }

    public int multiplyThree(int a, int b, int c) {
        c = b*c;
        c = a*c;
        return c;
    }

}
