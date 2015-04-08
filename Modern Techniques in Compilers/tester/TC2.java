class TC2 {
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
		/*INLINE*/
		c = this.close(a, b);
		return c;
	}
	
	public int close(int r1, int r2) {
		int num;
		num = r1 * r2;
		return num;
	}
}