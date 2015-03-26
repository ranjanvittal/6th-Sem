class FactTest
{
 public static void main ( String [] Tacoa)
{
TacoFac1 temp0;
TacoFac temp1;
int temp2;
int temp3;
temp0 =  new TacoFac1();
temp1 = temp0.TacoComputeFac1();
temp2 = 10;
temp3 = temp1.TacoComputeFac(temp2);
System.out.println(temp3);

}
}

class TacoFac
{
public int TacoComputeFac(int Taconum)
{
int Taconum_aux;
int temp4;
boolean temp5;
int temp6;
TacoFac temp7;
int temp8;
int temp9;
int temp10;
int temp11;
temp4 = 1;
temp5 = Taconum<temp4;
if(temp5)
{
temp6 = 1;
Taconum_aux = temp6;
}
else
{
temp7 = this;
temp8 = 1;
temp9 = Taconum-temp8;
temp10 = temp7.TacoComputeFac(temp9);
temp11 = Taconum*temp10;
Taconum_aux = temp11;
}

return Taconum_aux;
}

}

class TacoFac1 extends TacoFac
{
public TacoFac TacoComputeFac1()
{
TacoFac1 temp12;
temp12 = this;

return temp12;
}

}


