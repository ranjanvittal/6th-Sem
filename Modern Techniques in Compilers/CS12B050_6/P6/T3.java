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
        one = 1;
        two = 2;
        six = 6;
        t1 = i < one;
        t2 = i < two;
        for(i = 0; i < six; i = i+one) {
            if(t1)
                a = b.b;
            else
                if(t2)
                    b = c;
                else
                    a = c.b;
        }
        /* a alias? b */{}
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
