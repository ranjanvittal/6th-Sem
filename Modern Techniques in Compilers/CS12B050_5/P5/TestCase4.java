class TestCase4{
    public static void main(String[] a){
	    Test n;
	    int t;
	    int t1;
	    int max;
	    boolean temp;
	    n = new Test();
	    t = 50;
	    max = 500;
	    temp = t < max; 
	    while(temp){
	    	/*INLINE*/
		    t1 = n.initTest(t);
		    System.out.println(t1);
		    t = t + 50;
		    temp = t < max;
	    }
	    
    }
}

class Test {
    public int initTest(int num){

    int i; 
    boolean j ;
	int k;
    i = 250;
    j = i < num;
	if(j){
		i = i + 10;
	}
	else{
		/*INLINE*/
		k = new Test().endTest();
	}
    System.out.println(i);
    return i;
    }
    
    public int endTest(){
    	int i;
    	int j;
    	i = 10;
    	j = 20;
    	System.out.println(i);
    	System.out.println(j);
    	return i;
    }
}