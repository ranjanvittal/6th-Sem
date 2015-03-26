//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJDepthFirst2<R,A> extends GJDepthFirst<R, A> {
    //
    // Auto class visitors--probably don't need to be overridden.
    //

    String overall_code = "";
    String declaration_code = "";
    String code_within_method = "";
    String arguments = "";
    String currentClass;
    SymbolTable currentSymbolTable;
    int ct = 0;

    public class NameAndType  {
        String variable;
        String type;
    }

    public R makeVarAndAssign(String type, String rhs) {
        String new_var = "temp" + ct++;
        declaration_code += type + " " + new_var + ";\n";
        code_within_method += new_var + " = " + rhs + ";\n";
        NameAndType  nameAndType  = new NameAndType ();
        nameAndType.variable = new_var;
        nameAndType.type = type;
        return (R) nameAndType ;
    }
    public R visit(NodeList n, A argu) {
        int _count=0;
        for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
        }
        return null;
    }

    public R visit(NodeListOptional n, A argu) {
        if ( n.present() ) {
            R _ret=null;
            int _count=0;
            for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
                e.nextElement().accept(this,argu);
                _count++;
            }
            return _ret;
        }
        else
            return null;
    }

    public R visit(NodeOptional n, A argu) {
        if ( n.present() )
            return n.node.accept(this,argu);
        else
            return null;
    }

    public R visit(NodeSequence n, A argu) {
        R _ret=null;
        int _count=0;
        for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
        }
        return _ret;
    }

    public R visit(NodeToken n, A argu) { return null; }

    //
    // User-generated visitor methods below
    //

    /**
     * f0 -> MainClass()
     * f1 -> ( TypeDeclaration() )*
     * f2 -> <EOF>
     */
    public R visit(Goal n, A argu) {
        global = (Hashtable<String, SymbolTable>) argu;
        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        System.out.println(overall_code);
        return null;
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "{"
     * f3 -> "public"
     * f4 -> "static"
     * f5 -> "void"
     * f6 -> "main"
     * f7 -> "("
     * f8 -> "String"
     * f9 -> "["
     * f10 -> "]"
     * f11 -> Identifier()
     * f12 -> ")"
     * f13 -> "{"
     * f14 -> PrintStatement()
     * f15 -> "}"
     * f16 -> "}"
     */
    public R visit(MainClass n, A argu) {
        String mainClass = (String) n.f1.accept(this, argu);
        int i;
        String className = "";
        for(i = 4; i < mainClass.length(); i++) {
            className += mainClass.charAt(i);
        }
        overall_code += "class " + className + "\n{\n";
        overall_code += " public static void main ( String [] ";
        String id = (String) n.f11.accept(this, argu);
        overall_code += id + ")\n{\n";
        code_within_method = "";
        declaration_code = "";
        n.f14.accept(this, argu);
        overall_code += declaration_code + code_within_method + "\n}\n}\n\n";
        return null;
    }

    /**
     * f0 -> ClassDeclaration()
     *         | ClassExtendsDeclaration()
     */
    public R visit(TypeDeclaration n, A argu) {
        n.f0.accept(this, argu);
        return null;
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "{"
     * f3 -> ( VarDeclaration() )*
     * f4 -> ( MethodDeclaration() )*
     * f5 -> "}"
     */
    public R visit(ClassDeclaration n, A argu) {

        currentClass = (String) n.f1.accept(this, argu);
        overall_code += "class " + currentClass + "\n{\n";
        declaration_code = "";
        n.f3.accept(this, argu);
        overall_code += declaration_code;
        n.f4.accept(this, argu);
        overall_code += "\n}\n\n";
        return null;
    }

    /**
     * f0 -> "class"
     * f1 -> Identifier()
     * f2 -> "extends"
     * f3 -> Identifier()
     * f4 -> "{"
     * f5 -> ( VarDeclaration() )*
     * f6 -> ( MethodDeclaration() )*
     * f7 -> "}"
     */
    public R visit(ClassExtendsDeclaration n, A argu) {

        currentClass = (String) n.f1.accept(this, argu);
        String superClass = (String) n.f3.accept(this, argu);
        overall_code += "class " + currentClass + " extends " + superClass + "\n{\n";
        declaration_code = "";
        n.f5.accept(this, argu);
        overall_code += declaration_code;
        n.f6.accept(this, argu);
        overall_code += "\n}\n\n";
        return null;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     * f2 -> ";"
     */
    public R visit(VarDeclaration n, A argu) {
        String type = (String) n.f0.accept(this, argu);
        String id = (String) n.f1.accept(this, argu);
        declaration_code += type + " " + id + ";\n";
        return null;
    }

    /**
     * f0 -> "public"
     * f1 -> Type()
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( FormalParameterList() )?
     * f5 -> ")"
     * f6 -> "{"
     * f7 -> ( VarDeclaration() )*
     * f8 -> ( Statement() )*
     * f9 -> "return"
     * f10 -> Expression()
     * f11 -> ";"
     * f12 -> "}"
     */
    public R visit(MethodDeclaration n, A argu) {
        String type = (String) n.f1.accept(this, argu);
        String method = (String) n.f2.accept(this, argu);
        overall_code += "public " + type + " " + method;
        currentSymbolTable = ((Signature) global.get(currentClass).getSignature(method)).symbolTable;
        arguments = "";
        code_within_method = "";
        declaration_code = "";
        n.f4.accept(this, argu);
        overall_code += "(" + arguments + ")\n{\n";
        n.f7.accept(this, argu);
        n.f8.accept(this, argu);
        NameAndType expression = (NameAndType) n.f10.accept(this, argu);
        overall_code += declaration_code + code_within_method + "\nreturn " + expression.variable + ";\n}\n";
        return null;
    }

    /**
     * f0 -> FormalParameter()
     * f1 -> ( FormalParameterRest() )*
     */
    public R visit(FormalParameterList n, A argu) {
        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        return null;
    }

    /**
     * f0 -> Type()
     * f1 -> Identifier()
     */
    public R visit(FormalParameter n, A argu) {
        String type = (String) n.f0.accept(this, argu);
        String id = (String)n.f1.accept(this, argu);
        arguments += type + " " + id;
        return null;
    }

    /**
     * f0 -> ","
     * f1 -> FormalParameter()
     */
    public R visit(FormalParameterRest n, A argu) {
        arguments += ", ";
        n.f1.accept(this, argu);
        return null;
    }

    /**
     * f0 -> ArrayType()
     *         | BooleanType()
     *         | IntegerType()
     *         | Identifier()
     */
    public R visit(Type n, A argu) {
        return n.f0.accept(this, argu);
    }

    /**
     * f0 -> "int"
     * f1 -> "["
     * f2 -> "]"
     */
    public R visit(ArrayType n, A argu) {
        return (R) "int[]";
    }

    /**
     * f0 -> "boolean"
     */
    public R visit(BooleanType n, A argu) {
        return (R) "boolean";
    }

    /**
     * f0 -> "int"
     */
    public R visit(IntegerType n, A argu) {
        return (R) "int";
    }

    /**
     * f0 -> Block()
     *         | AssignmentStatement()
     *         | ArrayAssignmentStatement()
     *         | FieldAssignmentStatement()
     *         | IfStatement()
     *         | WhileStatement()
     *         | ForStatement()
     *         | PrintStatement()
     */
    public R visit(Statement n, A argu) {
        return n.f0.accept(this, argu);
    }

    /**
     * f0 -> "{"
     * f1 -> ( Statement() )*
     * f2 -> "}"
     */
    public R visit(Block n, A argu) {
        code_within_method += "{\n";
        n.f1.accept(this, argu);
        code_within_method += "\n}\n";
        return null;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "="
     * f2 -> Expression()
     * f3 -> ";"
     */
    public R visit(AssignmentStatement n, A argu) {
        String id = (String) n.f0.accept(this, argu);
        NameAndType n1 = (NameAndType) n.f2.accept(this, argu);
        code_within_method += id + " = " + n1.variable + ";\n";
        return null;
    }

    /**
     * f0 -> Identifier()
     * f1 -> "["
     * f2 -> Expression()
     * f3 -> "]"
     * f4 -> "="
     * f5 -> Expression()
     * f6 -> ";"
     */
    public R visit(ArrayAssignmentStatement n, A argu) {
        String id = (String) n.f0.accept(this, argu);
        NameAndType n1 = (NameAndType) n.f2.accept(this, argu);
        NameAndType n2 = (NameAndType) n.f5.accept(this, argu);
        code_within_method += id + "[" + n1.variable + "] = " + n2.variable + ";\n";
        return null;
    }

    /**
     * f0 -> Expression()
     * f1 -> "."
     * f2 -> Identifier()
     * f3 -> "="
     * f4 -> Expression()
     * f5 -> ";"
     */
    public R visit(FieldAssignmentStatement n, A argu) {
        NameAndType n1 = (NameAndType) n.f0.accept(this, argu);
        String id = (String) n.f2.accept(this, argu);
        NameAndType n2 = (NameAndType) n.f4.accept(this, argu);
        code_within_method += n1.variable + "." + id + " = " + n2.variable + ";\n";
        return null;
    }

    /**
     * f0 -> "if"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Statement()
     * f5 -> "else"
     * f6 -> Statement()
     */
    public R visit(IfStatement n, A argu) {

        NameAndType n1 = (NameAndType) n.f2.accept(this, argu);
        code_within_method += "if(" + n1.variable + ")\n{\n";
        n.f4.accept(this, argu);
        code_within_method += "}\n";
        code_within_method += "else\n{\n";
        n.f6.accept(this, argu);
        code_within_method += "}\n";
        return null;
    }

    /**
     * f0 -> "while"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> Statement()
     */
    public R visit(WhileStatement n, A argu) {
        NameAndType n1 = (NameAndType) n.f2.accept(this, argu);
        code_within_method += "while(" + n1.variable + ")\n{\n";
        n.f4.accept(this, argu);
        NameAndType n2 = (NameAndType) n.f2.accept(this, argu);
        code_within_method += n1.variable + " = " + n2.variable + ";\n";
        code_within_method += "\n}\n";
        return null;
    }

    /**
     * f0 -> "for"
     * f1 -> "("
     * f2 -> Identifier()
     * f3 -> "="
     * f4 -> Expression()
     * f5 -> ";"
     * f6 -> Expression()
     * f7 -> ";"
     * f8 -> Identifier()
     * f9 -> "="
     * f10 -> Expression()
     * f11 -> ")"
     * f12 -> Statement()
     */
    public R visit(ForStatement n, A argu) {
        String id1 = (String) n.f2.accept(this, argu);
        NameAndType n1 = (NameAndType) n.f4.accept(this, argu);
        code_within_method += id1 + " = " + n1.variable + ";\n";
        NameAndType n2 = (NameAndType) n.f6.accept(this, argu);
        String id2 = (String) n.f8.accept(this, argu);
        NameAndType n3 = (NameAndType) n.f10.accept(this, argu);

        code_within_method += "for(" + id1 + "=" + n1.variable + ";" + n2.variable + ";" + id2 + "=" + n3.variable + ")\n{\n";
        n.f12.accept(this, argu);

        NameAndType n5 = (NameAndType) n.f10.accept(this, argu);
        code_within_method += id2 + " = " + n5.variable + ";\n";
        code_within_method += n3.variable + " = " + n5.variable + ";\n";
        NameAndType n4 = (NameAndType) n.f6.accept(this, argu);
        code_within_method += n2.variable + " = " + n4.variable + ";\n";
        code_within_method += "}\n";
        return null;
    }

    /**
     * f0 -> "System.out.println"
     * f1 -> "("
     * f2 -> Expression()
     * f3 -> ")"
     * f4 -> ";"
     */
    public R visit(PrintStatement n, A argu) {
        NameAndType expression = (NameAndType) n.f2.accept(this, argu);
        code_within_method += "System.out.println(" + expression.variable + ");\n";
        return null;
    }

    /**
     * f0 -> AndExpression()
     *         | CompareExpression()
     *         | PlusExpression()
     *         | MinusExpression()
     *         | TimesExpression()
     *         | ArrayLookup()
     *         | ArrayLength()
     *         | MessageSend()
     *         | PrimaryExpression()
     */
    public R visit(Expression n, A argu) {
        return n.f0.accept(this, argu);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "&"
     * f2 -> PrimaryExpression()
     */
    public R visit(AndExpression n, A argu) {
        NameAndType  t1 = (NameAndType ) n.f0.accept(this, argu);
        NameAndType  t2 = (NameAndType ) n.f2.accept(this, argu);
        return makeVarAndAssign("boolean", t1.variable + "&" + t2.variable);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "<"
     * f2 -> PrimaryExpression()
     */
    public R visit(CompareExpression n, A argu) {
        NameAndType  t1 = (NameAndType ) n.f0.accept(this, argu);
        NameAndType  t2 = (NameAndType ) n.f2.accept(this, argu);
        return makeVarAndAssign("boolean", t1.variable + "<" + t2.variable);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "+"
     * f2 -> PrimaryExpression()
     */
    public R visit(PlusExpression n, A argu) {
        NameAndType  t1 = (NameAndType ) n.f0.accept(this, argu);
        NameAndType  t2 = (NameAndType ) n.f2.accept(this, argu);
        return makeVarAndAssign("int", t1.variable + "+" + t2.variable);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "-"
     * f2 -> PrimaryExpression()
     */
    public R visit(MinusExpression n, A argu) {
        NameAndType  t1 = (NameAndType ) n.f0.accept(this, argu);
        NameAndType  t2 = (NameAndType ) n.f2.accept(this, argu);
        return makeVarAndAssign("int", t1.variable + "-" + t2.variable);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "*"
     * f2 -> PrimaryExpression()
     */
    public R visit(TimesExpression n, A argu) {
        NameAndType  t1 = (NameAndType ) n.f0.accept(this, argu);
        NameAndType  t2 = (NameAndType ) n.f2.accept(this, argu);
        return makeVarAndAssign("int", t1.variable + "*" + t2.variable);
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "["
     * f2 -> PrimaryExpression()
     * f3 -> "]"
     */
    public R visit(ArrayLookup n, A argu) {
        NameAndType  t1 = (NameAndType ) n.f0.accept(this, argu);
        NameAndType  t2 = (NameAndType ) n.f2.accept(this, argu);
        return makeVarAndAssign("int", t1.variable + "[" + t2.variable + "]");
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "."
     * f2 -> "length"
     */
    public R visit(ArrayLength n, A argu) {
        NameAndType  t1 = (NameAndType ) n.f0.accept(this, argu);
        return makeVarAndAssign("int", t1.variable + ".length");
    }

    /**
     * f0 -> PrimaryExpression()
     * f1 -> "."
     * f2 -> Identifier()
     * f3 -> "("
     * f4 -> ( ExpressionList() )?
     * f5 -> ")"
     */
    public R visit(MessageSend n, A argu) {
        NameAndType object = (NameAndType) n.f0.accept(this, argu);
        String identifier = (String) n.f2.accept(this, argu);
        String type = object.type ;
        String expressionType = (String) ((Signature) global.get(type).getSignature(identifier)).returnType;
        String arguments = "(";
        if(n.f4.present()) {
            arguments += n.f4.accept(this, argu);
        }
        arguments += ")";
        return makeVarAndAssign(expressionType, object.variable + "." + identifier + arguments);
    }

    /**
     * f0 -> Expression()
     * f1 -> ( ExpressionRest() )*
     */
    public R visit(ExpressionList n, A argu) {
        String arguments = ((NameAndType) (n.f0.accept(this, argu))).variable;
        int i = 0;
        while(i < n.f1.size()) {
            arguments += ", " + n.f1.elementAt(i).accept(this, argu);
            i += 1;
        }
        return (R) arguments;
    }

    /**
     * f0 -> ","
     * f1 -> Expression()
     */
    public R visit(ExpressionRest n, A argu) {
        n.f0.accept(this, argu);
        NameAndType n1 = (NameAndType) n.f1.accept(this, argu);
        return (R) n1.variable;
    }

    /**
     * f0 -> IntegerLiteral()
     *         | TrueLiteral()
     *         | FalseLiteral()
     *         | Identifier()
     *         | ThisExpression()
     *         | ArrayAllocationExpression()
     *         | AllocationExpression()
     *         | NotExpression()
     *         | BracketExpression()
     */
    public R visit(PrimaryExpression n, A argu) {
        if(n.f0.which == 3) {
            String identifier = (String) n.f0.accept(this, argu);
            String type = currentSymbolTable.getVariableType(identifier);
            NameAndType  t = new NameAndType();
            t.variable = identifier;
            t.type = type;
            return (R) t;
        }
        return n.f0.accept(this, argu);
    }

    /**
     * f0 -> <INTEGER_LITERAL>
     */
    public R visit(IntegerLiteral n, A argu) {
        return makeVarAndAssign("int", n.f0.toString());
    }

    /**
     * f0 -> "true"
     */
    public R visit(TrueLiteral n, A argu) {
        return makeVarAndAssign("boolean", "true");
    }

    /**
     * f0 -> "false"
     */
    public R visit(FalseLiteral n, A argu) {
        return makeVarAndAssign("boolean", "false");
    }

    /**
     * f0 -> <IDENTIFIER>
     */
    public R visit(Identifier n, A argu) {
        String tacoId = "Taco" + n.f0.toString();
        return (R) tacoId;
    }

    /**
     * f0 -> "this"
     */
    public R visit(ThisExpression n, A argu) {
        return makeVarAndAssign(currentClass, "this");
    }

    /**
     * f0 -> "new"
     * f1 -> "int"
     * f2 -> "["
     * f3 -> Expression()
     * f4 -> "]"
     */
    public R visit(ArrayAllocationExpression n, A argu) {
        NameAndType  expression = (NameAndType ) n.f3.accept(this, argu);
        return makeVarAndAssign("int[]", "new int[" + expression.variable + "]");
    }

    /**
     * f0 -> "new"
     * f1 -> Identifier()
     * f2 -> "("
     * f3 -> ")"
     */
    public R visit(AllocationExpression n, A argu) {
        String  className = (String) n.f1.accept(this, argu);
        return makeVarAndAssign(className, " new " + className + "()");
    }

    /**
     * f0 -> "!"
     * f1 -> Expression()
     */
    public R visit(NotExpression n, A argu) {
        NameAndType  expression = (NameAndType ) n.f1.accept(this, argu);
        return makeVarAndAssign("boolean", "!" + expression.variable);

    }

    /**
     * f0 -> "("
     * f1 -> Expression()
     * f2 -> ")"
     */
    public R visit(BracketExpression n, A argu) {
        return (R) n.f1.accept(this, argu);
    }

}