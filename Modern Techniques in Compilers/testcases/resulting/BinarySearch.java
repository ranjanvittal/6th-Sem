class BinarySearch
{
public static void main( String[] Tacoa)
{
TacoBS temp0;

int temp1;

int temp2;

temp0 = new TacoBS();
temp1 = 20;
temp2 = temp0.TacoStart(20);
System.out.println(temp2);
}
}
class TacoBS
{
int[] Taconumber;
int Tacosize;
public int TacoStart(int Tacosz)
{
int Tacoaux01;
int Tacoaux02;
TacoBS temp3;
int temp4;
TacoBS temp5;
int temp6;
TacoBS temp7;
int temp8;
boolean temp9;
int temp10;
int temp11;
TacoBS temp12;
int temp13;
boolean temp14;
int temp15;
int temp16;
TacoBS temp17;
int temp18;
boolean temp19;
int temp20;
int temp21;
TacoBS temp22;
int temp23;
boolean temp24;
int temp25;
int temp26;
TacoBS temp27;
int temp28;
boolean temp29;
int temp30;
int temp31;
TacoBS temp32;
int temp33;
boolean temp34;
int temp35;
int temp36;
TacoBS temp37;
int temp38;
boolean temp39;
int temp40;
int temp41;
TacoBS temp42;
int temp43;
boolean temp44;
int temp45;
int temp46;
int temp47;
temp3 = this;
temp4 = temp3.TacoInit(Tacosz);
Tacoaux01 = temp4;
temp5 = this;
temp6 = temp5.TacoPrint();
Tacoaux02 = temp6;
temp7 = this;
temp8 = 8;
temp9 = temp7.TacoSearch(8);
if(temp9)
{
temp10 = 1;
System.out.println(1);
}
else
{
temp11 = 0;
System.out.println(0);
}
temp12 = this;
temp13 = 19;
temp14 = temp12.TacoSearch(19);
if(temp14)
{
temp15 = 1;
System.out.println(1);
}
else
{
temp16 = 0;
System.out.println(0);
}
temp17 = this;
temp18 = 20;
temp19 = temp17.TacoSearch(20);
if(temp19)
{
temp20 = 1;
System.out.println(1);
}
else
{
temp21 = 0;
System.out.println(0);
}
temp22 = this;
temp23 = 21;
temp24 = temp22.TacoSearch(21);
if(temp24)
{
temp25 = 1;
System.out.println(1);
}
else
{
temp26 = 0;
System.out.println(0);
}
temp27 = this;
temp28 = 37;
temp29 = temp27.TacoSearch(37);
if(temp29)
{
temp30 = 1;
System.out.println(1);
}
else
{
temp31 = 0;
System.out.println(0);
}
temp32 = this;
temp33 = 38;
temp34 = temp32.TacoSearch(38);
if(temp34)
{
temp35 = 1;
System.out.println(1);
}
else
{
temp36 = 0;
System.out.println(0);
}
temp37 = this;
temp38 = 39;
temp39 = temp37.TacoSearch(39);
if(temp39)
{
temp40 = 1;
System.out.println(1);
}
else
{
temp41 = 0;
System.out.println(0);
}
temp42 = this;
temp43 = 50;
temp44 = temp42.TacoSearch(50);
if(temp44)
{
temp45 = 1;
System.out.println(1);
}
else
{
temp46 = 0;
System.out.println(0);
}
temp47 = 999;
return 999;
}
public boolean TacoSearch(int Taconum)
{
boolean Tacobs01;
int Tacoright;
int Tacoleft;
boolean Tacovar_cont;
int Tacomedium;
int Tacoaux01;
int Tacont;
int temp48;
boolean temp49;
int temp50;
int temp51;
int temp52;
int temp53;
boolean temp54;
int temp55;
TacoBS temp56;
int temp57;
int temp58;
boolean temp59;
int temp60;
int temp61;
int temp62;
int temp63;
TacoBS temp64;
boolean temp65;
boolean temp66;
boolean temp67;
boolean temp68;
boolean temp69;
int temp70;
TacoBS temp71;
boolean temp72;
boolean temp73;
boolean temp74;
temp48 = 0;
Tacoaux01 = 0;
temp49 = false;
Tacobs01 = false;
temp50 = Taconumber.length;
Tacoright = temp50;
temp51 = 1;
temp52 = Tacoright - 1;
Tacoright = temp52;
temp53 = 0;
Tacoleft = 0;
temp54 = true;
Tacovar_cont = true;
while(Tacovar_cont)
{
{
temp55 = Tacoleft + Tacoright;
Tacomedium = temp55;
temp56 = this;
temp57 = temp56.TacoDiv(Tacomedium);
Tacomedium = temp57;
temp58 = Taconumber[Tacomedium];
Tacoaux01 = temp58;
temp59 = Taconum < Tacoaux01;
if(temp59)
{
temp60 = 1;
temp61 = Tacomedium - 1;
Tacoright = temp61;
}
else
{
temp62 = 1;
temp63 = Tacomedium + 1;
Tacoleft = temp63;
}
temp64 = this;
temp65 = temp64.TacoCompare(Tacoaux01, Taconum);
if(temp65)
{
temp66 = false;
Tacovar_cont = false;
}
else
{
temp67 = true;
Tacovar_cont = true;
}
temp68 = Tacoright < Tacoleft;
if(temp68)
{
temp69 = false;
Tacovar_cont = false;
}
else
{
temp70 = 0;
Tacont = 0;
}
}
Tacovar_cont = Tacovar_cont;
}
temp71 = this;
temp72 = temp71.TacoCompare(Tacoaux01, Taconum);
if(temp72)
{
temp73 = true;
Tacobs01 = true;
}
else
{
temp74 = false;
Tacobs01 = false;
}
return Tacobs01;
}
public int TacoDiv(int Taconum)
{
int Tacocount01;
int Tacocount02;
int Tacoaux03;
int temp75;
int temp76;
int temp77;
int temp78;
boolean temp79;
int temp80;
int temp81;
int temp82;
int temp83;
boolean temp84;
temp75 = 0;
Tacocount01 = 0;
temp76 = 0;
Tacocount02 = 0;
temp77 = 1;
temp78 = Taconum - 1;
Tacoaux03 = temp78;
temp79 = 0 < Tacoaux03;
while(temp79)
{
{
temp80 = 1;
temp81 = Tacocount01 + 1;
Tacocount01 = temp81;
temp82 = 2;
temp83 = Tacocount02 + 2;
Tacocount02 = temp83;
}
temp84 = Tacocount02 < Tacoaux03;
temp79 = temp84;
}
return Tacocount01;
}
public boolean TacoCompare(int Taconum1, int Taconum2)
{
boolean Tacoretval;
int Tacoaux02;
boolean temp85;
int temp86;
int temp87;
boolean temp88;
boolean temp89;
boolean temp90;
boolean temp91;
boolean temp92;
boolean temp93;
temp85 = false;
Tacoretval = false;
temp86 = 1;
temp87 = Taconum2 + 1;
Tacoaux02 = temp87;
temp88 = Taconum1 < Taconum2;
if(temp88)
{
temp89 = false;
Tacoretval = false;
}
else
{
temp90 = Taconum1 < Tacoaux02;
temp91 = !temp90;
if(temp91)
{
temp92 = false;
Tacoretval = false;
}
else
{
temp93 = true;
Tacoretval = true;
}
}
return Tacoretval;
}
public int TacoPrint()
{
int Tacoj;
int temp94;
boolean temp95;
int temp96;
int temp97;
int temp98;
boolean temp99;
int temp100;
int temp101;
temp94 = 1;
Tacoj = 1;
temp95 = 1 < Tacosize;
while(temp95)
{
{
temp96 = Taconumber[Tacoj];
System.out.println(temp96);
temp97 = 1;
temp98 = Tacoj + 1;
Tacoj = temp98;
}
temp99 = Tacoj < Tacosize;
temp95 = temp99;
}
temp100 = 99999;
System.out.println(99999);
temp101 = 0;
return 0;
}
public int TacoInit(int Tacosz)
{
int Tacoj;
int Tacok;
int Tacoaux02;
int Tacoaux01;
int[] temp102;
int temp103;
int temp104;
int temp105;
boolean temp106;
int temp107;
int temp108;
int temp109;
int temp110;
int temp111;
int temp112;
int temp113;
int temp114;
int temp115;
boolean temp116;
int temp117;
Tacosize = Tacosz;
temp102 = new int[Tacosz];
Taconumber = temp102;
temp103 = 1;
Tacoj = 1;
temp104 = 1;
temp105 = Tacosize + 1;
Tacok = temp105;
temp106 = 1 < Tacosize;
while(temp106)
{
{
temp107 = 2;
temp108 = 2 * Tacoj;
Tacoaux01 = temp108;
temp109 = 3;
temp110 = Tacok - 3;
Tacoaux02 = temp110;
temp111 = Tacoaux01 + Tacoaux02;
Taconumber[Tacoj] = temp111;

temp112 = 1;
temp113 = Tacoj + 1;
Tacoj = temp113;
temp114 = 1;
temp115 = Tacok - 1;
Tacok = temp115;
}
temp116 = Tacoj < Tacosize;
temp106 = temp116;
}
temp117 = 0;
return 0;
}
}
