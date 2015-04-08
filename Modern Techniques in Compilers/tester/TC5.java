class TC5 {
	public static void main(String[] a){
        NumAdd mtTmp2;
        int mtTmp3;
        int mtTmp4;
        int mtTmp1;
        mtTmp2 = new NumAdd();
        mtTmp3 = 10;
        mtTmp4 = 20;
        mtTmp1 = mtTmp2.Start(mtTmp3,mtTmp4);
        System.out.println(mtTmp1);
	}
}

class NumAdd {
	public int Start(int a, int b) {
		int c;
		int num1;
		int num2;
		A obj1;
		B obj2;
		obj1 = new A();
		obj2 = new B();
		/*INLINE*/
		num1 = obj1.getNum();
		/*INLINE*/
		num2 = obj2.close(num1);
		return num2;
	}
}

class A {
	public int getNum() {
		int ret;
		ret = 100;
		return ret;
	}
}

class B extends A {
	public int getNum() {
		int ret;
		ret = 200;
		return ret;
	}
	
	public int close(int r) {
		int num;
		int tmp;
		int c;
		B obj;
		obj = new B();
		/*INLINE*/
		tmp = obj.getNum();
		num = tmp * 2;
		c = num - 10;
		return c;
	}
}