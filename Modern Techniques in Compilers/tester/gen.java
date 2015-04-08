class funkyTacoTestP55 {
public static void main(String[] funkyTacoargs) {
funkyTacoA funkyTacos;
funkyTacoB funkyTacot;
funkyTacoC funkyTacor;
int funkyTacop;
funkyTacoC temp0;
int temp1;
int temp2;
int temp3;
int temp4;
int temp5;
int temp6;
int temp7;
int temp8;
int temp9;
int temp10;
int temp11;
int temp12;
funkyTacos = new funkyTacoA();
funkyTacot = new funkyTacoB();
funkyTacor = new funkyTacoC();
funkyTacop = funkyTacos.funkyTacoAdd();
System.out.println(funkyTacop);
funkyTacop = funkyTacot.funkyTacoAdd();
System.out.println(funkyTacop);

{
temp0 = funkyTacor;
temp4 = temp0.get_funkyTacoC_funkyTacoa_10();temp5 = 16;
temp0.funkyTacoa = temp5;
temp6 = temp0.get_funkyTacoC_funkyTacob_10();temp7 = 19;
temp0.funkyTacob = temp7;
temp8 = temp0.get_funkyTacoC_funkyTacoc_10();temp9 = 24;
temp0.funkyTacoc = temp9;
temp10 = temp0.get_funkyTacoC_funkyTacob_10();System.out.println(temp10);
temp11 = temp0.get_funkyTacoC_funkyTacoc_10();System.out.println(temp11);
temp12 = temp0.get_funkyTacoC_funkyTacoa_10();funkyTacop = temp12;

}
System.out.println(funkyTacop);
funkyTacos = new funkyTacoB();
funkyTacop = funkyTacos.funkyTacoAdd();
System.out.println(funkyTacop);

}
}
class funkyTacoA
{
int funkyTacoa;
public int get_funkyTacoA_funkyTacoa_10() {
return funkyTacoa;
}
public int funkyTacoAdd() { 
funkyTacoa = 10;
return funkyTacoa;
}

}
class funkyTacoB extends funkyTacoA
{
int funkyTacob;
public int get_funkyTacoB_funkyTacob_10() {
return funkyTacob;
}
public int get_funkyTacoB_funkyTacoa_10() {
return funkyTacoa;
}
public int funkyTacoAdd() { 
funkyTacoa = 15;
funkyTacob = 17;
System.out.println(funkyTacob);
return funkyTacoa;
}

}
class funkyTacoC extends funkyTacoB
{
int funkyTacoc;
public int get_funkyTacoC_funkyTacoc_10() {
return funkyTacoc;
}
public int get_funkyTacoC_funkyTacob_10() {
return funkyTacob;
}
public int get_funkyTacoC_funkyTacoa_10() {
return funkyTacoa;
}
public int funkyTacoAdd() { 
funkyTacoa = 16;
funkyTacob = 19;
funkyTacoc = 24;
System.out.println(funkyTacob);
System.out.println(funkyTacoc);
return funkyTacoa;
}

}

