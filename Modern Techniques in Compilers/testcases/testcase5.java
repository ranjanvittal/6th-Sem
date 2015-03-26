class testcase5 {
	public static void main(String[] args) {
		beeta a0;
		beeta a1;
		int a2;
		int a3;

		a0 = new beeta();
		a1 = a0;
		a2 = 100;
		a3 = a1.recursive(a2);
		System.out.println(a3);
	}
}

class beeta {
	public int recursive(int aa1) {
		int a4;
		int a5;
		int a6;
		boolean a7;
		int a8;
		beeta a9;
		beeta a10;
		int a11;
		int a12;
		int a13;
		int a14;

		int b;
		int a;
		a4 = 0;
		a = a4;
		a5 = 1;
		b = a5;
		a6 = 1;
		a7 = a < a6;
		if (a7) {
			a8 = 10;
			b = a8;
		} else {
			{
				a9 = this;
				a10 = a9;
				a11 = 1;
				a12 = a - a11;
				a13 = a10.method(a12);
				a14 = b * a13;
				b = a14;
			}
		}
		return b;
	}

	public int method(int aa1) {
		int a15;
		int a16;
		int a17;
		boolean a18;
		int a19;
		beeta a20;
		beeta a21;
		int a22;
		int a23;
		int a24;
		int a25;

		int a;
		int b;
		a15 = 1;
		b = a15;
		a16 = 0;
		a = a16;
		a17 = 1;
		a18 = a < a17;
		if (a18) {
			a19 = 15;
			b = a19;
		} else {
			{
				a20 = this;
				a21 = a20;
				a22 = 1;
				a23 = a - a22;
				a24 = a21.recursive(a23);
				a25 = b * a24;
				b = a25;
			}
		}
		return b;
	}
}
