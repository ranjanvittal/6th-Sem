class TACO_P3_testcase2 {
	public static void main(String[] args) {
		Conditional1 temp_2_2;
		int temp_2_3;
		temp_2_2 = new Conditional1();
		temp_2_3 = temp_2_2.test();
		System.out.println(temp_2_3);
	}
}

class Conditional1 {
	public int test() {
		int a;
		int b;
		int c;
		int temp_2_18;
		boolean temp_2_19;
		int temp_2_20;
		int temp_2_5;
		int temp_2_6;
		int temp_2_7;
		int temp_2_8;
		boolean temp_2_9;
		int temp_3_10;
		boolean temp_3_11;
		boolean temp_3_12;
		int temp_3_16;
		int temp_3_17;
		int temp_4_13;
		int temp_4_14;
		int temp_4_15;
		temp_2_18 = 20;
		temp_2_19 = false;
		temp_2_5 = 0;
		temp_2_6 = 30;
		temp_2_7 = 10;
		temp_2_8 = 20;
		temp_2_9 = false;
		temp_3_10 = 10;
		temp_3_11 = false;
		temp_3_12 = false;
		temp_3_16 = 10;
		temp_4_13 = 70;
		temp_4_14 = 40;
		b = temp_2_5;
		c = temp_2_6;
		a = temp_2_7;
		temp_2_9 = a < temp_2_8;
		while (temp_2_9) {
			{
				temp_3_11 = a < temp_3_10;
				temp_3_12 = temp_3_11;
				if (temp_3_12) {
					{
						b = temp_4_13;
					}
				} else {
					{
						temp_4_15 = c + temp_4_14;
						b = temp_4_15;
					}
				}
				temp_3_17 = a + temp_3_16;
				a = temp_3_17;
			}
			temp_2_19 = a < temp_2_18;
			temp_2_9 = temp_2_19;
		}
		System.out.println(b);
		temp_2_20 = b;
		return temp_2_20;
	}
}
