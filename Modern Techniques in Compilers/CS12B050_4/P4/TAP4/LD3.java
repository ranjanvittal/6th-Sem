class LD3 {
	public static void main (String [] args) {
		int x;
		x = new HELPER1LD3().foo();
	}
}
class HELPER1LD3 {
	public int foo () {
		int i;
		int k;
		int n;
		int t1;
		int t2;
		int [] arr;
		int size;

		t1 = 0;
		t2 = 0;
		k = 0;
		n = 5;
		size = 15; 
		arr = new int[size]; 

		/* LOOPDISTRIBUTE */
		for(i = 0; i < n; i = i + 1) {
			arr[i] = i;
			t1 = i * 2;
			t2 = t1 + 3;
			k = arr[t2];
		}
		System.out.println(k);
		/* LOOPDISTRIBUTE */

		for(i = 0; i < n; i = i + 1) {
			arr[i] = i;
			k = 10;
		}
		System.out.println(k);
		return k;
	}
}
