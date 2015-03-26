class testcase2 {
	public static void main(String[] a) {
		folder a0;
		folder a1;
		int a2;
		int a3;

		a0 = new folder();
		a1 = a0;
		a2 = 10;
		a3 = a1.Start(a2);
		System.out.println(a3);
	}
}

class folder {
	int[] array;
	int n;

	public int Start(int size) {
		int a4;
		int a5;
		int[] a6;
		int a7;
		int a8;
		boolean a9;
		int a10;
		int a11;
		int a12;
		int a13;
		int a14;
		int a15;
		int a16;
		boolean a17;
		boolean a18;
		boolean a19;
		int a20;
		int a21;
		folder a22;
		folder a23;
		int a24;
		int a25;
		int a26;
		int a27;

		int a;
		int b;
		a4 = 5;
		a = a4;
		a5 = 2;
		b = a5;
		a6 = new int[size];
		array = a6;
		a7 = array.length;
		n = a7;
		a8 = 1;
		a9 = n < a8;
		while (a9) {
			{
				a10 = 1;
				a11 = n - a10;
				n = a11;
				a12 = 2;
				a13 = a12 + a;
				a14 = n * a13;
				array[n] = a14;
				a15 = array[n];
				System.out.println(a15);
			}

			a16 = 1;
			a17 = n < a16;
			a9 = a17;
		}
		a18 = a < n;
		if (a18) {
			{
				a19 = a < b;
				if (a19) {
					{
						a20 = 0;
						a = a20;
					}
				} else {
					a21 = 1;
					a = a21;
				}
			}
		} else {
			{
				a22 = this;
				a23 = a22;
				a24 = a23.Start(n);
				b = a24;
				a25 = 1;
				a26 = n - a25;
				n = a26;
			}
		}
		a27 = array[a];
		return a27;
	}
}
