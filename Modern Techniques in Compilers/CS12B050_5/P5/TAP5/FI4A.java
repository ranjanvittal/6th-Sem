class FI4A {
	public static void main (String [] args) {
		int x;
		x = new HELPER1FI4A().start();
		System.out.println(x);
	}
}

class HELPER1FI4A {
	public int start() {
		int ret;
		BFI4A refA;

		ret = 0;
		refA = new CFI4A();

		/* INLINE */
		refA.overriden();

		return ret;
	}
}

class AFI4A {
	public int overriden () {
		int x;
		x = 1;
		System.out.println(x);	
		return x;
	}
}

class BFI4A extends AFI4A {

}

class CFI4A extends BFI4A {

}
