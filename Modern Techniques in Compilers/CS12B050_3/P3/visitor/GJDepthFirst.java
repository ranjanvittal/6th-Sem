//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.    Your visitors may extend this class.
 */
public class GJDepthFirst<R,A> implements GJVisitor<R,A> {
     //
     // Auto class visitors--probably don't need to be overridden.
     //
    void print(Object a) {
        if(a instanceof String)
            System.out.println((String) a);
        else if( a instanceof Integer)
            System.out.println(((Integer) a).toString());
        else
            System.out.println(((Boolean) a).toString());
    }

    void printn(Object a) {
        if(a instanceof String)
            System.out.print((String) a);
        else if( a instanceof Integer)
            System.out.print(((Integer) a).toString());
        else
            System.out.print(((Boolean) a).toString());
    }

    String stringValue(Object a) {
        if( a instanceof Integer)
            return ((Integer) a).toString();
        if( a instanceof Boolean)
            return ((Boolean) a).toString();
        return (String) a;
    }

    Set<String> classMap;

    boolean objEquals(Object o1, Object o2) {
        if(o1 instanceof Integer) {
            if(o2 instanceof Integer)
                return ((Integer) o1).intValue() == ((Integer) o2).intValue();
        }
        if(o1 instanceof Boolean) {
            if(o2 instanceof Boolean)
                return ((Boolean) o1).booleanValue() == ((Boolean) o2).booleanValue();
        }
        return false;
    }

    boolean checkEitherZero(Object o1, Object o2) {
        if(o1 instanceof Integer) {
            if((Integer) o1 == 0)
                return true;
        }
        if(o2 instanceof Integer) {
            if((Integer) o2 == 0)
                return true;
        }
        return false;
    }

    boolean checkEitherFalse(Object o1, Object o2) {
        if(o1 instanceof Boolean) {
            if((Boolean) o1 == false)
                return true;
        }
        if(o2 instanceof Boolean) {
            if((Boolean) o2 == false)
                return true;
        }
        return false;
    }

    class Value extends Object{

        public Hashtable<String, Object> initMap;
        public Set<String> uninitMap;
        public boolean printable;
        Set<String> safe;

        public Value() {
            initMap = new Hashtable<String, Object>();
            uninitMap = new HashSet<String>();
            printable = false;
            safe = new HashSet<String>();
        }

        public boolean isSafe(String a) {
            return safe.contains(a);
        }
        public boolean isBottom(String a) {
            return !isSafe(a) || (!initMap.containsKey(a) && !uninitMap.contains(a));
        }

        public boolean isTop(String a) {
            return uninitMap.contains(a);
        }

        public Object getValue(String a) {
            return initMap.get(a);
        }

        public void setTop(String a) {
            uninitMap.add(a);
        }

        public void removeTop(String a) {
            uninitMap.remove(a);
        }

        public void setSafe(String a) {
            safe.add(a);
        }

        public void setValue(String a, Object val) {
            uninitMap.remove(a);
            if(isSafe(a)) {
                initMap.put(a, val);
            }
        }

        public void removeValue(String a) {
            initMap.remove(a);
        }

        public void setBottom(String a) {
            initMap.remove(a);
            uninitMap.remove(a);
        }

        public void addAll(Set<String> a) {
            uninitMap.addAll(a);
        }

        public void pretty() {
            print("Uninitialized : ");
            for(String key : uninitMap)
                print(key);
            print("");
            print("Initialized : ");
            for(String key : initMap.keySet())
                print( key + ":" + stringValue(getValue(key)));
            print("");
            print("Safe :");
            for(String key : safe)
                print(key);
            print("");
        }
    }


    void deepcopy(Value v1, Value v2) {
        v1.initMap = new Hashtable<String, Object>();
        v1.uninitMap = new HashSet<String>();
        v1.printable = v2.printable;
        v1.safe = new HashSet<String>();
        v1.addAll(v2.uninitMap);
        v1.safe.addAll(v2.safe);
        for(String key : v2.initMap.keySet())
            v1.setValue(key, v2.getValue(key));
    }

    boolean equals(Value v1, Value v2) {
        for(String key : v1.initMap.keySet()) {
            Object val1 = v1.getValue(key);
            Object val2 = v2.getValue(key);
            if(!objEquals(val1, val2))
                return false;
        }
        if(v1.initMap.size() != v2.initMap.size())
            return false;
        for(String key : v1.uninitMap)
            if(!v2.isTop(key))
                return false;
        if(v1.uninitMap.size() != v2.uninitMap.size())
            return false;
        return true;
    }

    void meet(Value v1, Value v2, Value v3) {
        Value v4, v5;
        v4 = new Value();
        v5 = new Value();
        deepcopy(v4, v1);
        deepcopy(v5, v2);
        v3.initMap = new Hashtable<String, Object>();
        v3.uninitMap = new HashSet<String>();
        for(String key : v4.initMap.keySet()) {
            Object val1 = v4.getValue(key);
            Object val2 = v5.getValue(key);
            if(objEquals(val1, val2))
                v3.setValue(key, val1);
            else
                v3.removeValue(key);
            v3.uninitMap.remove(key);
        }
        for(String key : v5.initMap.keySet())
            v3.uninitMap.remove(key);

        for(String key : v4.uninitMap) {
            if(v5.isTop(key))
                v3.setTop(key);
            else
                v3.removeTop(key);
        }
    }

    public R visit(NodeList n, A argu) {
        R _ret = null;
        int _count = 0;
        for ( Enumeration<Node> e  =  n.elements(); e.hasMoreElements(); ) {
             e.nextElement().accept(this,argu);
             _count++;
        }
        return _ret;
     }

    public R visit(NodeListOptional n, A argu) {
        if ( n.present() ) {
             R _ret = null;
             int _count = 0;
             for ( Enumeration<Node> e  =  n.elements(); e.hasMoreElements(); ) {
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
        R _ret = null;
        int _count = 0;
        for ( Enumeration<Node> e  =  n.elements(); e.hasMoreElements(); ) {
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
        R _ret = null;
        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        n.f2.accept(this, argu);
        return _ret;
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
        * f14 -> ( VarDeclaration() )*
        * f15 -> ( Statement() )*
        * f16 -> "}"
        * f17 -> "}"
        */
    public R visit(MainClass n, A argu) {
        R _ret = null;
        String id = (String) n.f1.accept(this, argu);
        printn("class " + id + "\n{\n");
        printn("public static void main( String[] ");
        id = (String) n.f11.accept(this, argu);
        printn(id + ")\n{\n");
        Value methodValue = new Value();
        NodeListOptional n1 = n.f14;
        for(int i = 0; i < n1.size(); i++) {
            VarDeclaration v = (VarDeclaration) n1.elementAt(i);
            String type = (String) v.f0.accept(this, argu);
            String var = v.f1.f0.toString();
            print(type + " " + var + ";\n");
            methodValue.setTop(var);
            methodValue.setSafe(var);
        }
        methodValue.printable = true;
        n1 = n.f15;
        for(int i = 0; i < n1.size(); i++)
            n1.elementAt(i).accept(this, (A) methodValue);
        print("}");
        print("}");
        return _ret;
     }

     /**
        * f0 -> ClassDeclaration()
        *         | ClassExtendsDeclaration()
        */
    public R visit(TypeDeclaration n, A argu) {
        R _ret = null;
        n.f0.accept(this, argu);
        return _ret;
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
        R _ret = null;
        n.f0.accept(this, argu);
        String className = (String) n.f1.f0.toString();
        print("class " + className + "\n{");
        Set<String> classMap = new HashSet<String>();
        NodeListOptional n1 = n.f3;
        for(int i = 0; i < n1.size(); i++) {
            VarDeclaration v = (VarDeclaration) n1.elementAt(i);
            String type = (String) v.f0.accept(this, argu);
            String id = v.f1.f0.toString();
            print(type + " " + id + ";");
            classMap.add(id);
        }
        n1 = n.f4;

        for(int i = 0; i < n1.size(); i++) {
            n1.elementAt(i).accept(this, (A) classMap);
        }
        print("}");
        return _ret;
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
        R _ret = null;
        n.f0.accept(this, argu);
        String className = (String) n.f1.accept(this, argu);
        printn("class " + className);
        String extending = (String) n.f3.accept(this, argu);
        print(" extends " + extending + "\n{");
        Set<String> classMap = new HashSet<String>();
        NodeListOptional n1 = n.f5;
        for(int i = 0; i < n1.size(); i++) {
            VarDeclaration v = (VarDeclaration) n1.elementAt(i);
            String type = (String) v.f0.accept(this, argu);
            String id = v.f1.f0.toString();
            print(type + " " + id + ";");
            classMap.add(id);
        }
        n1 = n.f6;

        for(int i = 0; i < n1.size(); i++) {
            n1.elementAt(i).accept(this, (A) classMap);
        }
        print("}");
        return _ret;
     }

     /**
        * f0 -> Type()
        * f1 -> Identifier()
        * f2 -> ";"
        */
    public R visit(VarDeclaration n, A argu) {
        R _ret = null;
        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        n.f2.accept(this, argu);
        return _ret;
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
        * f10 -> Identifier()
        * f11 -> ";"
        * f12 -> "}"
        */
    public R visit(MethodDeclaration n, A argu) {
        R _ret = null;
        Value methodValue = new Value();
        String toPrint = "public ";
        toPrint += (String) n.f1.accept(this, argu) + " ";
        toPrint += (String) n.f2.accept(this, argu) + "(";
        printn(toPrint);
        n.f4.accept(this, (A) methodValue);
        printn(")\n{\n");

        // n.f5.accept(this, argu);
        // n.f6.accept(this, argu);
        // n.f7.accept(this, argu);
        NodeListOptional n1 = (NodeListOptional) n.f7;
        int i;
        if(n1.present()) {
            for(i = 0; i < n1.size(); i++) {
                VarDeclaration v = (VarDeclaration) n1.elementAt(i);
                String type = (String) v.f0.accept(this, argu);
                String var = (String) v.f1.f0.toString();
                methodValue.setTop(var);
                methodValue.setSafe(var);
                print(type + " " + var + ";");
            }
        }
        methodValue.printable = true;
        n1 = (NodeListOptional) n.f8;
        if(n1.present())
            for(i = 0; i < n1.size(); i++)
                n1.elementAt(i).accept(this, (A) methodValue);
        printn("return ");
        String ret = (String) n.f10.accept(this, argu);
        if(!methodValue.isBottom(ret))
            ret = stringValue(methodValue.getValue(ret));
        printn(ret);
        printn(";\n}\n");
        //n.f12.accept(this, argu);
        return _ret;
     }

     /**
        * f0 -> FormalParameter()
        * f1 -> ( FormalParameterRest() )*
        */
    public R visit(FormalParameterList n, A argu) {
        R _ret = null;
        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        return _ret;
     }

     /**
        * f0 -> Type()
        * f1 -> Identifier()
        */
    public R visit(FormalParameter n, A argu) {
        R _ret = null;
        Value methodValue = (Value) argu;
        String type = (String) n.f0.accept(this, argu);
        String id = (String) n.f1.accept(this, argu);
        printn(type + " " + id);
        methodValue.setSafe(id);
        return _ret;
     }

     /**
        * f0 -> ","
        * f1 -> FormalParameter()
        */
    public R visit(FormalParameterRest n, A argu) {
        R _ret = null;
        n.f0.accept(this, argu);
        printn(", ");
        n.f1.accept(this, argu);
        return _ret;
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
        R _ret = null;
        n.f0.accept(this, argu);
        return _ret;
     }

     /**
        * f0 -> "{"
        * f1 -> ( Statement() )*
        * f2 -> "}"
        */
    public R visit(Block n, A argu) {
        R _ret = null;
        NodeListOptional n1  =  (NodeListOptional) n.f1;
        boolean printable = ((Value) argu).printable;
        if(printable)
            print("{");
        for(int i = 0; i < n1.size(); i++)
            n1.elementAt(i).accept(this, argu);
        if(printable)
            print("}");
        return _ret;
     }

     /**
        * f0 -> Identifier()
        * f1 -> " = "
        * f2 -> Expression()
        * f3 -> ";"
        */
    public R visit(AssignmentStatement n, A argu) {
        R _ret = null;
        Value methodValue = (Value) argu;
        String s = n.f0.f0.toString();
        Object value = (Object) n.f2.accept(this, argu);

        if(value instanceof Integer || value instanceof Boolean) {
            if(methodValue.isSafe(s)) {
                methodValue.setValue(s, value);
            }
        }
        else
            methodValue.setBottom(s);
        if(methodValue.printable)
            print(s + " = " + stringValue(value) + ";");
        return _ret;
     }

     /**
        * f0 -> Identifier()
        * f1 -> "["
        * f2 -> Identifier()
        * f3 -> "]"
        * f4 -> " = "
        * f5 -> Identifier()
        * f6 -> ";"
        */
    public R visit(ArrayAssignmentStatement n, A argu) {
        R _ret = null;
        Value methodValue = (Value) argu;
        String array = (String) n.f0.f0.toString();

        String id = (String) n.f2.f0.toString();
        Object index = id;
        if(!methodValue.isBottom(id))
            index = methodValue.getValue(id);
        String id2 = n.f5.f0.toString();
        Object rhs = id2;
        if(!methodValue.isBottom(id))
            rhs = methodValue.getValue(id2);
        if(methodValue.printable) {
            String toPrint = array + "[" + stringValue(index) + "]";
            toPrint += " = " + stringValue(rhs) + ";\n";
            print(toPrint);
        }
        return _ret;
     }

     /**
        * f0 -> Identifier()
        * f1 -> "."
        * f2 -> Identifier()
        * f3 -> " = "
        * f4 -> Identifier()
        * f5 -> ";"
        */
    public R visit(FieldAssignmentStatement n, A argu) {
        R _ret = null;
        Value methodValue = (Value) argu;
        String object = n.f0.f0.toString();
        String field = (String) n.f2.f0.toString();
        String id = n.f4.f0.toString();
        Object rhs = id;
        if(!methodValue.isBottom(id))
            rhs = methodValue.getValue(id);
        if(methodValue.printable)
            print(object + "." + field + " = " + stringValue(rhs) + ";\n");
        return _ret;
     }

     /**
        * f0 -> "if"
        * f1 -> "("
        * f2 -> Identifier()
        * f3 -> ")"
        * f4 -> Statement()
        * f5 -> "else"
        * f6 -> Statement()
        */
    public R visit(IfStatement n, A argu) {
        R _ret = null;
        Value methodValue = (Value) argu;

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        String id = (String) n.f2.accept(this, argu);
        Object condition = id;

        if(!methodValue.isBottom(id)) {
            condition = methodValue.getValue(id);
            if(((Boolean) condition) == true)
                n.f4.accept(this, argu);
            else
                n.f6.accept(this, argu);
        }
        else {
            if(methodValue.printable)
                print("if(" + id + ")");
            Value ifThen = new Value();
            Value ifElse = new Value();
            deepcopy(ifThen, methodValue);

            n.f4.accept(this, (A) ifThen);
            if(methodValue.printable)
                print("else");
            deepcopy(ifElse, methodValue);
            n.f6.accept(this, (A) ifElse);

            meet(ifThen, ifElse, methodValue);
            // ifThen.pretty();
            // ifElse.pretty();
            // methodValue.pretty();
        }
        return _ret;
     }

     /**
        * f0 -> "while"
        * f1 -> "("
        * f2 -> Identifier()
        * f3 -> ")"
        * f4 -> Statement()
        */
    public R visit(WhileStatement n, A argu) {
        R _ret = null;
        Value methodValue = (Value) argu;
        String id = (String) n.f2.accept(this, argu);
        if(!methodValue.isBottom(id)) {
            Boolean condition = (Boolean) methodValue.getValue(id);
            Value checkChange = new Value();
            boolean oldPrintable = methodValue.printable;
            methodValue.printable = false;
            if(condition) {
                do {
                    deepcopy(checkChange, methodValue);
                    n.f4.accept(this, (A) methodValue);
                    meet(methodValue, checkChange, methodValue);
                }
                while(!equals(checkChange, methodValue));
                if(oldPrintable) {
                    id = (String) n.f2.accept(this, (A) methodValue);
                    if(!methodValue.isBottom(id))
                        id = "true";
                    print("while(" + id + ")");
                    methodValue.printable = true;
                    n.f4.accept(this, (A) methodValue);
                }
            }
            methodValue.printable = oldPrintable;
        }
        else {
            Value checkChange = new Value();
            boolean oldPrintable = methodValue.printable;
            methodValue.printable = false;
            do {
                deepcopy(checkChange, methodValue);
                n.f4.accept(this, (A) methodValue);
                meet(methodValue, checkChange, methodValue);
            }
            while(!equals(checkChange, methodValue));
            methodValue.printable = oldPrintable;
            if(oldPrintable) {
                Value used = new Value();
                print("while(" + id + ")");
                deepcopy(used, methodValue);
                n.f4.accept(this, (A) used);
            }
        }
        return _ret;
     }

     /**
        * f0 -> "for"
        * f1 -> "("
        * f2 -> Identifier()
        * f3 -> " = "
        * f4 -> Expression()
        * f5 -> ";"
        * f6 -> Expression()
        * f7 -> ";"
        * f8 -> Identifier()
        * f9 -> " = "
        * f10 -> Expression()
        * f11 -> ")"
        * f12 -> Statement()
        */
    public R visit(ForStatement n, A argu) {
        R _ret = null;
        String id = (String) n.f2.accept(this, argu);
        Value methodValue = (Value) argu;
        Object value = n.f4.accept(this, argu);
        if(value instanceof Integer || value instanceof Boolean) {
            methodValue.setValue(id, value);
        }

        Object val2 = n.f6.accept(this, argu);
        if(val2 instanceof Boolean && ((Boolean) val2) == false) {
            if(methodValue.printable)
                print(id + " = " + stringValue(value) + ";");
        }
        else {
            boolean oldPrintable = methodValue.printable;
            Value checkChange = new Value();
            methodValue.printable = false;
            do {
                deepcopy(checkChange, methodValue);
                n.f12.accept(this, (A) methodValue);
                String lhs = (String) n.f8.accept(this, (A) methodValue);
                Object rhs = n.f10.accept(this, (A) methodValue);
                if(rhs instanceof Integer || rhs instanceof Boolean)
                    methodValue.setValue(lhs, rhs);
                else
                    methodValue.setBottom(lhs);
                meet(methodValue, checkChange, methodValue);
            } while(!equals(methodValue, checkChange));
            methodValue.printable = oldPrintable;
            if(oldPrintable) {
                Value used = new Value();
                if(val2 instanceof Boolean)
                    used = methodValue;
                else
                    deepcopy(used, methodValue);
                printn("for(" + id + " = " + stringValue(value) + ";");
                val2 = n.f6.accept(this, (A) used);
                printn(stringValue(val2) + ";");
                String lhs = (String) n.f8.accept(this, (A) used);
                Object rhs = n.f10.accept(this, (A) used);
                printn(lhs + " = " + stringValue(rhs) + ")\n");
                n.f12.accept(this, (A) used);
            }
        }
        return _ret;
    }

     /**
        * f0 -> "System.out.println"
        * f1 -> "("
        * f2 -> Identifier()
        * f3 -> ")"
        * f4 -> ";"
        */
    public R visit(PrintStatement n, A argu) {
        R _ret = null;
        Value methodValue = (Value) argu;
        String id = (String) n.f2.accept(this, argu);
        Object printVal = id;
        if(!methodValue.isBottom(id)) {
            printVal = methodValue.getValue(id);
        }
        if(methodValue.printable)
            print("System.out.println(" + stringValue(printVal) + ");");
        return _ret;
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
        * f0 -> Identifier()
        * f1 -> "&"
        * f2 -> Identifier()
        */
    public R visit(AndExpression n, A argu) {
        R _ret = null;
        Value methodValue = (Value) argu;
        String first = (String) n.f0.accept(this, argu);
        String second = (String) n.f2.accept(this, argu);
        Object o1 = first;
        Object o2 = second;
        boolean set1 = false, set2 = false;
        if(!methodValue.isBottom(first)) {
            o1 = methodValue.getValue(first);
            set1 = true;
        }
        if(!methodValue.isBottom(second)) {
            o2 = methodValue.getValue(second);
            set2 = true;
        }
        if(set1 && set2) {
            return (R) new Boolean(((Boolean) o1) && ((Boolean) o2));
        }
        if(checkEitherFalse(o1, o2))
            return (R) new Boolean(false);
        return (R) (stringValue(o1) + " & " + stringValue(o2));
     }

     /**
        * f0 -> Identifier()
        * f1 -> "<"
        * f2 -> Identifier()
        */
    public R visit(CompareExpression n, A argu) {
        R _ret = null;
        Value methodValue = (Value) argu;
        String first = (String) n.f0.accept(this, argu);
        String second = (String) n.f2.accept(this, argu);
        Object o1 = first;
        Object o2 = second;
        boolean set1 = false, set2 = false;
        if(!methodValue.isBottom(first)) {
            o1 = methodValue.getValue(first);
            set1 = true;
        }
        if(!methodValue.isBottom(second)) {
            o2 = methodValue.getValue(second);
            set2 = true;
        }
        if(set1 && set2) {
            return (R) new Boolean(((Integer) o1) < ((Integer) o2));
        }
        return (R) (stringValue(o1) + " < " + stringValue(o2));
     }

     /**
        * f0 -> Identifier()
        * f1 -> "+"
        * f2 -> Identifier()
        */
    public R visit(PlusExpression n, A argu) {
        R _ret = null;
        Value methodValue = (Value) argu;
        String first = (String) n.f0.accept(this, argu);
        String second = (String) n.f2.accept(this, argu);
        Object o1 = first;
        Object o2 = second;
        boolean set1 = false, set2 = false;
        if(!methodValue.isBottom(first)) {
            o1 = methodValue.getValue(first);
            set1 = true;
        }
        if(!methodValue.isBottom(second)) {
            o2 = methodValue.getValue(second);
            set2 = true;
        }
        if(set1 && set2) {
            return (R) new Integer(((Integer) o1) + ((Integer) o2));
        }
        return (R) (stringValue(o1) + " + " + stringValue(o2));
     }

     /**
        * f0 -> Identifier()
        * f1 -> "-"
        * f2 -> Identifier()
        */
    public R visit(MinusExpression n, A argu) {
        R _ret = null;
        Value methodValue = (Value) argu;
        String first = (String) n.f0.accept(this, argu);
        String second = (String) n.f2.accept(this, argu);
        Object o1 = first;
        Object o2 = second;
        boolean set1 = false, set2 = false;
        if(!methodValue.isBottom(first)) {
            o1 = methodValue.getValue(first);
            set1 = true;
        }
        if(!methodValue.isBottom(second)) {
            o2 = methodValue.getValue(second);
            set2 = true;
        }
        if(set1 && set2) {
            return (R) new Integer(((Integer) o1) - ((Integer) o2));
        }
        return (R) (stringValue(o1) + " - " + stringValue(o2));
     }

     /**
        * f0 -> Identifier()
        * f1 -> "*"
        * f2 -> Identifier()
        */
    public R visit(TimesExpression n, A argu) {
        R _ret = null;
        Value methodValue = (Value) argu;
        String first = (String) n.f0.accept(this, argu);
        String second = (String) n.f2.accept(this, argu);
        Object o1 = first;
        Object o2 = second;
        boolean set1 = false, set2 = false;
        if(!methodValue.isBottom(first)) {
            o1 = methodValue.getValue(first);
            set1 = true;
        }
        if(!methodValue.isBottom(second)) {
            o2 = methodValue.getValue(second);
            set2 = true;
        }
        if(set1 && set2) {
            return (R) new Integer(((Integer) o1) * ((Integer) o2));
        }
        if(checkEitherZero(o1, o2))
            return (R) new Integer(0);
        return (R) (stringValue(o1) + " * " + stringValue(o2));
     }

     /**
        * f0 -> Identifier()
        * f1 -> "["
        * f2 -> Identifier()
        * f3 -> "]"
        */
    public R visit(ArrayLookup n, A argu) {
        Value methodValue = (Value) argu;
        String id1 = (String) n.f0.accept(this, argu);
        String id2 = (String) n.f2.accept(this, argu);
        if(!methodValue.isBottom(id2))
            id2 = ((Integer) methodValue.getValue(id2)).toString();
        String ret = id1 + "[" + id2 + "]";
        return (R) ret;
     }

     /**
        * f0 -> Identifier()
        * f1 -> "."
        * f2 -> "length"
        */
    public R visit(ArrayLength n, A argu) {
        String id = (String) n.f0.accept(this, argu);
        return (R) (id + ".length");
     }

     /**
        * f0 -> PrimaryExpression()
        * f1 -> "."
        * f2 -> Identifier()
        * f3 -> "("
        * f4 -> ( ArgList() )?
        * f5 -> ")"
        */
    public R visit(MessageSend n, A argu) {
        String pe = (String) n.f0.accept(this, argu);
        String id = (String) n.f2.accept(this, argu);
        n.f3.accept(this, argu);
        String args = "";
        if(n.f4.present()) {
            ArgList n1 = (ArgList) n.f4.node;
            args = (String) n1.accept(this, argu);
        }
        String last = pe + "." + id + "(" + args + ")";
        return (R) last;
     }

     /**
        * f0 -> Identifier()
        * f1 -> ( ArgRest() )*
        */
    public R visit(ArgList n, A argu) {
        Value methodValue = (Value) argu;
        String id = (String) n.f0.accept(this, argu);
        if(!methodValue.isBottom(id))
            id = stringValue(methodValue.getValue(id));
        for(int i = 0; i < n.f1.size(); i++)
            id = id + (String) n.f1.elementAt(i).accept(this, argu);
        return (R) id;
     }

     /**
        * f0 -> ","
        * f1 -> Identifier()
        */
    public R visit(ArgRest n, A argu) {
        Value methodValue = (Value) argu;
        String id = (String) n.f1.accept(this, argu);
        if(!methodValue.isBottom(id))
            id = stringValue(methodValue.getValue(id));
        id = ", " + id;
        return (R) id;
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
        */
    public R visit(PrimaryExpression n, A argu) {
        if(n.f0.which == 3) {
            String id = (String) n.f0.accept(this, argu);
            Value methodValue = (Value) argu;
            Object val = id;
            if(!methodValue.isBottom(id))
                val = methodValue.getValue(id);
            return (R) val;
        }
        return n.f0.accept(this, argu);
     }

     /**
        * f0 -> <INTEGER_LITERAL>
        */
    public R visit(IntegerLiteral n, A argu) {
        return (R) Integer.valueOf(n.f0.toString());
     }

     /**
        * f0 -> "true"
        */
    public R visit(TrueLiteral n, A argu) {
        return (R) new Boolean(true);
     }

     /**
        * f0 -> "false"
        */
    public R visit(FalseLiteral n, A argu) {
        return (R) new Boolean(false);
     }

     /**
        * f0 -> <IDENTIFIER>
        */
    public R visit(Identifier n, A argu) {
        return (R) n.f0.toString();
     }

     /**
        * f0 -> "this"
        */
    public R visit(ThisExpression n, A argu) {
        String th;
        th = "this";
        return (R) th;
     }

     /**
        * f0 -> "new"
        * f1 -> "int"
        * f2 -> "["
        * f3 -> Identifier()
        * f4 -> "]"
        */
    public R visit(ArrayAllocationExpression n, A argu) {
        Value methodValue = (Value) argu;

        String id = (String) n.f3.accept(this, argu);
        if(!methodValue.isBottom(id))
           id = ((Integer) methodValue.getValue(id)).toString();
        String ret = "new int[" + id + "]";
        return (R) ret;
     }

     /**
        * f0 -> "new"
        * f1 -> Identifier()
        * f2 -> "("
        * f3 -> ")"
        */
    public R visit(AllocationExpression n, A argu) {
        Value methodValue = (Value) argu;
        String id = (String) n.f1.accept(this, argu);
        String ret = "new " + id + "()";
        return (R) ret;
    }

     /**
        * f0 -> "!"
        * f1 -> Identifier()
        */
    public R visit(NotExpression n, A argu) {
        Value methodValue = (Value) argu;
        String id = (String) n.f1.accept(this, argu);
        if(!methodValue.isBottom(id))
            return (R) new Boolean(!((Boolean) methodValue.getValue(id)));
        return (R) ("!" + id);
     }

}
