class T1 {
    public static void main(String[] argvs) {
        A a;
        B b;
        A c;
        A d;
        A e;
        A f;
        A g;
        boolean t;
        a = new A();
        b = new B();
        g = a.b;
        t = true;
        e = new A();
        b.b = e;
        a = b;
        if( t )
            a = new A();
        else{}
        if( t )
            b = new B();
        else {}

        e = new A();
        a.b = e;
        c = a.b;
        d = b.b;
        /* a alias? b */{}
        /* c alias? d */{}

    }
}


class A {
    int a;
    A b;
}

class B extends A {
    int c;
}
