class TC3
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
int c;
int j;
j = 2;
c = 5;
a = 1;
b = 1;
for(i = 1;i < 5;i = i + 2)
a = a + b;
return a;
}
}
