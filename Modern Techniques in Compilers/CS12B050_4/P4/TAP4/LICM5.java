class LICM5 {
	public static void main(String [] args) {
		int i;
		int n;
		int m;
		int x;
		int y;
		int z;
		n = 10;
		y = 10;
		z = 2;
		x = 17;
		/* LICM */
		for(i=0; i < n; i = i + 1) {
			m = 10;
			x = y;
			y = 3;
		}
		System.out.println(x);
		System.out.println(y);

		/* LICM */
		for(i=0; i < n; i = i + 1) {
			m = 10;
			x = y;
			y = x;
		}
		System.out.println(x);
		System.out.println(y);
	}
}
