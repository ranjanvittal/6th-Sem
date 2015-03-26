import syntaxtree.*;
import visitor.*;

public class Main {
   public static void main(String [] args) {
      try {
         Node root = new TACoJavaParser(System.in).Goal();
         System.out.println("Program Parsed Successfully");
         root.accept(new GJDepthFirst<Object, Object>(), null);
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
}


