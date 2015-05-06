class LD2 {
	public static void main (String [] args) {
		int x;
		x = new HELPER1LD2().foo();
	}
}
class HELPER1LD2 {
	public int foo() {
		int i;
		int k;
		int n;
		int l;
		k = 0;
		n = 5;
		l = 0;
		/* LOOPDISTRIBUTE */
		for(i = 0; i < n; i = i + 1) {
			k = i;
			k = i;
			l = k;
		}
		System.out.println(k);
		System.out.println(i);
		System.out.println(l);
		return l;
	}
}
