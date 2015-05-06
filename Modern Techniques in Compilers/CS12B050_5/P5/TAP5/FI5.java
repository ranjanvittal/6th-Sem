class FI5 {
	public static void main (String [] args) {
		int x;
		x = new HELPER1FI5().start();
		System.out.println(x);
	}
}

class HELPER1FI5 {
	public int start() {
		int ret;
		ret = 0;
		this.foo();
		return ret;
	}

	public int foo () {
		int x;
		HELPER2FI5 ref;

		ref = new HELPER2FI5();
		x = 10;
		System.out.println(x);

		ref.printX();

		/* INLINE */
		x = ref.printGetter();

		ref.printX();
		return x;
	}
}

class HELPER2FI5 {
	int x;
	public int printX() {
		System.out.println(x);
		return x;
	}

	public int printGetter() {
		int x;
		HELPER2FI5 ref;

		ref = new HELPER2FI5();
		x = 2;

		/* INLINE */
		x = ref.getX();	

		System.out.println(x);
		x = 10;
		return x;
	}

	public int getX() {
		return x;
	}
}
