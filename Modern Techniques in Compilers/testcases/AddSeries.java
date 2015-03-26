class AddSeries {
    public static void main(String[] a) {
        PerformAddition mtTmp2;
        int mtTmp3;
        int mtTmp1;
        mtTmp2 = new PerformAddition();
        mtTmp3 = 10;
        mtTmp1 = mtTmp2.Start(mtTmp3);
        System.out.println(mtTmp1);
    }
}
class PerformAddition {
    int sum;
    public int Start(int n) {
        int i;
        int mtTmp4;
        int mtTmp5;
        boolean mtTmp6;
        int mtTmp7;
        int mtTmp8;
        int mtTmp9;
        mtTmp4 = 0;
        i = mtTmp4;
        mtTmp5 = 0;
        sum = mtTmp5;
        mtTmp6 = i < n;
        while(mtTmp6) {
            {
            mtTmp7 = sum + i;
            sum = mtTmp7;
            mtTmp9 = 1;
            mtTmp8 = i + mtTmp9;
            i = mtTmp8;
            }
            mtTmp6 = i < n;
        }
        return sum;
    }
}
