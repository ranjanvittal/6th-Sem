class TestCase5{
    public static void main(String[] a){
	    Test n;
	    int t;
	    int t1;
	    n = new Test();
	    t = 256;
	    /*INLINE*/
	    t1 = n.initTest(t);
	    System.out.println(t1);

    }
}

class Test {
    public int initTest(int num){

    int i; 
    int j ;
	int k;
	int y;
	int sum;
	int [] a;
	int kk ;
	boolean x;
	int m;
	int ret;
	j = 2;
	ret = 0;
	kk = 20;
        m = num + num;
	a = new int[m];
	k = 4; sum = 0;

	for(i=0;i<num;i=i+1){
		i = i * j;
		  a[j] = i;
		  k = a[j];
		  sum = sum + k;
		  
		  for(y=i;y<num;y=y+1){
			  sum = sum + y;
			  a[y] = sum;
		  }
	}
		
		kk = num - 1;
		ret = a[kk];
        return ret ;
    }
}