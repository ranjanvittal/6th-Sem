class TestP31
{
public static void main( String[] a)
{
int b;

int c;

int d;

int e;

Maths s;

b = 10;
c = 15;
s = new Maths();
d = s.add(10);
e = s.loop(10, 15);
}
}
class Maths
{
public int add(int c)
{
int ad;
boolean exp;
boolean exp2;
int id;
int id1;
int id2;
int i;
int j;
i = 0;
j = 1;
id = 20;
id1 = 15;
id2 = 50;
exp = c < 20;
if(exp)
{
ad = c + 15;
exp2 = ad < 50;
if(exp2)
System.out.println(1);
else
System.out.println(0);
}
else
{
}
return 1;
}
public int loop(int f1, int f2)
{
int i;
boolean exp1;
boolean exp3;
int id3;
int id4;
int id5;
id4 = 1;
id3 = 20;
id5 = 0;
i = f2 - 1;
exp1 = 0 < i;
while(exp1)
{
exp3 = 0 < i;
if(exp3)
{
i = i - 1;
System.out.println(i);
exp3 = 0 < i;
}
else
{
}
exp1 = 0 < i;
}
return 1;
}
}
