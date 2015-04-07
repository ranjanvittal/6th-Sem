class funkyTacoT5 {
public static void main(String[] funkyTacoargv) {
int funkyTacoa;
int funkyTacob;
funkyTacoGen2 funkyTacoj;
funkyTacoGen2 temp0;
int temp1;
int temp2;
int temp3;
boolean temp4;
int temp5;
funkyTacoj = new funkyTacoGen2();
funkyTacoa = 10;

{
temp0 = funkyTacoj;
temp1 = funkyTacoa;
temp4 = temp1<2;
if(temp4)
temp3 = 1;
else
{
temp5 = temp1-1;
temp2 = temp0.funkyTaconotGoodToExpand(temp5);
temp3 = temp2*temp1;

}
funkyTacob = temp3;

}
System.out.println(funkyTacob);

}
}
class funkyTacoGen2
{
public int funkyTaconotGoodToExpand(int funkyTacoa) { 
int funkyTacob;
int funkyTacoret;
boolean funkyTacob1;
int funkyTacoc;
funkyTacoGen2 temp6;
int temp7;
int temp8;
int temp9;
boolean temp10;
int temp11;
funkyTacob1 = funkyTacoa<2;
if(funkyTacob1)
funkyTacoret = 1;
else
{
funkyTacoc = funkyTacoa-1;

{
temp6 = this;
temp7 = funkyTacoc;
temp10 = temp7<2;
if(temp10)
temp9 = 1;
else
{
temp11 = temp7-1;
temp8 = temp6.funkyTaconotGoodToExpand(temp11);
temp9 = temp8*temp7;

}
funkyTacob = temp9;

}
funkyTacoret = funkyTacob*funkyTacoa;

}
return funkyTacoret;
}

}

