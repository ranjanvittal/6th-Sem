class LU4 {
	public static void main (String [] args) {
		int i;
		int n;
		int count;
		boolean f1;
		int t1;
		int t2;
		t1 = 0;
		t2 = 0;
		n = 13;
		count = 0;
		/* LOOPUNROLL 4 */
		for (i = 0; i < n; i = i + 1) {
			f1 = false;
			if(f1) {
				t1 = i;
			}
			else
				f1 = true;
			while(f1) {
				count = count + 1;	
				t2 = count;
				f1 = false;
			}
		}
		System.out.println(count);
		System.out.println(t1);
		System.out.println(t2);
	}
}
