
class TestP54 {

	public static void main (String[] args)
	{
			int a;
			int b;
			int c;
			Add t;
			t=new Add();
			a=10;
			b=15;
			
			/* INLINE */
			c=t.print(a, b);
			System.out.println(c);
			
			
	}
}
class Add
{
	public int print(int a,int b)
	{
		b=a+b;
		return b;
	}
}
