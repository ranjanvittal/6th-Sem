class ClassExtends{
    public static void main(String[] a){
        System.out.println(new Fac1().ComputeFac(10));
    }
}

class Fac {
    int a;
    int b;
    public int ComputeFac(int num){
        return 1;

    }
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

class Fac1 extends Fac {
    int a;
    public int ComputeFac(int num) {
        Fac b;
        int a;
        this.a = 70;
        b = this;
        if(num < 7)
            a = 102;
        else {
            b.a = 73;
            System.out.println(b.getA());
            System.out.println(this.get());
            a = b.ComputeFac(6);
        }
        return a;
    }
    public int get() {
        return a;
    }
}
