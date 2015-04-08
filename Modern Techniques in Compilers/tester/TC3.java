class TC3 {
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
		int num;
		num = this.getNum();
		/*INLINE*/
		c = this.close(num);
		return c;
	}
	
	public int close(int r) {
		int num;
		int tmp;
		int c;
		boolean b;
		tmp = this.getNum();
		num = tmp * 2;
		b = r < 0;
		if(b)
			c = num + 10;
		else
			c = num + 20;
		return c;
	}
	
	public int getNum() {
		int ret;
		ret = 100;
		return ret;
	}
}