class LD4 {
	public static void main (String [] args) {
		int i;
		int k;
		int n;
		int l;
		int z;
		int [] arr;

		k = 0;
		n = 5;
		l = 0;
		z = 0;
		arr = new int[n]; 
		/* LOOPDISTRIBUTE */
		for(i = 0; i < n; i = i + 1) {
			{
				k = 1;
				z = i;
			}
			z = l + 1;
		}

		/* LOOPDISTRIBUTE */
		for(i = 0; i < n; i = i + 1) {
			k = 3;
			l = 3;
		}
		System.out.println(k);
		System.out.println(l);
		System.out.println(z);
	}
}
