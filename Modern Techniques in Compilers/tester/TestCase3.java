class TestCase3{
    public static void main(String[] a){
	    Test n;
	    n = new Test();
	    /*INLINE*/
	    n.initTest();
	}
  
}

class Test {
	
	  
    public int initTest(){
    	int i;
    	int n;
    	int temp;
    	int sum;
    	Test temp1;
    	sum=0;
    	n=100;
    	temp=0;
    	temp1 = new Test();
    	
    	for(i=0;i<n;i=i+1){
    		/*INLINE*/
    		temp = temp1.num();
    		sum = sum + temp;
    	}
    	
    	System.out.println(sum);
    	
    	return sum;
    }
    
    public int num(){
    	int x;
    	x=1;
    	return x;
    }
}