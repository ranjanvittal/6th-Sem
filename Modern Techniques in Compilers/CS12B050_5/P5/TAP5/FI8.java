class FI8 {
	public static void main (String [] args) {
		int x;
		x = 0;
		x = new HELPER1FI8().start(x);
		System.out.println(x);
	}
}

class HELPER1FI8 {
	public int start(int arg) {
		boolean f1;

		f1 = arg < 5;

		if (f1) {
			arg = arg + 1;

			/* INLINE */
			this.foo(arg);

			System.out.println(arg);
		}
		else {}

		return arg;
	}

	public int foo(int x) {
		/* INLINE */
		this.bar(x);
		System.out.println(x);
		return x;
	}

	public int bar(int x) {
		boolean f1;
		x = x + 1;
		f1 = x < 5;
		if (f1) {
			this.start(x);
		}
		else {}

		return x;
	}
}
