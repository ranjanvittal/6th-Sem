class FunctionInliningHaHaHaHa{
    public static void main(String[] a){
    	int i1;
    	c2 o2;
    	c1 o1;
    	boolean b1;
    	b1=false;
    	
    		
    	o1=new c1();
    	o2=new c2();
    	if(b1)
    		/* INLINE */
    		i1=o1.f1();
    	else 
    		/* INLINE */
    		i1=o2.f2();
    	
    	
        System.out.println(i1);
    }
}
class c1{
	public int f1(){
		int i1;
		int i2;
		int i;
		i1=10;
		i2=2;
		for(i=0;i<i1;i=i+1)
			i2=i2+i1;
		return i2;	
	}
}
class c2 extends c1{
	public int f2(){
		int i1;
		int i2;
		int i;
		i1=10;
		i2=2;
		for(i=0;i<i1;i=i+1)
			i2=i2+i;
		return i2;	
	}
}