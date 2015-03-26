class TACO_P3_testcase1 {
	public static void main(String[] args) {
		Conditional temp_2_2;
		int temp_2_3;
		temp_2_2 = new Conditional();
		temp_2_3 = temp_2_2.test();
		System.out.println(temp_2_3);
	}
}

class Conditional {
	public int test() {
		int a;
		int b;
		int c;
		int temp_2_13;
		int temp_2_5;
		int temp_2_6;
		int temp_2_7;
		boolean temp_2_8;
		boolean temp_2_9;
		int temp_3_10;
		int temp_3_11;
		int temp_3_12;
		temp_2_5 = 10;
		temp_2_6 = 1;
		temp_2_7 = 5;
		temp_2_8 = false;
		temp_2_9 = false;
		temp_3_10 = 20;
		temp_3_11 = 10;
		a = temp_2_5;
		b = temp_2_6;
		temp_2_8 = b < temp_2_7;
		temp_2_9 = temp_2_8;
		if (temp_2_9) {
			{
				c = temp_3_10;
			}
		} else {
			{
				temp_3_12 = temp_3_11 + a;
				c = temp_3_12;
			}
		}
		System.out.println(c);
		temp_2_13 = c;
		return temp_2_13;
	}
}
