class T1 {
    public static void main(String[] argvs) {
        A a;
        B b;
        A c;
        A d;
        A e;
        boolean t;
        a = new A();
        b = new B();
        t = true;
        e = new A();
        b.b = e;
        a = b;
        if( t )
            a = new A();
        else
            a = new A();
        e = new A();
        a.b = e;
        c = a.b;
        d = b.b;
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
