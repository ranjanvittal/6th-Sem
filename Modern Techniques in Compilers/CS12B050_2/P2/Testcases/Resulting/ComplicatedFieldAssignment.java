class ComplicatedFieldAssignment
{
 public static void main ( String [] Tacoa)
{
TacoFac temp0;
int temp1;
int temp2;
temp0 =  new TacoFac();
temp1 = 4;
temp2 = temp0.TacoComputeFac(temp1);
System.out.println(temp2);

}
}

class TacoFac
{
int[] Tacoa;
public int TacoComputeFac(int Taconum)
{
int[] Tacoa;
int Tacoi;
int Tacoj;
int Tacotemp;
int temp3;
boolean temp4;
int temp5;
int temp6;
int[] temp7;
int temp8;
int temp9;
TacoFac temp10;
int temp11;
int[] temp12;
TacoFac temp13;
int temp14;
int temp15;
int temp16;
int temp17;
int temp18;
TacoFac temp19;
int temp20;
int temp21;
TacoFac temp22;
TacoFac temp23;
TacoFac temp24;
int temp25;
int temp26;
int temp27;
temp3 = 0;
temp4 = Taconum<temp3;
if(temp4)
{
temp5 = 1;
Tacoi = temp5;
}
else
{
{
temp6 = 10;
temp7 = new int[temp6];
Tacoa = temp7;
temp8 = 1;
temp9 = 89;
Tacoa[temp8] = temp9;
temp10 = this;
temp11 = 11;
temp12 = new int[temp11];
temp10.Tacoa = temp12;
temp13 = this;
temp14 = 1;
temp15 = 78;
temp16 = temp13.TacochangeA(temp14, temp15);
Tacoi = temp16;
temp17 = 1;
temp18 = Tacoa[temp17];
System.out.println(temp18);
temp19 = this;
temp20 = 1;
temp21 = temp19.TacogetAIndex(temp20);
System.out.println(temp21);
temp22 = this;
temp23 = temp22.TacoreturnMyself();
temp23.Tacoa = Tacoa;
temp24 = this;
temp25 = 1;
temp26 = temp24.TacogetAIndex(temp25);
System.out.println(temp26);

}
}
temp27 = 1;

return temp27;
}
public TacoFac TacoreturnMyself()
{
TacoFac temp28;
temp28 = this;

return temp28;
}
public int TacogetAIndex(int Tacoindex)
{
int temp29;
temp29 = Tacoa[Tacoindex];

return temp29;
}
public int TacochangeA(int Tacoindex, int Taconum)
{
int temp30;
Tacoa[Tacoindex] = Taconum;
temp30 = 1;

return temp30;
}

}


