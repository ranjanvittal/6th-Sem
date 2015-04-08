class InlineTest5 {

	public static void main(String[] args) {
		A2 a;
		B2 b;
		C2 c;
		int t;
		t = 0;
		a = new A2();
		b = new B2();
		c = new C2();
		a.f();
		t = a.g();
		/* INLINE */
		t = b.f();
		t = b.g();
		/* INLINE */
		t = c.f();
		c.g();

		b = new C2();
		a = new B2();
		t = 0;
		/* INLINE */
		t = b.f();
		System.out.println(t);
		/* INLINE */
		t = b.g();
		System.out.println(t);
		/* INLINE */
		t = a.f();
		System.out.println(t);
		/* INLINE */
		t = a.g();
		System.out.println(t);

	}

}

class A2 {
	int a;
	int b;

	public int f() {
		int t;
		t = 0;
		a = 50;
		b = 60;
		System.out.println(t);
		return t;
	}

	public int g() {
		int t;
		t = 1;
		a = 50;
		b = 60;
		System.out.println(t);
		return t;
	}
}

class B2 extends A2 {
	int a;
	int b;

	public int f() {
		int t;
		t = 2;
		a = 30;
		b = 40;
		System.out.println(t);
		return t;
	}

	public int g() {
		int t;
		t = 3;
		a = 30;
		b = 40;
		System.out.println(t);
		return t;
	}
}

class C2 extends B2 {
	int a;
	int b;

	public int f() {
		int t;
		t = 4;
		a = 10;
		b = 20;
		System.out.println(t);
		return t;
	}

	public int g() {
		int t;
		t = 5;
		a = 10;
		b = 20;
		System.out.println(t);
		return t;
	}
}
