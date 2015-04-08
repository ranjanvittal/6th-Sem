class InlineTest3 {

	public static void main(String[] args) {
		A a;
		B b;
		C c;
		int t;
		t = 0;
		a = new A();
		b = new B();
		c = new C();
		/* INLINE */
		t = a.f();
		t = a.g();
		/* INLINE */
		t = b.f();
		/* INLINE */
		t = b.g();
		/* INLINE */
		t = c.f();
		t = c.g();

	}

}

class A {
	public int f() {
		int t;
		t = 0;
		System.out.println(t);
		return t;
	}

	public int g() {
		int t;
		t = 1;
		System.out.println(t);
		return t;
	}
}

class B {
	public int f() {
		int t;
		t = 2;
		System.out.println(t);
		return t;
	}

	public int g() {
		int t;
		t = 3;
		System.out.println(t);
		return t;
	}
}

class C {
	public int f() {
		int t;
		t = 4;
		System.out.println(t);
		return t;
	}

	public int g() {
		int t;
		t = 5;
		System.out.println(t);
		return t;
	}
}
