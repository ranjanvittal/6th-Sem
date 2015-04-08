import syntaxtree.*;
import visitor.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class P5 {
   public static void main(String [] args) {
      try {
         TACoJavaParser tacoJavaParser = new TACoJavaParser(System.in);
         Node root1 = tacoJavaParser.Goal();
         System.out.println("Program parsed successfully");

      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
}


