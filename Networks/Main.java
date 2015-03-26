class Main {
    public static void main(String argvs[]) {
        A a = new B();
        a.s();
        a.d(a);
    }
}

class A {
    int a;
    public void foo() {
        System.out.println("vfvf");
    }
    public void s() {
        System.out.println("sss");
        foo();
    }
    public void d(A c) {}
}

class B extends A {
    public void foo() {
        System.out.println("cfeef");
    }
}

// class A {
//     class List {
//         list next;
//         public int value() {return 0;}
//         public int sum() {
//             int s = 0;

//         }
//     }

//     class Node extends list {
//         public int val;
//         public int value() {return val;}
//     }

//     class Node2 extends list {
//         public int val;
//         public int value() {return 2*val;}
//     }

//     public List create() {
//         Node a = new Node();
//         a.val = 1;
//         Node2 b = new Node2();
//         b.val = 2;
//         a.next = b;
//         b.next = null;
//         List c = a;
//         return c;
//     }

//     public int sum(List t) {
//         while(t != null)
//     }
// }




