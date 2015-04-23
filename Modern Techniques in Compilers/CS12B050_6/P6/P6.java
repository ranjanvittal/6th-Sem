import syntaxtree.*;
import visitor.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class P6 {
   public static void main(String [] args) {
      try {
         QTACoJavaParser qtp = new QTACoJavaParser(System.in);
         Node n = qtp.Goal();
         n.accept(new GJDepthFirst<Object, Object>(), null);
         System.out.println("Parsed successfully");
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
}


