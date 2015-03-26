class MulbyAdd {
    public static void main(String[] args) {
        Sum mtTmp2;
        int mtTmp3;
        int mtTmp4;
        int mtTmp1;
        mtTmp2 = new Sum();
        mtTmp3 = 10;
        mtTmp4 = 5;
        mtTmp1 = mtTmp2.Supply(mtTmp3,mtTmp4);
        System.out.println(mtTmp1);
    }
}
class Perform {
    int sum;
    public int Start(int n, int times) {
        int i;
        int mtTmp5;
        int mtTmp6;
        boolean mtTmp7;
        int mtTmp8;
        int mtTmp9;
        int mtTmp10;
        mtTmp5 = 0;
        i = mtTmp5;
        mtTmp6 = 0;
        sum = mtTmp6;
        mtTmp7 = i < n;
        while(mtTmp7) {
            {
            mtTmp8 = sum + n;
            sum = mtTmp8;
            mtTmp10 = 1;
            mtTmp9 = i + mtTmp10;
            i = mtTmp9;
            }
            mtTmp7 = i < n;
        }
        return sum;
    }
}
class Sum extends Perform {
    public int Supply(int n, int i) {
        Perform mtTmp12;
        int mtTmp11;
        mtTmp12 = new Perform();
        mtTmp11 = mtTmp12.Start(n,i);
        return mtTmp11;
    }
}
