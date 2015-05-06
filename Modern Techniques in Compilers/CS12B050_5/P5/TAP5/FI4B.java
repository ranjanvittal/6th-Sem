class FI4B {
	public static void main (String [] args) {
		int x;
		x = new HELPER1FI4B().start();
		System.out.println(x);
	}
}

class HELPER1FI4B {
	public int start() {
		int ret;
		BFI4B refB;

		ret = 0;
		refB = new BFI4B();

		/* INLINE */
		refB.overriden();

		return ret;
	}
}

class AFI4B {
	public int overriden () {
		int x;
		x = 1;
		System.out.println(x);	
		return x;
	}
}

class BFI4B extends AFI4B {

}
