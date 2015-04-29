class T2 {
    public static void main(String[] argvs) {
        A a;
        B b;
        A c;
        boolean t;
        boolean t1;
        boolean t2;
        int one;
        int two;
        int six;
        a = new A();
        b = new B();
        b.b = b;
        c = new A();
        c.b = a;

        t = true;
        a = b.access();
    }
}


class A {
    int a;
    A b;
}

class Tool {
    public A make(A a) {
        return a;
    }
}
class B extends A {
    int b;
    int c;
    public A access() {
        A thi;
        thi = this;
        return thi;
    }

    public int add(A a, B b) {
        A c;
        A d;
        int l;
        boolean t;
        c = a;
        d = b.b;
        /* c alias? d */{}
        /* d alias? a */{}
        t = true;
        if(t)
            d = new B();
        else
            d = new A();
        l = 2;
        /* d alias? a */{}
        /* d alias? b */{}
        return l;
    }
}
