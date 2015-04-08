class Test5 {
	public static void main(String[] args) {
		Fun fun;
		
		fun=new Fun();
		/*INLINE*/
		fun.f1();
		/*INLINE*/
		fun.f1();
	}
}
class Fun{
	public int  f1() {
		int ret;
		ret=0;
		/*INLINE*/
		this.f2();
		return ret;
		
	}
	public int  f2() {
		int ret;
		ret=0;
		/*INLINE*/
		this.f3();
		
		return ret;
		
	}
	public int  f3() {
		int ret;
		ret=0;
		/*INLINE*/
		this.f4();
		return ret;
		
	}
	public int  f4() {
		int ret;
		ret=0;
		/*INLINE*/
		this.f5();
		return ret;
		
	}
	public int  f5() {
		int ret;
		ret=5;
		System.out.println(ret);
		return ret;
		
	}
	
	
	
}