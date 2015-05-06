class LTx3 {
	public static void main (String [] args) {
		int i;
		int j;
		int n;
		int m;
		boolean f1;
		int t1;
		int t2;
		int [] arr;
		int size;
		size = 100;
		i = 0;
		j = 0;
		t1 = 0;
		t2 = 0;
		f1 = false;
		n = 10;
		m = 20;
		arr = new int [size];
		/* LOOPTILE 5 4 */
		for (i = 0 ;i < n ; i = i + 1)
			for (j = 0 ; j < m; j = j + 1) {
				while(f1) {
				}
			}

		/* LOOPTILE 5 4 */
		for(i = 0; i < n; i = i + 1)
			for (j = 0 ; j < m; j = j + 1) {
				t1 = 2 * i;
				arr[t1] = i;
				t1 = 2 * i;
				t2 = arr[t1];
			}
		System.out.println(i);
		System.out.println(j);
	}
}
