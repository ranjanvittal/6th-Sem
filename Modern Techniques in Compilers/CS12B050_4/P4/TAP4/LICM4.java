class LICM4 {
	public static void main (String [] args) {
		int x;
		x = new HELPER1LICM4().foo();
	}
}
class HELPER1LICM4 {
	public int foo () {
		int i;
		int n;
		int p;
		int q;
		int x;
		int y;
		int z;
		p = 10;
		n = 10;
		z = 0;
		y = 0;
		x = 0;
		q = 0;
		/* LICM */
		for(i = 0; i < n; i = i + 1) {
			z = 3;
			y = z + p;
			x = y;
			q = q + 1;
		}
		System.out.println(x);
		System.out.println(q);
		System.out.println(y);
		System.out.println(z);
		return z;
	}
}
