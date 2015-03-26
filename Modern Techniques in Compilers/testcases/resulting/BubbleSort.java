class BubbleSort
{
public static void main( String[] Tacoa)
{
TacoBBS temp0;

int temp1;

int temp2;

temp0 = new TacoBBS();
temp1 = 10;
temp2 = temp0.TacoStart(10);
System.out.println(temp2);
}
}
class TacoBBS
{
int[] Taconumber;
int Tacosize;
public int TacoStart(int Tacosz)
{
int Tacoaux01;
TacoBBS temp3;
int temp4;
TacoBBS temp5;
int temp6;
int temp7;
TacoBBS temp8;
int temp9;
TacoBBS temp10;
int temp11;
int temp12;
temp3 = this;
temp4 = temp3.TacoInit(Tacosz);
Tacoaux01 = temp4;
temp5 = this;
temp6 = temp5.TacoPrint();
Tacoaux01 = temp6;
temp7 = 99999;
System.out.println(99999);
temp8 = this;
temp9 = temp8.TacoSort();
Tacoaux01 = temp9;
temp10 = this;
temp11 = temp10.TacoPrint();
Tacoaux01 = temp11;
temp12 = 0;
return 0;
}
public int TacoSort()
{
int Tacont;
int Tacoi;
int Tacoaux02;
int Tacoaux04;
int Tacoaux05;
int Tacoaux06;
int Tacoaux07;
int Tacoj;
int Tacot;
int temp13;
int temp14;
int temp15;
int temp16;
int temp17;
boolean temp18;
int temp19;
int temp20;
int temp21;
boolean temp22;
int temp23;
int temp24;
int temp25;
int temp26;
boolean temp27;
int temp28;
int temp29;
int temp30;
int temp31;
int temp32;
int temp33;
int temp34;
int temp35;
int temp36;
boolean temp37;
int temp38;
int temp39;
boolean temp40;
int temp41;
temp13 = 1;
temp14 = Tacosize - 1;
Tacoi = temp14;
temp15 = 0;
temp16 = 1;
temp17 = -1;
Tacoaux02 = -1;
temp18 = -1 < Tacoi;
while(temp18)
{
{
temp19 = 1;
Tacoj = 1;
temp20 = 1;
temp21 = Tacoi + 1;
temp22 = 1 < temp21;
while(temp22)
{
{
temp23 = 1;
temp24 = Tacoj - 1;
Tacoaux07 = temp24;
temp25 = Taconumber[Tacoaux07];
Tacoaux04 = temp25;
temp26 = Taconumber[Tacoj];
Tacoaux05 = temp26;
temp27 = Tacoaux05 < Tacoaux04;
if(temp27)
{
{
temp28 = 1;
temp29 = Tacoj - 1;
Tacoaux06 = temp29;
temp30 = Taconumber[Tacoaux06];
Tacot = temp30;
temp31 = Taconumber[Tacoj];
Taconumber[Tacoaux06] = temp31;

Taconumber[Tacoj] = Tacot;

}
}
else
{
temp32 = 0;
Tacont = 0;
}
temp33 = 1;
temp34 = Tacoj + 1;
Tacoj = temp34;
}
temp35 = 1;
temp36 = Tacoi + 1;
temp37 = Tacoj < temp36;
temp22 = temp37;
}
temp38 = 1;
temp39 = Tacoi - 1;
Tacoi = temp39;
}
temp40 = -1 < Tacoi;
temp18 = temp40;
}
temp41 = 0;
return 0;
}
public int TacoPrint()
{
int Tacoj;
int temp42;
boolean temp43;
int temp44;
int temp45;
int temp46;
boolean temp47;
int temp48;
temp42 = 0;
Tacoj = 0;
temp43 = 0 < Tacosize;
while(temp43)
{
{
temp44 = Taconumber[Tacoj];
System.out.println(temp44);
temp45 = 1;
temp46 = Tacoj + 1;
Tacoj = temp46;
}
temp47 = Tacoj < Tacosize;
temp43 = temp47;
}
temp48 = 0;
return 0;
}
public int TacoInit(int Tacosz)
{
int[] temp49;
int temp50;
int temp51;
int temp52;
int temp53;
int temp54;
int temp55;
int temp56;
int temp57;
int temp58;
int temp59;
int temp60;
int temp61;
int temp62;
int temp63;
int temp64;
int temp65;
int temp66;
int temp67;
int temp68;
int temp69;
int temp70;
Tacosize = Tacosz;
temp49 = new int[Tacosz];
Taconumber = temp49;
temp50 = 0;
temp51 = 20;
Taconumber[0] = 20;

temp52 = 1;
temp53 = 7;
Taconumber[1] = 7;

temp54 = 2;
temp55 = 12;
Taconumber[2] = 12;

temp56 = 3;
temp57 = 18;
Taconumber[3] = 18;

temp58 = 4;
temp59 = 2;
Taconumber[4] = 2;

temp60 = 5;
temp61 = 11;
Taconumber[5] = 11;

temp62 = 6;
temp63 = 6;
Taconumber[6] = 6;

temp64 = 7;
temp65 = 9;
Taconumber[7] = 9;

temp66 = 8;
temp67 = 19;
Taconumber[8] = 19;

temp68 = 9;
temp69 = 5;
Taconumber[9] = 5;

temp70 = 0;
return 0;
}
}
