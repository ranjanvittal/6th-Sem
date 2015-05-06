class T1 {
    public static void main(String[] argvs) {
        B a;
        A b;
        boolean t;
        t = true;
        a = new B();
        if(t)
            a.a = new B();
        b = a.a;
        /* a alias? b */{}
    }
}

class A {
    A a;
}

class B extends A {
    int b;
}
