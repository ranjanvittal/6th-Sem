class FI7 {
	public static void main (String [] args) {
		int x;
		x = 0;
		x = new HELPER1FI7().start(x);
		System.out.println(x);
	}
}

class HELPER1FI7 {
	public int start(int arg) {
		boolean f1;

		f1 = arg < 5;

		if (f1) {
			arg = arg + 1;

			/* INLINE */
			this.start(arg);

			System.out.println(arg);
		}
		else {}

		return arg;
	}
}
