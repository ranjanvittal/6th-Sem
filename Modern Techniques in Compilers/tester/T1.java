class Test1{
	public static void main(String[] args){
		Sum a;
		int b;
		int c;
		a=new Sum();
		b=5000;
		c=1000;
		/*INLINE*/
		c=a.add(b,c);
		System.out.println(c);
	}
}
class Sum{
	public int add(int a,int b){
		int s;
		s=a+b;
		return s;
	}
}