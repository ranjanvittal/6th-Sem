class InlineTest1 {

	public static void main(String[] args) {
		int ret;
		int[] arr;
		int t;
		Utils utils;
		ret = 10;
		t = 0;
		arr = new int[ret];
		utils = new Utils();
		for (t = 0; t < ret; t = t + 1) {
			arr[t] = t;
		}
		System.out.println(t);
		/* INLINE */
		ret = utils.sum_arr(arr);
		System.out.println(ret);
	}

}

class Utils {

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

	public int sum_arr(int[] a) {
		int sum;
		int n;
		int i;
		int t;
		sum = 0;
		i = 0;
		n = a.length;
		t = 0;
		for (i = 0; i < n; i = i + 1) {
			t = a[i];
			sum = this.sum(t, sum);
		}
		return sum;
	}

}
