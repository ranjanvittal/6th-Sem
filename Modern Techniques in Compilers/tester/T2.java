class Test1{
	public static void main(String[] args){
		Fact a;
		int b;
		int c;
		
		a=new Fact();
		b=15;
		
		
		/*INLINE*/
		c=a.factorial(b);
		System.out.println(c);
	}
}
class Fact{
	public int factorial(int n){
		int zero;
		int j;
		int fact;
		boolean cond;
		zero=0;
		j=1;
		fact=1;
		cond=zero<n;
		while(cond){
			fact=n*fact;
			n=n-j;
			cond=zero<n;
		}
		return fact;
	}
}