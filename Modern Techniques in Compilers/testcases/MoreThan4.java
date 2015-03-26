class MoreThan4
{
 public static void main ( String [] Tacoa)
{
TacoMT4 temp0;
int temp1;
int temp2;
int temp3;
int temp4;
int temp5;
int temp6;
int temp7;
temp0 =  new TacoMT4();
temp1 = 1;
temp2 = 2;
temp3 = 3;
temp4 = 4;
temp5 = 5;
temp6 = 6;
temp7 = temp0.TacoStart(temp1, temp2, temp3, temp4, temp5, temp6);
System.out.println(temp7);

}
}

class TacoMT4
{
public int TacoStart(int Tacop1, int Tacop2, int Tacop3, int Tacop4, int Tacop5, int Tacop6)
{
int Tacoaux;
TacoMT4 temp8;
int temp9;
System.out.println(Tacop1);
System.out.println(Tacop2);
System.out.println(Tacop3);
System.out.println(Tacop4);
System.out.println(Tacop5);
System.out.println(Tacop6);
temp8 = this;
temp9 = temp8.TacoChange(Tacop6, Tacop5, Tacop4, Tacop3, Tacop2, Tacop1);
Tacoaux = temp9;

return Tacoaux;
}
public int TacoChange(int Tacop1, int Tacop2, int Tacop3, int Tacop4, int Tacop5, int Tacop6)
{
int temp10;
System.out.println(Tacop1);
System.out.println(Tacop2);
System.out.println(Tacop3);
System.out.println(Tacop4);
System.out.println(Tacop5);
System.out.println(Tacop6);
temp10 = 0;

return temp10;
}

}


