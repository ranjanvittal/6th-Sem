class FI10 {
	public static void main (String [] args) {
		int x;
		XFI10 ref;
		ref = new XFI10();
		x = ref.start();
		System.out.println(x);
	}
}

class XFI10 {
	public int start() {
		int x1;
		x1 = 10;

		/* INLINE */
		this.foo();

		System.out.println(x1);
		return x1;
	}

	public int foo () {
		int x1;
		YFI10 ref;

		ref = new YFI10();
		x1 = 7;

		/* INLINE */
		ref.foo();

		System.out.println(x1);
		return x1;
	}
}

class YFI10 {
	public int foo() {
		int x1;
		x1 = 5;
		System.out.println(x1);
		return x1;
	}
}
