class LD5 {
	public static void main (String [] args) {
		int i;
		int j;
		int k;
		int n;
		int l;
		int t1;
		int t2;
		int t3;
		int t4;
		int t5;
		int [] arr;
		boolean f1;
		f1 = true;
		t1 = 0;
		t2 = 0;
		k = 0;
		n = 5;
		l = 25;
		j = 3;
		arr = new int[l];

		/* LOOPDISTRIBUTE */
		for(i = 0; i < n; i = i + 1) {
			{
				t1 = 2 * k;
				t2 = t1 + 3;
				arr[t2] = i;
			}
			t1 = 3 * j;
			t2 = t1 + 4;
			t1 = arr[t2];
		}
		System.out.println(t1);

		/* LOOPDISTRIBUTE */
		for(i = 0; i < n; i = i + 1) {
			{
				t1 = 2 * i;
				arr[t1] = i;
			}
			t1 = 2 * i;
			t2 = t1 + 2;
			t1 = arr[t2];
		}
		System.out.println(t1);

		/* LOOPDISTRIBUTE */
		for(i = 0; i < n; i = i + 1) {
			if(f1) {
				t1 = 2 * i;
				t2 = t1 + 1;
				arr[t2] = i;
			}
			else {
				t4 = 2 * i;
				t5 = t4 + 3;
				arr[t5] = j;
			}

				t3 = 2 * i;
				arr[t3] = t3;
		}
		System.out.println(t1);


	}
}
