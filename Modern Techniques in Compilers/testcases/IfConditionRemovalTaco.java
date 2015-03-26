class IfConditionRemovalTaco {
    public static void main ( String [] Tacoa) {
       int temp1;
       boolean f;
       GenIf i;
       f = true;
       i = new GenIf();
       temp1 = i.return_five(f);
       System.out.println(temp1);
    }
}

class GenIf {
  public int return_five(boolean t) {
      int temp1;
      int temp2;
      int temp3;
      int temp4;
      temp2 = 0;
      temp3 = 1;
      if(t) {
          temp1 = 1;
      }
      else {
          temp1 = temp2+temp3;
      }
      temp4 = temp1*temp1;
      return temp4;
  }
}
