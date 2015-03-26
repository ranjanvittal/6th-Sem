class ForTest{
    public static void main(String[] a){
        System.out.println(new Fac().ComputeFac(4));
    }
}

class Fac {
    public int ComputeFac(int num){
        int product;
        int i;
        product = 1;
        for(i = 2; i < (num+1); i = i + 1) {
            product = product*i;
        }
        return product;

    }
}
