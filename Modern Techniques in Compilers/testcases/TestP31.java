class TestP31
{
public static void main (String[] a)
{
		int b;
		int c;
		int d;
		int e;
		Maths s;
		b=10;
		c=15;
		s=new Maths();
		d=s.add(b);
		e=s.loop(b,c);
		
}
}
class Maths
{
	public int add(int c)
	{
		int ad;
		boolean exp;
		boolean exp2;
		int id;
		int id1;
		int id2;
		int i;
		int j;
		i=0;
		j=1;
		id=20;
		id1=15;
		id2=50;
		exp=c<id;
		if(exp)
		{
			ad=c+id1;
			exp2=ad<id2;
			if(exp2)
				System.out.println(j);
			else 
				System.out.println(i);
				
		}
		else{}
		return j;
	}
	public int loop(int f1,int f2)
	{
		int i;
		boolean exp1;
		boolean exp3;
		int id3;
		int id4;
		int id5;
		id4=1;
		id3=20;
		id5=0;
		i=f2-id4;
		exp1=id5<i;
		while(exp1)
		{
			exp3=id5<i;
			if(exp3)
			{
				i=i-id4;
				System.out.println(i);
				exp3=id5<i;
			}
			else
			{}
			exp1=id5<i;
			
		}
		return id4;
	}
}