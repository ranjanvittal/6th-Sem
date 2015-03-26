import syntaxtree.*;
import visitor.*;

public class P2 {
   public static void main(String [] args) {
      try {
         Node root = new BuritoJavaParser(System.in).Goal();
         Object returns = root.accept(new GJDepthFirst<Object, Object>(), null); // Your assignment part is invoked here.
         root.accept(new GJDepthFirst2<Object, Object>(), returns);
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
}


