class FI6 {
	public static void main (String [] args) {
		new BFI6().f();
	}
}

class AFI6 {
	int x;
	public int foo() {
		x = 5;
		return x;
	}

	public int bar() {
		System.out.println(x);
		return x;
	}
}

class BFI6 extends AFI6 {
	int x;
	public int f() {
		int ret;
		ret = 0;
		/* INLINE */
		this.foo();

		this.bar();

		/* INLINE */
		this.bar();
		return ret;
	}
}
