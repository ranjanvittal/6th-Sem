class LU1 {
	public static void main (String [] args) {
		int x;
		x = new HELPER1LU1().foo();
	}
}
class HELPER1LU1 {
	public int foo() {
		int i;
		int t;
		t = 0;
		/* LOOPUNROLL 3 */
		for (i = 0; i < 9; i = i + 1) {
			t = i;
		}
		System.out.println(i);
		System.out.println(t);
		return i;
	}
}
