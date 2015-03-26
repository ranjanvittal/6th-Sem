class LinearSearch
{
public static void main( String[] Tacoa)
{
TacoLS temp0;

int temp1;

int temp2;

temp0 = new TacoLS();
temp1 = 10;
temp2 = temp0.TacoStart(10);
System.out.println(temp2);
}
}
class TacoLS
{
int[] Taconumber;
int Tacosize;
public int TacoStart(int Tacosz)
{
int Tacoaux01;
int Tacoaux02;
TacoLS temp3;
int temp4;
TacoLS temp5;
int temp6;
int temp7;
TacoLS temp8;
int temp9;
int temp10;
TacoLS temp11;
int temp12;
int temp13;
TacoLS temp14;
int temp15;
int temp16;
TacoLS temp17;
int temp18;
int temp19;
int temp20;
temp3 = this;
temp4 = temp3.TacoInit(Tacosz);
Tacoaux01 = temp4;
temp5 = this;
temp6 = temp5.TacoPrint();
Tacoaux02 = temp6;
temp7 = 9999;
System.out.println(9999);
temp8 = this;
temp9 = 8;
temp10 = temp8.TacoSearch(8);
System.out.println(temp10);
temp11 = this;
temp12 = 12;
temp13 = temp11.TacoSearch(12);
System.out.println(temp13);
temp14 = this;
temp15 = 17;
temp16 = temp14.TacoSearch(17);
System.out.println(temp16);
temp17 = this;
temp18 = 50;
temp19 = temp17.TacoSearch(50);
System.out.println(temp19);
temp20 = 55;
return 55;
}
public int TacoPrint()
{
int Tacoj;
int temp21;
boolean temp22;
int temp23;
int temp24;
int temp25;
boolean temp26;
int temp27;
temp21 = 1;
Tacoj = 1;
temp22 = 1 < Tacosize;
while(temp22)
{
{
temp23 = Taconumber[Tacoj];
System.out.println(temp23);
temp24 = 1;
temp25 = Tacoj + 1;
Tacoj = temp25;
}
temp26 = Tacoj < Tacosize;
temp22 = temp26;
}
temp27 = 0;
return 0;
}
public int TacoSearch(int Taconum)
{
int Tacoj;
boolean Tacols01;
int Tacoifound;
int Tacoaux01;
int Tacoaux02;
int Tacont;
int temp28;
boolean temp29;
int temp30;
boolean temp31;
int temp32;
int temp33;
int temp34;
boolean temp35;
int temp36;
boolean temp37;
boolean temp38;
int temp39;
boolean temp40;
int temp41;
int temp42;
int temp43;
boolean temp44;
temp28 = 1;
Tacoj = 1;
temp29 = false;
Tacols01 = false;
temp30 = 0;
Tacoifound = 0;
temp31 = 1 < Tacosize;
while(temp31)
{
{
temp32 = Taconumber[Tacoj];
Tacoaux01 = temp32;
temp33 = 1;
temp34 = Taconum + 1;
Tacoaux02 = temp34;
temp35 = Tacoaux01 < Taconum;
if(temp35)
{
temp36 = 0;
Tacont = 0;
}
else
{
temp37 = Tacoaux01 < Tacoaux02;
temp38 = !temp37;
if(temp38)
{
temp39 = 0;
Tacont = 0;
}
else
{
{
temp40 = true;
Tacols01 = true;
temp41 = 1;
Tacoifound = 1;
Tacoj = Tacosize;
}
}
}
temp42 = 1;
temp43 = Tacoj + 1;
Tacoj = temp43;
}
temp44 = Tacoj < Tacosize;
temp31 = temp44;
}
return Tacoifound;
}
public int TacoInit(int Tacosz)
{
int Tacoj;
int Tacok;
int Tacoaux01;
int Tacoaux02;
int[] temp45;
int temp46;
int temp47;
int temp48;
boolean temp49;
int temp50;
int temp51;
int temp52;
int temp53;
int temp54;
int temp55;
int temp56;
int temp57;
int temp58;
boolean temp59;
int temp60;
Tacosize = Tacosz;
temp45 = new int[Tacosz];
Taconumber = temp45;
temp46 = 1;
Tacoj = 1;
temp47 = 1;
temp48 = Tacosize + 1;
Tacok = temp48;
temp49 = 1 < Tacosize;
while(temp49)
{
{
temp50 = 2;
temp51 = 2 * Tacoj;
Tacoaux01 = temp51;
temp52 = 3;
temp53 = Tacok - 3;
Tacoaux02 = temp53;
temp54 = Tacoaux01 + Tacoaux02;
Taconumber[Tacoj] = temp54;

temp55 = 1;
temp56 = Tacoj + 1;
Tacoj = temp56;
temp57 = 1;
temp58 = Tacok - 1;
Tacok = temp58;
}
temp59 = Tacoj < Tacosize;
temp49 = temp59;
}
temp60 = 0;
return 0;
}
}
