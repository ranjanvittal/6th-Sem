class FunctionInliningHaHaHa{
    public static void main(String[] a){
    	int i1;
    	c2 o1;
    	o1=new c2();
    	/* INLINE */
    	i1=o1.f1();
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
	
}