class T5 {
    public static void main(String[] argv){
        int a;
        int b;
        Gen2 j;

        j = new Gen2();
        a = 10;

        /*INLINE*/
        b = j.notGoodToExpand(a);
        System.out.println(b);
    }
}

class Gen2 {
    public int notGoodToExpand(int a) {
        int b;
        int ret;
        boolean b1;
        int c;
        b1 = a < 2;
        if( b1 )
            ret = 1;
        else {
            c = a-1;
            /*INLINE*/
            b = this.notGoodToExpand(c);
            ret = b*a;
        }
        return ret;
    }
}
