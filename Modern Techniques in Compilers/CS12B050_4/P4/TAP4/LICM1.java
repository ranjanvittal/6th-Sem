class LICM1 {
	public static void main (String [] args) {
		int x;
		x = new HELPER1LICM1().foo();
	}
}
class HELPER1LICM1 {
	public int foo() {
		int i;
		int n;
		int k;
		int l;
		boolean f2;
		boolean f1;
		n = 10;
		k = 0;
		f1 = true;
		/* LICM */
		for(i = 0; i < n; i = i + 1) {
			k = 2;
			f1 = true;
		}
		System.out.println(k);
		l = 10;
		f2 = true;
		/* LICM */
		for(i = 0; i < n; i = i + 1) {
			k = 2;
			f1 = true;
			l = l + 1;
			f2 = f2 & f1;
		}
		System.out.println(k);
		if(f2)
			System.out.println(k);
		else
			System.out.println(l);
		return l;
	}
}
