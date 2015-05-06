class LTx1 {
	public static void main (String [] args) {
		int x;
		x = new HELPER1LTx1().foo();
	}
}
class HELPER1LTx1 {
	public int foo() {
		int i;
		int j;
		boolean f1;
		i = 0;
		j = 0;
		f1 = true;
		/* LOOPTILE 5 4 */
		for (i = 0 ;i < 25 ; i = i + 1)
			for (j = 0 ; j < 8; j = j + 1) {
				if (f1) {
				}
				else {
				}
			}
		System.out.println(i);
		System.out.println(j);
		return i;
	}
}
