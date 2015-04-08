class Test3 {
	public static void main(String[] args) {

		int[] dd;
		int i;
		int size;
		int temp;
		Arr arr;
		arr = new Arr();
		size = 90;

		/* INLINE */
		dd = arr.getArr(size);
		temp = dd.length;
		for (i = 0; i < temp; i=i+1) {
			System.out.println(i);
		}
	}
}

class Arr {
	public int[] getArr(int size) {
		int j;
		int []dd;
		int temp;

		dd = new int[size];
		temp = dd.length;
		for (j = 0; j < temp; j=j+1) {
			dd[j] = j;
		}
		return dd;
	}

}