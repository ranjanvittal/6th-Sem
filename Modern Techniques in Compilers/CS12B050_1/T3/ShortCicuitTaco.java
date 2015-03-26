class ShortCicuit {
    public static void main ( String [] Tacoa) {
       int temp1;
       int temp2;
       boolean f;
       ShortCicuiting i;
       f = true;
       temp2 = 2;
       i = new ShortCircuiting();
       temp1 = i.return_one(f, temp2);
       System.out.println(temp1);
    }
}

class ShortCircuiting {
  public int return_one(boolean t, int w) {
      boolean t1;
      int w1;
      boolean false_;
      int zero;
      int one;
      false_ = false;
      zero = 0;
      t1 = t&false_;
      w1 = w*zero;
      System.out.println(w1);
      System.out.println(t1);
      one = 1;
      return one;
  }
}
