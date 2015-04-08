
class Test1 {
	public static void main(String[] args) {

		A a;
		int temp;
		int temp1;
		a=new B();
		/*INLINE*/
		a.fun();
		/*INLINE*/
		temp=a.geti();
		a=new A();
		/*INLINE*/
		temp1=a.fun();
		System.out.println(temp1);
		System.out.println(temp);
		
		
	}
}

class B extends  A {
	int i;
	public int fun(){
		i=9;
		return i;
	}
	public int geti(){
		return i;
	}

}

class A{
	int i;
	public int  fun() {
		i=90;
		return i;
		
	}
	public int geti(){
		return i;
	}
}

