class ComplicatedFieldAssignment{
    public static void main(String[] a){
        System.out.println(new Fac().ComputeFac(4));
    }
}

class Fac {
    int[] a;
    public int ComputeFac(int num){
        int[] a;
        int i;
        int j;
        int temp;
        if(num < 0)
            i = 1;
        else {
            a = new int[10];
            a[1] = 89;
            this.a = new int[11];
            i = this.changeA(1, 78);
            System.out.println(a[1]);
            System.out.println(this.getAIndex(1));
            (this.returnMyself()).a = a;
            System.out.println(this.getAIndex(1));
        }
        return 1;

    }

    public Fac returnMyself() {
        return this;
    }
    public int getAIndex(int index) {
        return a[index];
    }

    public int changeA(int index, int num) {
        a[index] = num;
        return 1;
    }

}
