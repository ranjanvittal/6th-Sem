import syntaxtree.*;
import visitor.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class P5 {
   public static void main(String [] args) {
      try {
         FunkyTacoJavaParser funkyTacoJavaParser = new FunkyTacoJavaParser(System.in);
         Node root1 = funkyTacoJavaParser.Goal();
         Object passOn = (Object) root1.accept(new GJDepthFirst<Object, Object>(), null);
         root1.accept(new GJDepth2<Object, Object>(), passOn);
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
}


