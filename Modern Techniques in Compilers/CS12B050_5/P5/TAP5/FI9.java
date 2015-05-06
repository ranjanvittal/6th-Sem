class FI9 {
	public static void main (String [] args) {
		int x;
		x = new HELPER1FI9().start();
		System.out.println(x);
	}
}

class HELPER1FI9 {
	int ret;
	public int start() {

		/* INLINE */ 
		this.foo();

		return ret;
	}

	public int foo () {
		boolean f1;

		ret = 0;
		f1 = true;

		while(f1) {
			f1 = ret < 5;
			 
			/* INLINE */
			this.bar();

			ret = ret + 1;
		}

		return ret;
	}
	
	public int bar() {
		boolean f2;
		f2 = true;

		System.out.println(ret);

		if (f2) {
			/* INLINE */
			ret = this.foobar();
			ret = ret + 10;
		}
		else {
			/* INLINE */
			ret = this.alternate();
			ret = ret + 5;
		}
		return ret;
	}

	public int foobar() {
		int x;
		x = 10;
		System.out.println(x);
		return x;
	}

	public int alternate() {
		int x;
		x = 5;
		System.out.println(x);
		return x;
	}
}
