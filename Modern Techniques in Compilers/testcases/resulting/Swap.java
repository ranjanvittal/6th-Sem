class Swap
{
public static void main( String[] args)
{
Exchange mtTmp2;

int mtTmp3;

int mtTmp4;

int mtTmp1;

mtTmp2 = new Exchange();
mtTmp3 = 5;
mtTmp4 = 10;
mtTmp1 = mtTmp2.swap(5, 10);
System.out.println(mtTmp1);
}
}
class Exchange
{
int temp;
public int swap(int a, int b)
{
int mtTmp5;
temp = a;
a = b;
b = temp;
mtTmp5 = 0;
return 0;
}
}
