class LinkedList
{
public static void main( String[] Tacoa)
{
TacoLL temp0;

int temp1;

temp0 = new TacoLL();
temp1 = temp0.TacoStart();
System.out.println(temp1);
}
}
class TacoElement
{
int TacoAge;
int TacoSalary;
boolean TacoMarried;
public boolean TacoInit(int Tacov_Age, int Tacov_Salary, boolean Tacov_Married)
{
boolean temp2;
TacoAge = Tacov_Age;
TacoSalary = Tacov_Salary;
TacoMarried = Tacov_Married;
temp2 = true;
return true;
}
public int TacoGetAge()
{
return TacoAge;
}
public int TacoGetSalary()
{
return TacoSalary;
}
public boolean TacoGetMarried()
{
return TacoMarried;
}
public boolean TacoEqual(TacoElement Tacoother)
{
boolean Tacoret_val;
int Tacoaux01;
int Tacoaux02;
int Tacont;
boolean temp3;
int temp4;
TacoElement temp5;
boolean temp6;
boolean temp7;
boolean temp8;
int temp9;
TacoElement temp10;
boolean temp11;
boolean temp12;
boolean temp13;
boolean temp14;
boolean temp15;
boolean temp16;
int temp17;
boolean temp18;
boolean temp19;
int temp20;
temp3 = true;
Tacoret_val = true;
temp4 = Tacoother.TacoGetAge();
Tacoaux01 = temp4;
temp5 = this;
temp6 = temp5.TacoCompare(Tacoaux01, TacoAge);
temp7 = !temp6;
if(temp7)
{
temp8 = false;
Tacoret_val = false;
}
else
{
{
temp9 = Tacoother.TacoGetSalary();
Tacoaux02 = temp9;
temp10 = this;
temp11 = temp10.TacoCompare(Tacoaux02, TacoSalary);
temp12 = !temp11;
if(temp12)
{
temp13 = false;
Tacoret_val = false;
}
else
{
if(TacoMarried)
{
temp14 = Tacoother.TacoGetMarried();
temp15 = !temp14;
if(temp15)
{
temp16 = false;
Tacoret_val = false;
}
else
{
temp17 = 0;
Tacont = 0;
}
}
else
{
temp18 = Tacoother.TacoGetMarried();
if(temp18)
{
temp19 = false;
Tacoret_val = false;
}
else
{
temp20 = 0;
Tacont = 0;
}
}
}
}
}
return Tacoret_val;
}
public boolean TacoCompare(int Taconum1, int Taconum2)
{
boolean Tacoretval;
int Tacoaux02;
boolean temp21;
int temp22;
int temp23;
boolean temp24;
boolean temp25;
boolean temp26;
boolean temp27;
boolean temp28;
boolean temp29;
temp21 = false;
Tacoretval = false;
temp22 = 1;
temp23 = Taconum2 + 1;
Tacoaux02 = temp23;
temp24 = Taconum1 < Taconum2;
if(temp24)
{
temp25 = false;
Tacoretval = false;
}
else
{
temp26 = Taconum1 < Tacoaux02;
temp27 = !temp26;
if(temp27)
{
temp28 = false;
Tacoretval = false;
}
else
{
temp29 = true;
Tacoretval = true;
}
}
return Tacoretval;
}
}
class TacoList
{
TacoElement Tacoelem;
TacoList Taconext;
boolean Tacoend;
public boolean TacoInit()
{
boolean temp30;
boolean temp31;
temp30 = true;
Tacoend = true;
temp31 = true;
return true;
}
public boolean TacoInitNew(TacoElement Tacov_elem, TacoList Tacov_next, boolean Tacov_end)
{
boolean temp32;
Tacoend = Tacov_end;
Tacoelem = Tacov_elem;
Taconext = Tacov_next;
temp32 = true;
return true;
}
public TacoList TacoInsert(TacoElement Taconew_elem)
{
boolean Tacoret_val;
TacoList Tacoaux03;
TacoList Tacoaux02;
TacoList temp33;
TacoList temp34;
boolean temp35;
boolean temp36;
temp33 = this;
Tacoaux03 = temp33;
temp34 = new TacoList();
Tacoaux02 = temp34;
temp35 = false;
temp36 = Tacoaux02.TacoInitNew(Taconew_elem, Tacoaux03, false);
Tacoret_val = temp36;
return Tacoaux02;
}
public boolean TacoSetNext(TacoList Tacov_next)
{
boolean temp37;
Taconext = Tacov_next;
temp37 = true;
return true;
}
public TacoList TacoDelete(TacoElement Tacoe)
{
TacoList Tacomy_head;
boolean Tacoret_val;
boolean Tacoaux05;
TacoList Tacoaux01;
TacoList Tacoprev;
boolean Tacovar_end;
TacoElement Tacovar_elem;
int Tacoaux04;
int Tacont;
TacoList temp38;
boolean temp39;
int temp40;
int temp41;
int temp42;
TacoList temp43;
TacoList temp44;
boolean temp45;
boolean temp46;
boolean temp47;
boolean temp48;
boolean temp49;
int temp50;
boolean temp51;
TacoList temp52;
int temp53;
int temp54;
int temp55;
TacoList temp56;
boolean temp57;
int temp58;
int temp59;
int temp60;
int temp61;
boolean temp62;
TacoList temp63;
boolean temp64;
TacoElement temp65;
int temp66;
int temp67;
boolean temp68;
boolean temp69;
boolean temp70;
temp38 = this;
Tacomy_head = temp38;
temp39 = false;
Tacoret_val = false;
temp40 = 0;
temp41 = 1;
temp42 = -1;
Tacoaux04 = -1;
temp43 = this;
Tacoaux01 = temp43;
temp44 = this;
Tacoprev = temp44;
Tacovar_end = Tacoend;
Tacovar_elem = Tacoelem;
temp45 = !Tacovar_end;
temp46 = true;
temp47 = temp45 & true;
while(temp47)
{
{
temp48 = Tacoe.TacoEqual(Tacovar_elem);
if(temp48)
{
{
temp49 = true;
Tacoret_val = true;
temp50 = 0;
temp51 = Tacoaux04 < 0;
if(temp51)
{
{
temp52 = Tacoaux01.TacoGetNext();
Tacomy_head = temp52;
}
}
else
{
{
temp53 = 0;
temp54 = 555;
temp55 = -555;
System.out.println(-555);
temp56 = Tacoaux01.TacoGetNext();
temp57 = Tacoprev.TacoSetNext(temp56);
Tacoaux05 = temp57;
temp58 = 0;
temp59 = 555;
temp60 = -555;
System.out.println(-555);
}
}
}
}
else
{
temp61 = 0;
Tacont = 0;
}
temp62 = !Tacoret_val;
if(temp62)
{
{
Tacoprev = Tacoaux01;
temp63 = Tacoaux01.TacoGetNext();
Tacoaux01 = temp63;
temp64 = Tacoaux01.TacoGetEnd();
Tacovar_end = temp64;
temp65 = Tacoaux01.TacoGetElem();
Tacovar_elem = temp65;
temp66 = 1;
Tacoaux04 = 1;
}
}
else
{
temp67 = 0;
Tacont = 0;
}
}
temp68 = !Tacovar_end;
temp69 = !Tacoret_val;
temp70 = temp68 & temp69;
temp47 = temp70;
}
return Tacomy_head;
}
public int TacoSearch(TacoElement Tacoe)
{
int Tacoint_ret_val;
TacoList Tacoaux01;
TacoElement Tacovar_elem;
boolean Tacovar_end;
int Tacont;
int temp71;
TacoList temp72;
boolean temp73;
boolean temp74;
int temp75;
int temp76;
TacoList temp77;
boolean temp78;
TacoElement temp79;
boolean temp80;
temp71 = 0;
Tacoint_ret_val = 0;
temp72 = this;
Tacoaux01 = temp72;
Tacovar_end = Tacoend;
Tacovar_elem = Tacoelem;
temp73 = !Tacovar_end;
while(temp73)
{
{
temp74 = Tacoe.TacoEqual(Tacovar_elem);
if(temp74)
{
{
temp75 = 1;
Tacoint_ret_val = 1;
}
}
else
{
temp76 = 0;
Tacont = 0;
}
temp77 = Tacoaux01.TacoGetNext();
Tacoaux01 = temp77;
temp78 = Tacoaux01.TacoGetEnd();
Tacovar_end = temp78;
temp79 = Tacoaux01.TacoGetElem();
Tacovar_elem = temp79;
}
temp80 = !Tacovar_end;
temp73 = temp80;
}
return Tacoint_ret_val;
}
public boolean TacoGetEnd()
{
return Tacoend;
}
public TacoElement TacoGetElem()
{
return Tacoelem;
}
public TacoList TacoGetNext()
{
return Taconext;
}
public boolean TacoPrint()
{
TacoList Tacoaux01;
boolean Tacovar_end;
TacoElement Tacovar_elem;
TacoList temp81;
boolean temp82;
int temp83;
TacoList temp84;
boolean temp85;
TacoElement temp86;
boolean temp87;
boolean temp88;
temp81 = this;
Tacoaux01 = temp81;
Tacovar_end = Tacoend;
Tacovar_elem = Tacoelem;
temp82 = !Tacovar_end;
while(temp82)
{
{
temp83 = Tacovar_elem.TacoGetAge();
System.out.println(temp83);
temp84 = Tacoaux01.TacoGetNext();
Tacoaux01 = temp84;
temp85 = Tacoaux01.TacoGetEnd();
Tacovar_end = temp85;
temp86 = Tacoaux01.TacoGetElem();
Tacovar_elem = temp86;
}
temp87 = !Tacovar_end;
temp82 = temp87;
}
temp88 = true;
return true;
}
}
class TacoLL
{
public int TacoStart()
{
TacoList Tacohead;
TacoList Tacolast_elem;
boolean Tacoaux01;
TacoElement Tacoel01;
TacoElement Tacoel02;
TacoElement Tacoel03;
TacoList temp89;
boolean temp90;
boolean temp91;
boolean temp92;
TacoElement temp93;
int temp94;
int temp95;
boolean temp96;
boolean temp97;
TacoList temp98;
boolean temp99;
int temp100;
TacoElement temp101;
int temp102;
int temp103;
boolean temp104;
boolean temp105;
TacoList temp106;
boolean temp107;
int temp108;
TacoElement temp109;
int temp110;
int temp111;
boolean temp112;
boolean temp113;
TacoList temp114;
boolean temp115;
TacoElement temp116;
int temp117;
int temp118;
boolean temp119;
boolean temp120;
int temp121;
int temp122;
int temp123;
TacoElement temp124;
int temp125;
int temp126;
boolean temp127;
boolean temp128;
TacoList temp129;
boolean temp130;
int temp131;
TacoList temp132;
boolean temp133;
int temp134;
TacoList temp135;
boolean temp136;
int temp137;
int temp138;
temp89 = new TacoList();
Tacolast_elem = temp89;
temp90 = Tacolast_elem.TacoInit();
Tacoaux01 = temp90;
Tacohead = Tacolast_elem;
temp91 = Tacohead.TacoInit();
Tacoaux01 = temp91;
temp92 = Tacohead.TacoPrint();
Tacoaux01 = temp92;
temp93 = new TacoElement();
Tacoel01 = temp93;
temp94 = 25;
temp95 = 37000;
temp96 = false;
temp97 = Tacoel01.TacoInit(25, 37000, false);
Tacoaux01 = temp97;
temp98 = Tacohead.TacoInsert(Tacoel01);
Tacohead = temp98;
temp99 = Tacohead.TacoPrint();
Tacoaux01 = temp99;
temp100 = 10000000;
System.out.println(10000000);
temp101 = new TacoElement();
Tacoel01 = temp101;
temp102 = 39;
temp103 = 42000;
temp104 = true;
temp105 = Tacoel01.TacoInit(39, 42000, true);
Tacoaux01 = temp105;
Tacoel02 = Tacoel01;
temp106 = Tacohead.TacoInsert(Tacoel01);
Tacohead = temp106;
temp107 = Tacohead.TacoPrint();
Tacoaux01 = temp107;
temp108 = 10000000;
System.out.println(10000000);
temp109 = new TacoElement();
Tacoel01 = temp109;
temp110 = 22;
temp111 = 34000;
temp112 = false;
temp113 = Tacoel01.TacoInit(22, 34000, false);
Tacoaux01 = temp113;
temp114 = Tacohead.TacoInsert(Tacoel01);
Tacohead = temp114;
temp115 = Tacohead.TacoPrint();
Tacoaux01 = temp115;
temp116 = new TacoElement();
Tacoel03 = temp116;
temp117 = 27;
temp118 = 34000;
temp119 = false;
temp120 = Tacoel03.TacoInit(27, 34000, false);
Tacoaux01 = temp120;
temp121 = Tacohead.TacoSearch(Tacoel02);
System.out.println(temp121);
temp122 = Tacohead.TacoSearch(Tacoel03);
System.out.println(temp122);
temp123 = 10000000;
System.out.println(10000000);
temp124 = new TacoElement();
Tacoel01 = temp124;
temp125 = 28;
temp126 = 35000;
temp127 = false;
temp128 = Tacoel01.TacoInit(28, 35000, false);
Tacoaux01 = temp128;
temp129 = Tacohead.TacoInsert(Tacoel01);
Tacohead = temp129;
temp130 = Tacohead.TacoPrint();
Tacoaux01 = temp130;
temp131 = 2220000;
System.out.println(2220000);
temp132 = Tacohead.TacoDelete(Tacoel02);
Tacohead = temp132;
temp133 = Tacohead.TacoPrint();
Tacoaux01 = temp133;
temp134 = 33300000;
System.out.println(33300000);
temp135 = Tacohead.TacoDelete(Tacoel01);
Tacohead = temp135;
temp136 = Tacohead.TacoPrint();
Tacoaux01 = temp136;
temp137 = 44440000;
System.out.println(44440000);
temp138 = 0;
return 0;
}
}
