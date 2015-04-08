class TestCase2{
    public static void main(String[] a){
	    SumArray n;
	    int t;
	    int t1;
	    n = new SumArray();
	    t = 1024;
	    /*INLINE*/
	    t1 = n.ComputeSumArray(t);
	    System.out.println(t1);

    }
}

class SumArray {
    public int ComputeSumArray(int num){

    int i; 
    int j ;
	int k;
	boolean x;
	int sum;
	int sum2;
	int [] a;
	int [] b;
	int kk;
	int ret;
	ret = 0;
	kk = 20;
	a = new int[num];
	b = new int[num];
	k = 4; 
	sum = 0;

	  for (j=0;j<num;j=j+1) {
		  k = j * j;
		  a[j] = k;
	  }
	  
	  for (j=1;j<num;j=j+1) {
		  k = j+1;
		  x = k < num;
		  if(x) {
			  a[k] = kk;
			  k = j - 1;
			  kk = a[k];  
		  }
		  else{
			  
		  }
		  
	  }

	  for (j=1;j<num;j=j+1) {
		  a[j] = j;
		  k = j - 1;
		  kk = a[k];
		  sum = sum + j;
	  }
	
	  for (j=0;j<num;j=j+1) {
		  a[j] = j; 
		  k = j+1;
		  x = k < num;
		  if(x){
			  kk = a[k];
				
			  b[j] = kk;  
		  }
		  else{
			  
		  }
		  
	  }

        return sum ;
    }
}