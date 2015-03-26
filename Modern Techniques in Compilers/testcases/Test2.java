class Test2 {
	public static void main(String[] args){
		int a;
		int b;
		int i;
		int c;
		int n;
		boolean t1;
		boolean t2;
		a=2;
		b=0;
		i=1;
		n=10;
		t1=i<n;
		while(t1){
			t2=b<i;
			if(t2){
				a=a+i;
			}
			else
			{
				i=i*b;
				}
			c=1;
			i=i+c;
			t1=i<n;
		}
		System.out.println(a);
		System.out.println(b);
		System.out.println(i);
		System.out.println(n);
	}
}
