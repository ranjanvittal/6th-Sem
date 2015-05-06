class LD6 {
	public static void main (String [] args) {
		int i;
		int k;
		int n;
		int l;
		int t1;
		int t2;
		int t3;
		int [] arr;
		boolean f1;
		f1 = false;
		t1 = 0;
		t2 = 0;
		k = 0;
		n = 5;
		l = 25;
		arr = new int[l];

		/* LOOPDISTRIBUTE */
		for(i = 0; i < n; i = i + 1) {
			arr[i] = i;
			t1 = arr[i];
		}

		/* LOOPDISTRIBUTE */
		for(i = 0; i < n; i = i + 1) {
			while(f1) {
				t1 = 2 * i;
				t2 = t1 + 1;
				arr[t2] = i;
			}
			t3 = 2 * i;
			t3 = arr[t1];
		}

		for(i = 0; i < n; i = i + 1) {
			t1 = arr[n];
			System.out.println(t1);
		}
		System.out.println(t1);
	}
}
