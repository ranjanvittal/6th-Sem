class ClassExtends
{
 public static void main ( String [] Tacoa)
{
TacoFac1 temp0;
int temp1;
int temp2;
temp0 =  new TacoFac1();
temp1 = 10;
temp2 = temp0.TacoComputeFac(temp1);
System.out.println(temp2);

}
}

class TacoFac
{
int Tacoa;
int Tacob;
public int TacoComputeFac(int Taconum)
{
int temp3;
temp3 = 1;

return temp3;
}
public int TacogetA()
{

return Tacoa;
}
public int TacogetB()
{

return Tacob;
}

}

class TacoFac1 extends TacoFac
{
int Tacoa;
public int TacoComputeFac(int Taconum)
{
TacoFac Tacob;
int Tacoa;
TacoFac1 temp4;
int temp5;
TacoFac1 temp6;
int temp7;
boolean temp8;
int temp9;
int temp10;
int temp11;
TacoFac1 temp12;
int temp13;
int temp14;
int temp15;
temp4 = this;
temp5 = 70;
temp4.Tacoa = temp5;
temp6 = this;
Tacob = temp6;
temp7 = 7;
temp8 = Taconum<temp7;
if(temp8)
{
temp9 = 102;
Tacoa = temp9;
}
else
{
{
temp10 = 73;
Tacob.Tacoa = temp10;
temp11 = Tacob.TacogetA();
System.out.println(temp11);
temp12 = this;
temp13 = temp12.Tacoget();
System.out.println(temp13);
temp14 = 6;
temp15 = Tacob.TacoComputeFac(temp14);
Tacoa = temp15;

}
}

return Tacoa;
}
public int Tacoget()
{

return Tacoa;
}

}


