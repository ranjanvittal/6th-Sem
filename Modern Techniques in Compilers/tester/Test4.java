
 class Test4 {
public static void main(String[] args) {
	FunInLine l;
	l=new FunInLine();
		/*INLINE*/
	l.getInt();
}
}
 class FunInLine{
	 boolean b;
	 int ret;
	public int  getInt() {
		ret=0;
		
		b=true;
		while (b) {
			ret=ret+1;
			System.out.println(ret);
		}
		return ret;
	} 
	 
 }
