class TC4
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
int i;
int k;
boolean c;
k = 2;
a = 10;
b = 1;
c = b < a;
while(c)
{
b = b + 2;
a = a - b;
}
return a;
}
}
