class tempfile
{
 public static void main ( String [] Tacoa)
{
TacoBBS temp0;
int temp1;
int temp2;
temp0 =  new TacoBBS();
temp1 = 10;
temp2 = temp0.TacoStart(temp1);
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
System.out.println(temp7);
temp8 = this;
temp9 = temp8.TacoSort();
Tacoaux01 = temp9;
temp10 = this;
temp11 = temp10.TacoPrint();
Tacoaux01 = temp11;
temp12 = 0;

return temp12;
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
temp14 = Tacosize-temp13;
Tacoi = temp14;
temp15 = 0;
temp16 = 1;
temp17 = temp15-temp16;
Tacoaux02 = temp17;
temp18 = Tacoaux02<Tacoi;
while(temp18)
{
{
temp19 = 1;
Tacoj = temp19;
temp20 = 1;
temp21 = Tacoi+temp20;
temp22 = Tacoj<temp21;
while(temp22)
{
{
temp23 = 1;
temp24 = Tacoj-temp23;
Tacoaux07 = temp24;
temp25 = Taconumber[Tacoaux07];
Tacoaux04 = temp25;
temp26 = Taconumber[Tacoj];
Tacoaux05 = temp26;
temp27 = Tacoaux05<Tacoaux04;
if(temp27)
{
{
temp28 = 1;
temp29 = Tacoj-temp28;
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
Tacont = temp32;
}
temp33 = 1;
temp34 = Tacoj+temp33;
Tacoj = temp34;

}
temp35 = 1;
temp36 = Tacoi+temp35;
temp37 = Tacoj<temp36;
temp22 = temp37;

}
temp38 = 1;
temp39 = Tacoi-temp38;
Tacoi = temp39;

}
temp40 = Tacoaux02<Tacoi;
temp18 = temp40;

}
temp41 = 0;

return temp41;
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
Tacoj = temp42;
temp43 = Tacoj<Tacosize;
while(temp43)
{
{
temp44 = Taconumber[Tacoj];
System.out.println(temp44);
temp45 = 1;
temp46 = Tacoj+temp45;
Tacoj = temp46;

}
temp47 = Tacoj<Tacosize;
temp43 = temp47;

}
temp48 = 0;

return temp48;
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
Taconumber[temp50] = temp51;
temp52 = 1;
temp53 = 7;
Taconumber[temp52] = temp53;
temp54 = 2;
temp55 = 12;
Taconumber[temp54] = temp55;
temp56 = 3;
temp57 = 18;
Taconumber[temp56] = temp57;
temp58 = 4;
temp59 = 2;
Taconumber[temp58] = temp59;
temp60 = 5;
temp61 = 11;
Taconumber[temp60] = temp61;
temp62 = 6;
temp63 = 6;
Taconumber[temp62] = temp63;
temp64 = 7;
temp65 = 9;
Taconumber[temp64] = temp65;
temp66 = 8;
temp67 = 19;
Taconumber[temp66] = temp67;
temp68 = 9;
temp69 = 5;
Taconumber[temp68] = temp69;
temp70 = 0;

return temp70;
}

}


