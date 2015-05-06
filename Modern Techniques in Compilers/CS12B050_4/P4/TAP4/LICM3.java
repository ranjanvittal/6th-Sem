class LICM3 {
	public static void main (String [] args) {
		int x;
		x = new HELPER1LICM3().foo();
	}
}
class HELPER1LICM3 {
	public int foo() {
		int i;
		int n;
		int m;
		int p;
		n = 0;
		m = 1;
		p = 0;
		/* LICM */
		for(i=0; i < n; i = i + 1) {
			m = 0;
			p = p + 1;
		}
		System.out.println(m);
		return m;
	}
}
