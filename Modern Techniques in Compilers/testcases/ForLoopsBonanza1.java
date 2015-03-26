class ForLoopsBonanza1{
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
		int ten;
		int one;
		int zero;
		int hundred;
		hundred=100;
		zero=0;
		ten=10;
		one=1;
		c=1;
		i=1;
		x=1;
		for(i=1;i<ten;i=i+one)
		{
			for(c=1;c<zero;c=c+one)
			{
			    c=c*i;
			}			
			
			x=x*c;
			x=x+hundred;
			x=x-hundred;		
			
		}
		return x;
	}
}	
