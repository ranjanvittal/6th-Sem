class TACO_P3_testcase4 {
	public static void main(String[] args) {
		Conditional3 temp_2_2;
		int temp_2_3;
		temp_2_2 = new Conditional3();
		temp_2_3 = temp_2_2.test();
		System.out.println(temp_2_3);
	}
}

class Conditional3 {
	public int test() {
		int a;
		int b;
		int c;
		int d;
		int e;
		boolean temp_2_10;
		boolean temp_2_11;
		int temp_2_15;
		int temp_2_5;
		int temp_2_6;
		int temp_2_7;
		int temp_2_8;
		int temp_2_9;
		int temp_3_12;
		int temp_3_13;
		int temp_3_14;
		temp_2_10 = false;
		temp_2_11 = false;
		temp_2_5 = 10;
		temp_2_6 = 30;
		temp_2_7 = 10;
		temp_2_8 = 3;
		temp_3_13 = 2;
		a = temp_2_5;
		b = temp_2_6;
		d = temp_2_7;
		temp_2_9 = temp_2_8 * b;
		c = temp_2_9;
		temp_2_10 = c < b;
		temp_2_11 = temp_2_10;
		if (temp_2_11) {
			{
				temp_3_12 = a + b;
				e = temp_3_12;
			}
		} else {
			{
				temp_3_14 = b + temp_3_13;
				d = temp_3_14;
			}
		}
		System.out.println(b);
		temp_2_15 = b;
		return temp_2_15;
	}
}
