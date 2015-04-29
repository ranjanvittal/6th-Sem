class T1 {
    public static void main(String[] argvs) {
        B a;
        A b;
        boolean t;
        t = true;
        if(t)
            a = new B();
        b = a;
        /* a alias? b */{}
    }
}

class A {
    int a;
}

class B extends A {
    int b;
}
