import syntaxtree.*;
import visitor.*;

public class Main {
   public static void main(String [] args) {
      try {
         Node root = new LoopyTacoJavaParser(System.in).Goal();
         System.out.println("Program Parsed Successfully");
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
}
