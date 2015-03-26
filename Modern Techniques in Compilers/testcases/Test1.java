class Test1{
	public static void main(String[] args){
		int a;
		int b;
		int c;
		int temp;
		boolean t1;
		boolean t2;
		boolean t3;
		a=5;
		temp=2;
		b=a+temp;
		c=b-a;
		t1=b<a;
		t2=c<a;
		t3=c<b;
		if(t1){
			if(t2)
			{System.out.println(a);}
			else
			{System.out.println(c);}
		}
		else{
			if(t3){
				System.out.println(b);
			}
			else{
				System.out.println(c);
			}
		}
	}
}