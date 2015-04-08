

class TestP55 {

	public static void main (String[] args)
	{
		A s;
		B t;
		C r;
		int p;
		s=new A();
		t=new B();
		r=new C();
		
		/* INLINE */
		p=s.Add();
		System.out.println(p);
		
		/* INLINE */
		p=t.Add();
		System.out.println(p);
		
		/* INLINE */
		p=r.Add();
		System.out.println(p);
		
		s=new B();
		
		/* INLINE */
		p=s.Add();
		System.out.println(p);
	}
}
class A
{
	int a;	
	public int Add()
	{
		a=10;
		return a;
	}
}
class B extends A
{
	int b;	
	public int Add()
	{
		a=15;
		b=17;
		System.out.println(b);
		return a;
	}
}
class C extends B
{
	int c;	
	public int Add()
	{
		a=16;
		b=19;
		c=24;
		System.out.println(b);
		System.out.println(c);
		return a;
	}
}