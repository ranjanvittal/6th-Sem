import syntaxtree.*;
import visitor.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class P4 {
   public static void main(String [] args) {
      try {
         LoopyTacoJavaParser loopyTacoJavaParser = new LoopyTacoJavaParser(System.in);
         Node root1 = loopyTacoJavaParser.Goal();
         // System.out.println("Program Parsed Successfully");
         String prog1 = (String) root1.accept(new GJDepthFirst<Object, Object>(), null);
         // System.out.println(prog1);
         InputStream is1 = new ByteArrayInputStream( prog1.getBytes() );
         loopyTacoJavaParser.ReInit(is1);
         Node root2 = loopyTacoJavaParser.Goal();
         String prog2 = (String) root2.accept(new GJDepth2<Object, Object>(), null);
         InputStream is2 = new ByteArrayInputStream(prog2.getBytes());
         loopyTacoJavaParser.ReInit(is2);

         Node root3 = loopyTacoJavaParser.Goal();
         String prog3 = (String) root3.accept(new GJDepth3<Object, Object>(), null);
         System.out.println(prog3);
         InputStream is3 = new ByteArrayInputStream(prog3.getBytes());
         loopyTacoJavaParser.ReInit(is3);
         loopyTacoJavaParser.Goal();
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
}


