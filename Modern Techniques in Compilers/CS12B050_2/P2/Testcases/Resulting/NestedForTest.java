class NestedForTest
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
public int TacoComputeFac(int Taconum)
{
int[] Tacoa;
int Tacoi;
int Tacoj;
int Tacotemp;
int temp3;
int[] temp4;
int temp5;
int temp6;
int temp7;
int temp8;
int temp9;
int temp10;
int temp11;
int temp12;
int temp13;
int temp14;
int temp15;
int temp16;
int temp17;
int temp18;
int temp19;
int temp20;
int temp21;
int temp22;
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
boolean temp33;
int temp34;
int temp35;
int temp36;
int temp37;
boolean temp38;
int temp39;
int temp40;
int temp41;
int temp42;
int temp43;
int temp44;
boolean temp45;
int temp46;
int temp47;
int temp48;
boolean temp49;
int temp50;
int temp51;
boolean temp52;
int temp53;
int temp54;
int temp55;
int temp56;
int temp57;
int temp58;
boolean temp59;
int temp60;
temp3 = 10;
temp4 = new int[temp3];
Tacoa = temp4;
temp5 = 0;
temp6 = 10;
Tacoa[temp5] = temp6;
temp7 = 1;
temp8 = 9;
Tacoa[temp7] = temp8;
temp9 = 2;
temp10 = 8;
Tacoa[temp9] = temp10;
temp11 = 3;
temp12 = 7;
Tacoa[temp11] = temp12;
temp13 = 4;
temp14 = 6;
Tacoa[temp13] = temp14;
temp15 = 5;
temp16 = 5;
Tacoa[temp15] = temp16;
temp17 = 6;
temp18 = 4;
Tacoa[temp17] = temp18;
temp19 = 7;
temp20 = 3;
Tacoa[temp19] = temp20;
temp21 = 8;
temp22 = 2;
Tacoa[temp21] = temp22;
temp23 = 9;
temp24 = 1;
Tacoa[temp23] = temp24;
temp25 = 0;
Tacoi = temp25;
temp26 = 9;
temp27 = Tacoi<temp26;
temp28 = 1;
temp29 = Tacoi+temp28;
for(Tacoi=temp25;temp27;Tacoi=temp29)
{
temp30 = 1;
temp31 = Tacoi+temp30;
Tacoj = temp31;
temp32 = 10;
temp33 = Tacoj<temp32;
temp34 = 1;
temp35 = Tacoj+temp34;
for(Tacoj=temp31;temp33;Tacoj=temp35)
{
temp36 = Tacoa[Tacoj];
temp37 = Tacoa[Tacoi];
temp38 = temp36<temp37;
if(temp38)
{
{
temp39 = Tacoa[Tacoi];
Tacotemp = temp39;
temp40 = Tacoa[Tacoj];
Tacoa[Tacoi] = temp40;
Tacoa[Tacoj] = Tacotemp;

}
}
else
{
temp41 = 1;
Tacotemp = temp41;
}
temp42 = 1;
temp43 = Tacoj+temp42;
Tacoj = temp43;
temp35 = temp43;
temp44 = 10;
temp45 = Tacoj<temp44;
temp33 = temp45;
}
temp46 = 1;
temp47 = Tacoi+temp46;
Tacoi = temp47;
temp29 = temp47;
temp48 = 9;
temp49 = Tacoi<temp48;
temp27 = temp49;
}
temp50 = 0;
Tacoi = temp50;
temp51 = 10;
temp52 = Tacoi<temp51;
temp53 = 1;
temp54 = Tacoi+temp53;
for(Tacoi=temp50;temp52;Tacoi=temp54)
{
temp55 = Tacoa[Tacoi];
System.out.println(temp55);
temp56 = 1;
temp57 = Tacoi+temp56;
Tacoi = temp57;
temp54 = temp57;
temp58 = 10;
temp59 = Tacoi<temp58;
temp52 = temp59;
}
temp60 = 1;

return temp60;
}

}


