class Factorial2
{
 public static void main ( String [] Tacoa)
{
TacoFac temp0;
int temp1;
int temp2;
temp0 =  new TacoFac();
temp1 = 10;
temp2 = temp0.TacoComputeFac(temp1);
System.out.println(temp2);

}
}

class TacoFac
{
public int TacoComputeFac(int Taconum)
{
int Taconum_aux;
int temp3;
boolean temp4;
int temp5;
TacoFac temp6;
int temp7;
int temp8;
int temp9;
int temp10;
temp3 = 1;
temp4 = Taconum<temp3;
if(temp4)
{
temp5 = 1;
Taconum_aux = temp5;
}
else
{
temp6 = this;
temp7 = 1;
temp8 = Taconum-temp7;
temp9 = temp6.TacoComputeFac(temp8);
temp10 = Taconum*temp9;
Taconum_aux = temp10;
}

return Taconum_aux;
}

}


