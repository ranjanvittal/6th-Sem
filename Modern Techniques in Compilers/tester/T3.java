class Test1{
	public static void main(String[] args){
		Uid a;
		int b;
		int c;
		int i;
		int one;
		one=1;
		a=new Uid();
		b=15;
		/*INLINE*/
		a.init();
		for(i=0;i<b;i=i+one){
			/*INLINE*/
			c=a.getid();
			System.out.println(c);
		}
		
		
		
	}
}
class Uid{
	int id;
	public int getid(){
		int one;
		one=1;
		id=id+one;
		return id;
	}
	public int init(){
		id=0;
		return id;
	}
}