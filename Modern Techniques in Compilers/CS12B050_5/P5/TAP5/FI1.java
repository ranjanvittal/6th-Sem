class FI1 {
	public static void main (String [] args) {
		int x;
		HELPER1FI1 ref;
		ref = new HELPER1FI1();
		x = ref.start();
		System.out.println(x);
	}
}

class HELPER1FI1 {
	public int start() {
		HELPER2FI2 ref1;
		int ret;
		ret = 0;
		ref1 = new HELPER2FI2();

		/* INLINE */
		this.foo();

		/* INLINE */
		ret = ref1.foo();

		return ret;
	}

	public int foo () {
		int ret1;
		ret1 = 10;
		System.out.println(ret1);
		return ret1;
	}
}

class HELPER2FI2 {
	public int foo() {
		int ret2;
		ret2 = 10;
		System.out.println(ret2);
		return ret2;
	}
}
