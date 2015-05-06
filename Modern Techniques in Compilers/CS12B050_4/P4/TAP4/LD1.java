class LD1 {
	public static void main (String [] args) {
		int x;
		x = new HELPER1LD1().foo();
	}
}
class HELPER1LD1 {
	public int foo() {
		int i;
		int k;
		int n;
		int l;
		int [] arr;
		k = 0;
		n = 5;
		l = 0;
		arr = new int[n]; 

		/* LOOPDISTRIBUTE */
		for(i = 0; i < n; i = i + 1) {
			arr[i] = k;
			k = arr[i];
		}
		l = arr[l];
		System.out.println(l);

		/* LOOPDISTRIBUTE */
		for(i = 0; i < n; i = i + 1) {
			k = 3;
			l = 3;
		}
		System.out.println(k);
		System.out.println(l);
		return l;
	}
}
