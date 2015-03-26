class ArrayAssign
{
public static void main( String[] args)
{
AAssign mtTmp2;

int mtTmp3;

int mtTmp1;

mtTmp2 = new AAssign();
mtTmp3 = 20;
mtTmp1 = mtTmp2.Start(20);
System.out.println(mtTmp1);
}
}
class AAssign
{
int[] arr;
public int Start(int num)
{
int i;
int mtTmp5;
int[] mtTmp4;
int mtTmp6;
int mtTmp7;
int mtTmp8;
boolean mtTmp9;
int mtTmp10;
mtTmp5 = 9;
mtTmp4 = new int[9];
arr = mtTmp4;
mtTmp6 = 0;
i = 0;
mtTmp8 = 1;
mtTmp7 = 1;
mtTmp10 = 9;
mtTmp9 = true;
for(i = 0;mtTmp9;i = mtTmp7)
{
{
arr[i] = i;

}
mtTmp6 = 0;
mtTmp8 = 1;
mtTmp7 = i + 1;
i = mtTmp7;
mtTmp10 = 9;
mtTmp9 = i < 9;
}
return i;
}
}
