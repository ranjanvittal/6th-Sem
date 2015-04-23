class T2 {
    public static void main(String[] argvs) {
        A a;
        B b;
        A c;
        boolean t;
        a = new A();
        b = new B();
        c = new A();
        t = true;
        a = b.access();
        /* a alias? b */{}
        a = tool.make(c);
        /* a alias? c */{}
        /* b alias? c */{}
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
}
