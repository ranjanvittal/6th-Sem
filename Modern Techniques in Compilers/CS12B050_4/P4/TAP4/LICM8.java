class LICM8 {
	public static void main(String [] args) {
		int i;
		int n;
		int x;
		int z;
		int t1;
		int t2;
		t1 = 0;
		t2 = 0;
		x = 0;
		n = 10;	
		z = 1;
		/* LICM */
		for(i=0; i < n; i = i + 1) {
			x = 3 + 2;
			t1 = x + z;
			x = 4 * 5;
			t2 = x + z;
			z = z * 1;
		}
		System.out.println(x);
		System.out.println(t1);
		System.out.println(t2);
	}
}
