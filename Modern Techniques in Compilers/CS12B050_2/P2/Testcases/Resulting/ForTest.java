class ForTest
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
int Tacoproduct;
int Tacoi;
int temp3;
int temp4;
int temp5;
int temp6;
boolean temp7;
int temp8;
int temp9;
int temp10;
int temp11;
int temp12;
int temp13;
int temp14;
boolean temp15;
temp3 = 1;
Tacoproduct = temp3;
temp4 = 2;
Tacoi = temp4;
temp5 = 1;
temp6 = Taconum+temp5;
temp7 = Tacoi<temp6;
temp8 = 1;
temp9 = Tacoi+temp8;
for(Tacoi=temp4;temp7;Tacoi=temp9)
{
{
temp10 = Tacoproduct*Tacoi;
Tacoproduct = temp10;

}
temp11 = 1;
temp12 = Tacoi+temp11;
Tacoi = temp12;
temp9 = temp12;
temp13 = 1;
temp14 = Taconum+temp13;
temp15 = Tacoi<temp14;
temp7 = temp15;
}

return Tacoproduct;
}

}


