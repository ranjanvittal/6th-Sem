class QuickSort
{
 public static void main ( String [] Tacoa)
{
TacoQS temp0;
int temp1;
int temp2;
temp0 =  new TacoQS();
temp1 = 10;
temp2 = temp0.TacoStart(temp1);
System.out.println(temp2);

}
}

class TacoQS
{
int[] Taconumber;
int Tacosize;
public int TacoStart(int Tacosz)
{
int Tacoaux01;
TacoQS temp3;
int temp4;
TacoQS temp5;
int temp6;
int temp7;
int temp8;
int temp9;
TacoQS temp10;
int temp11;
int temp12;
TacoQS temp13;
int temp14;
int temp15;
temp3 = this;
temp4 = temp3.TacoInit(Tacosz);
Tacoaux01 = temp4;
temp5 = this;
temp6 = temp5.TacoPrint();
Tacoaux01 = temp6;
temp7 = 9999;
System.out.println(temp7);
temp8 = 1;
temp9 = Tacosize-temp8;
Tacoaux01 = temp9;
temp10 = this;
temp11 = 0;
temp12 = temp10.TacoSort(temp11, Tacoaux01);
Tacoaux01 = temp12;
temp13 = this;
temp14 = temp13.TacoPrint();
Tacoaux01 = temp14;
temp15 = 0;

return temp15;
}
public int TacoSort(int Tacoleft, int Tacoright)
{
int Tacov;
int Tacoi;
int Tacoj;
int Tacont;
int Tacot;
boolean Tacocont01;
boolean Tacocont02;
int Tacoaux03;
int temp16;
boolean temp17;
int temp18;
int temp19;
int temp20;
boolean temp21;
boolean temp22;
int temp23;
int temp24;
int temp25;
boolean temp26;
boolean temp27;
boolean temp28;
boolean temp29;
boolean temp30;
int temp31;
int temp32;
int temp33;
boolean temp34;
boolean temp35;
boolean temp36;
boolean temp37;
int temp38;
int temp39;
int temp40;
int temp41;
boolean temp42;
boolean temp43;
boolean temp44;
int temp45;
int temp46;
TacoQS temp47;
int temp48;
int temp49;
int temp50;
TacoQS temp51;
int temp52;
int temp53;
int temp54;
int temp55;
int temp56;
temp16 = 0;
Tacot = temp16;
temp17 = Tacoleft<Tacoright;
if(temp17)
{
{
temp18 = Taconumber[Tacoright];
Tacov = temp18;
temp19 = 1;
temp20 = Tacoleft-temp19;
Tacoi = temp20;
Tacoj = Tacoright;
temp21 = true;
Tacocont01 = temp21;
while(Tacocont01)
{
{
temp22 = true;
Tacocont02 = temp22;
while(Tacocont02)
{
{
temp23 = 1;
temp24 = Tacoi+temp23;
Tacoi = temp24;
temp25 = Taconumber[Tacoi];
Tacoaux03 = temp25;
temp26 = Tacoaux03<Tacov;
temp27 = !temp26;
if(temp27)
{
temp28 = false;
Tacocont02 = temp28;
}
else
{
temp29 = true;
Tacocont02 = temp29;
}

}
Tacocont02 = Tacocont02;

}
temp30 = true;
Tacocont02 = temp30;
while(Tacocont02)
{
{
temp31 = 1;
temp32 = Tacoj-temp31;
Tacoj = temp32;
temp33 = Taconumber[Tacoj];
Tacoaux03 = temp33;
temp34 = Tacov<Tacoaux03;
temp35 = !temp34;
if(temp35)
{
temp36 = false;
Tacocont02 = temp36;
}
else
{
temp37 = true;
Tacocont02 = temp37;
}

}
Tacocont02 = Tacocont02;

}
temp38 = Taconumber[Tacoi];
Tacot = temp38;
temp39 = Taconumber[Tacoj];
Taconumber[Tacoi] = temp39;
Taconumber[Tacoj] = Tacot;
temp40 = 1;
temp41 = Tacoi+temp40;
temp42 = Tacoj<temp41;
if(temp42)
{
temp43 = false;
Tacocont01 = temp43;
}
else
{
temp44 = true;
Tacocont01 = temp44;
}

}
Tacocont01 = Tacocont01;

}
temp45 = Taconumber[Tacoi];
Taconumber[Tacoj] = temp45;
temp46 = Taconumber[Tacoright];
Taconumber[Tacoi] = temp46;
Taconumber[Tacoright] = Tacot;
temp47 = this;
temp48 = 1;
temp49 = Tacoi-temp48;
temp50 = temp47.TacoSort(Tacoleft, temp49);
Tacont = temp50;
temp51 = this;
temp52 = 1;
temp53 = Tacoi+temp52;
temp54 = temp51.TacoSort(temp53, Tacoright);
Tacont = temp54;

}
}
else
{
temp55 = 0;
Tacont = temp55;
}
temp56 = 0;

return temp56;
}
public int TacoPrint()
{
int Tacoj;
int temp57;
boolean temp58;
int temp59;
int temp60;
int temp61;
boolean temp62;
int temp63;
temp57 = 0;
Tacoj = temp57;
temp58 = Tacoj<Tacosize;
while(temp58)
{
{
temp59 = Taconumber[Tacoj];
System.out.println(temp59);
temp60 = 1;
temp61 = Tacoj+temp60;
Tacoj = temp61;

}
temp62 = Tacoj<Tacosize;
temp58 = temp62;

}
temp63 = 0;

return temp63;
}
public int TacoInit(int Tacosz)
{
int[] temp64;
int temp65;
int temp66;
int temp67;
int temp68;
int temp69;
int temp70;
int temp71;
int temp72;
int temp73;
int temp74;
int temp75;
int temp76;
int temp77;
int temp78;
int temp79;
int temp80;
int temp81;
int temp82;
int temp83;
int temp84;
int temp85;
Tacosize = Tacosz;
temp64 = new int[Tacosz];
Taconumber = temp64;
temp65 = 0;
temp66 = 20;
Taconumber[temp65] = temp66;
temp67 = 1;
temp68 = 7;
Taconumber[temp67] = temp68;
temp69 = 2;
temp70 = 12;
Taconumber[temp69] = temp70;
temp71 = 3;
temp72 = 18;
Taconumber[temp71] = temp72;
temp73 = 4;
temp74 = 2;
Taconumber[temp73] = temp74;
temp75 = 5;
temp76 = 11;
Taconumber[temp75] = temp76;
temp77 = 6;
temp78 = 6;
Taconumber[temp77] = temp78;
temp79 = 7;
temp80 = 9;
Taconumber[temp79] = temp80;
temp81 = 8;
temp82 = 19;
Taconumber[temp81] = temp82;
temp83 = 9;
temp84 = 5;
Taconumber[temp83] = temp84;
temp85 = 0;

return temp85;
}

}


