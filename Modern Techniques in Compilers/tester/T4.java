class TestCase1{
    public static void main(String[] a){
	    SumArray n;
	    int temp1;
	    int temp2;
	   
	    n = new SumArray();
	    temp1 = 96;
	    /*INLINE*/
	    temp2=n.ComputeSumArray(temp1);
	    System.out.println(temp2);

    }
}

class SumArray {
    public int ComputeSumArray(int num){

    int i; 
    int j ;
	int k;
	int sum;
	int sum2;
	int [] a;
	a = new int[num];
	k = 4; sum = 0;

	
	  for (j=0;j<num;j=j+1) {
		  i = j * j;
		  a[j] = i;
		  k = a[j];
		  sum = sum + k;
	  }
	
        return sum ;
    }
}