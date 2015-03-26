class WhileLoops{
    public static void main(String[] a){
	c1 c;
	int i;
	c=new c1();
	i=c.init();
        System.out.println(i);
    }
}
class c1 {
	
	public int init(){
		int i;
		int x;
		int c;
		boolean b;
		int hundred;
		int one;
		int ten;
		int zero;
		ten=10;
		hundred=100;
		one=1;
		zero=0;
		c=1;
		i=1;
		x=1;
		b=i<ten;
		while(b)
		{
			b=c<zero;
			while(b)
			{
			    c=c*i;
			}			
			
			x=x*c;
			x=x+hundred;
			x=x-hundred;		
			i=i+one;
		}
		return x;
	}
}	
