class InlineTest4 {

	public static void main(String[] args) {
		A1 a;
		B1 b;
		int t;
		b = new C1();
		a = new B1();
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

class A1 {
	public int f() {
		int t;
		t = 0;
		System.out.println(t);
		return t;
	}

	public int g() {
		int t;
		t = 1;
		t = this.f();
		System.out.println(t);
		return t;
	}
}

class B1 extends A1 {
	public int f() {
		int t;
		t = 2;
		/* INLINE */
		t = this.g();
		System.out.println(t);
		return t;
	}

	public int g() {
		int t;
		t = 3;
		/* INLINE */
		t = this.f();
		System.out.println(t);
		return t;
	}
}

class C1 extends B1 {
	public int f() {
		int t;
		t = 4;
		System.out.println(t);
		return t;
	}

	public int g() {
		int t;
		t = 5;
		t = this.f();
		System.out.println(t);
		return t;
	}
}
