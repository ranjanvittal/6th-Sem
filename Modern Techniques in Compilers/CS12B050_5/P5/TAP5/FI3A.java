class FI3A {
	public static void main (String [] args) {
		int x;
		x = new HELPER1FI3A().start();
		System.out.println(x);
	}
}

class HELPER1FI3A {
	public int start() {
		int ret;
		AFI3A refA;

		ret = 0;
		refA = new CFI3A();

		/* INLINE */
		refA.overriden();

		/* INLINE */
		this.foo();

		return ret;
	}
	public int foo () {
		int ret;
		ret = 15;
		System.out.println(ret);
		return ret;
	}
}

class AFI3A {
	public int overriden () {
		int x;
		x = 1;
		System.out.println(x);	
		return x;
	}
}

class BFI3A extends AFI3A {

}

class CFI3A extends BFI3A {
	public int overriden () {
		int x;
		x = 0;
		System.out.println(x);	
		return x;
	}
}
