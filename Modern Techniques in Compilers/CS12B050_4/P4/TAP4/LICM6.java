class LICM6 {
	public static void main(String [] args) {
		int i;
		int n;
		int m;
		boolean f1;
		int p;
		int x;
		int y;
		n = 10;
		f1 = true;
		p = 1;
		x = 0;
		y = 0;
		/* LICM */
		for(i=0; i < n; i = i + 1) {
			m = 10;
			if(f1) {
				x = 10;
				p = p + 1;
			}
			else {
				x = 5;
				p = p + 1;
			}
		}
		System.out.println(x);
		System.out.println(p);
	}
}
