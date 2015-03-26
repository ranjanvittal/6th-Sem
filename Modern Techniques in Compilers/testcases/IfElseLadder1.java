class IfElseLadder1{
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
		int twenty;
		int fifteen;
		int five;
		int one;
		boolean b;
		twenty=20;
		fifteen=15;
		five=5;
		one=1;
		i=10;
		b=i<twenty;
		if(b)
		{
			b=i<fifteen;
			if(b)
			{	b=i<five;
				if(b)
				{
				i=i-five;
				}
				else{
		   		i=i+one;
				}
			}
			else{
			   i=i+one;
			}
		}
		else{
		   i=i+one;
		}
		return i;
	}
}	
