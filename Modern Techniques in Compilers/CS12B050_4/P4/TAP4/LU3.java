class LU3 {
	public static void main (String [] args) {
		int i;
		int n;
		int t;
		t = 1;
		n = 11;
		/* LOOPUNROLL 4 */
		for (i = 0; i < n; i = i + 1) {
			t = i;
		}
		System.out.println(i);
		System.out.println(t);
	}
}
