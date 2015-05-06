class LTx2 {
	public static void main (String [] args) {
		int x;
		x = new HELPER1LTx2().foo();
	}
}
class HELPER1LTx2 {
	public int foo() {
		int i;
		int j;
		int n;
		int m;
		boolean f1;
		f1 = false;
		n = 10;
		m = 20;
		i = 0;
		j = 0; 
		/* LOOPTILE 5 4 */
		for (i = 0 ;i < n ; i = i + 1)
			for (j = 0 ; j < m; j = j + 1) {
				while(f1) {
				}
			}
		System.out.println(i);
		System.out.println(j);
		return i;
	}
}
