class TestP32
{
public static void main (String[] b)
{
		Start a;
		int t;
		int d;
		t=4;
		a=new Start();
		d=a.cons(t);
}
}	
class Start
{
	public int cons(int n)
	{
		int i;
		int j;
		int k;
		boolean exp;
		j=0;
		i=0;
		k=1;
		exp=k<n;
		while(exp)
		{
			k=5;
			j=k+k;
			System.out.println(j);
			exp=k<n;
		}
		return k;
	}
}