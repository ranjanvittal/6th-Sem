class mycase
{
 public static void main ( String [] Tacoa)
{
Gen temp0;
boolean temp1;
boolean t;
boolean f;
t = true;
f = false;
temp0 =  new Gen();
temp1 = temp0.foo(t, f);
System.out.println(temp1);

}
}
class Gen {
public boolean foo(boolean t2, boolean t3) {
    boolean t1;
    t1 = true;
    //while(t1) {
        if(t2) {
            if(t3)
                t1 = false;
            else
                t1 = true;
        }
        else {
            if(t3)
                t1 = true;
            else
                t1 = false;
        }
        t1 = t1;
    //}
return t1;
}
}
