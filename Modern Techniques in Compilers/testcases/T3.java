class T3
{
	public static void main(String[] args)
	{
		int[] a;
		int size;
		int b;
		int c;
		size=3;
		a=new int[size];
		b=0;
		c=1;
		a[b]=c;
		a[c]=b;
		c=a[b];
		System.out.println(c);
	}
}