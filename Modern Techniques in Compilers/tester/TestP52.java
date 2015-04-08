
class TestP52 {
	public static void main (String[] args)
	{
			int a;
			int b;
			int c;
			Divide s;
			b=100;
			c=15;
			s=new Divide();
			/* INLINE */
			a=s.div(b,c);
			System.out.println(a);
	}
}
class Divide
{
	public int div(int b,int c)
	{
		int q;
		boolean sp;
		q=0;
		sp=c<b;
		while(sp)
		{
			b=b-c;
			q=q+1;
		}
		return q;
	}
}