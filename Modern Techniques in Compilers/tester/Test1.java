class Test1 {
	public static void main(String[] args) {
		int a;
		int b;
		Line a1;
		a = 9;
		b = 8;
		a1 = new Line();
		/*INLINE*/
		a=a1.name();
		System.out.println(a);
		System.out.println(b);
	}

}

class Line {

	public int name() {
		int a;
		a = 0;
		for(a=0;a<10;a=a+1)
		{
			System.out.println(a);
			/*INLINE*/
			this.fun(a);
		}
		return a;

	}
	public int  fun(int a) {
		a=a+1;
		for(a=0;a<10;a=a+1)
		{
			System.out.println(a);
			
		}
		return a;
	}
	
}