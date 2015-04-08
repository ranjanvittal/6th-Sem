
class TestP51 {
	public static void main (String[] args)
	{
			int b;
			int c;
			int e;
			Maths s;
			int[] t;
			c=100;
			t=new int[c];
			b=10;
			c=15;
			s=new Maths();
			
			/* INLINE */
			t=s.add(b);
			/* INLINE */
			e=s.mul(b,c);
			System.out.println(e);
	}
}
class Maths
{
	public int[] add(int c)
	{
		int i;
		int st;
		int size;
		int[] val;
		size=100;
		val=new int[size];
		for(i=0;i<c;i=i+1)
		{
			st=i+1;
			val[i]=st;
			System.out.println(st);
		}
		return val;
	}
	
	public int mul(int d,int e)
	{
		int f;
		f=d*e;
		return f;
	}
}