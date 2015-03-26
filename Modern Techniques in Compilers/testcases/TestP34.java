class TestP34
{
public static void main (String[] s)
{
	int a;
	int b;
	int c;
	int d;
	boolean t;
	boolean t1;
	a=10;
	b=15;
	d=30;
	c=a+b;
	t=a<b;
	t1=c<d;
	if(t)
	{
		if(t1)
			System.out.println(c);
		else
			System.out.println(b);
	}
	else
	{
		System.out.println(a);
	}
}
}