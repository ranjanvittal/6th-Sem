class Addition
{
public static void main( String[] a)
{
NumAdd mtTmp2;

int mtTmp3;

int mtTmp4;

int mtTmp1;

mtTmp2 = new NumAdd();
mtTmp3 = 10;
mtTmp4 = 20;
mtTmp1 = mtTmp2.Start(10, 20);
System.out.println(mtTmp1);
}
}
class NumAdd
{
public int Start(int a, int b)
{
int mtTmp5;
mtTmp5 = a + b;
return mtTmp5;
}
}
