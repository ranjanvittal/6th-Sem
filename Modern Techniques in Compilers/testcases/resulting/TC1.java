class TC1
{
public static void main( String[] args)
{
Call c;

int ret;

c = new Call();
ret = c.called();
System.out.println(ret);
}
}
class Call
{
int a;
int b;
public int called()
{
b = 3;
a = b;
return a;
}
}
