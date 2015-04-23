class T1 {
    public static void main(String[] argvs) {
        A a;
        B b;
        boolean t;
        a = new A();
        b = new B();
        t = true;
        if( t )
            a = b;
        else
            a = new A();
        /* a alias? b */{}
    }
}


class A {
    int a;
    A b;
}

class B extends A {
    int b;
    int c;
}
