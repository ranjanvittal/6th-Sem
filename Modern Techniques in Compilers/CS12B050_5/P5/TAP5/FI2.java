class FI2 {
	public static void main (String [] args) {
		int x;
		x = new HELPER1FI2().start();
		System.out.println(x);
	}
}

class HELPER1FI2 {
	public int start() {
		int ret;
		ret = 0;

		/* INLINE */
		this.foo();

		System.out.println(ret);
		return ret;
	}

	public int foo () {
		int ret;
		ret = 10;
		System.out.println(ret);
		return ret;
	}
}
