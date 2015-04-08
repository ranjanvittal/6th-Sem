
class TestP53 {

	public static void main (String[] args)
	{
			Base s;
			Child b;
			int t;
			s=new Base();
			b=new Child();
			 /* INLINE */
			t=s.print();
			
			/* INLINE */
			t=b.print();
	}
	
}
class Base
{
	int a;
	public int print()
	{
		int c;
		c=1;
		a=10;
		System.out.println(a);
		return c;
	}
}
class Child extends Base
{
	int b;
	public int print()
	{
		int c;
		c=1;
		a=10;
		b=15;
		System.out.println(a);
		System.out.println(b);
		return c;
	}
}
