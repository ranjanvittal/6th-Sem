class InlineTest2 {

	public static void main(String[] args) {
		Utils1 utils;
		int sum;
		int a;
		int b;
		sum = 0;
		a = 10;
		b = 15;
		utils = new Utils1();
		/* INLINE */
		a = utils.sum(a, b);
		System.out.println(a);
		System.out.println(b);
		/* INLINE */
		a = utils.mul(a, b);
		System.out.println(a);
		System.out.println(b);
		/* INLINE */
		b = utils.sum(a, b);
		System.out.println(a);
		System.out.println(b);

	}

}

class Utils1 {

	public int sum(int a, int b) {
		int sum;
		sum = a + b;
		return sum;
	}

	public int mul(int a, int b) {
		int sum;
		sum = a * b;
		return sum;
	}

}
