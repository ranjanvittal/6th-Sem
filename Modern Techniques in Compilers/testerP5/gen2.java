class funkyTacoT2 {
public static void main(String[] funkyTacoargv) {
int funkyTacoa;
int funkyTacob;
int funkyTacoc;
funkyTacoGen funkyTacoj;
funkyTacoGen temp0;
int temp1;
int temp2;
int temp3;
funkyTacoGen temp4;
int temp5;
int temp6;
int temp7;
funkyTacoj = new funkyTacoGen();
funkyTacoa = 1;
funkyTacob = 2;
funkyTacoc = 4;

{
temp0 = funkyTacoj;
temp1 = funkyTacoa;
temp2 = funkyTacob;
temp3 = funkyTacoc;
temp3 = temp2+temp3;
temp3 = temp1+temp3;
funkyTacoc = temp3;

}

{
temp4 = funkyTacoj;
temp5 = funkyTacoa;
temp6 = funkyTacob;
temp7 = funkyTacoc;
temp7 = temp6*temp7;
temp7 = temp5*temp7;
funkyTacoc = temp7;

}
System.out.println(funkyTacoc);

}
}
class funkyTacoGen
{
public int funkyTacoaddThree(int funkyTacoa, int funkyTacob, int funkyTacoc) { 
funkyTacoc = funkyTacob+funkyTacoc;
funkyTacoc = funkyTacoa+funkyTacoc;
return funkyTacoc;
}
public int funkyTacomultiplyThree(int funkyTacoa, int funkyTacob, int funkyTacoc) { 
funkyTacoc = funkyTacob*funkyTacoc;
funkyTacoc = funkyTacoa*funkyTacoc;
return funkyTacoc;
}

}

