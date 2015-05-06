class FI3B {
	public static void main (String [] args) {
		int x;
		x = new HELPER1FI3B().start();
		System.out.println(x);
	}
}

class HELPER1FI3B {
	public int start() {
		int ret;
		BFI3B refA;

		ret = 0;
		refA = new CFI3B();

		/* INLINE */
		refA.overriden();

		/* INLINE */
		this.foo(ret);

		return ret;
	}
	public int foo(int x) {
		return x;
	}

}

class AFI3B {
	public int overriden () {
		int x;
		x = 1;
		System.out.println(x);	
		return x;
	}
}

class BFI3B extends AFI3B {

}

class CFI3B extends BFI3B {
	public int overriden () {
		int x;
		x = 0;
		System.out.println(x);	
		return x;
	}
}
