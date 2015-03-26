class TestP33
{
public static void main (String[] a)
{
	Trial t;
	int s1;
	int p;
	p=10;
	t=new Trial();
	s1=t.Method(p);
	System.out.println(s1);
}
}
class Trial
{
	public int Method(int k)
	{
		int i;
		int j;
		boolean s;
		boolean st;
		boolean exp1;
		int n;
		int n1;
		int n2;
		n1=1;
		n2=15;
		n=5;
		for(i=0;i<n;i=i+n1)
		{
			k=k+i;
			exp1=k<n2;
			if(exp1)
			{
				j=5;
				st=j<n2;
				if(st)
				{
					System.out.println(j);
				}
				else{}
			}
			else
			{
			System.out.println(i);
			}
		}
		return n1;
	}
}