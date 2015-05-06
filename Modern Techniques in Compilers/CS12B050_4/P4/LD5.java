class LD5
{
public static void main( String[] LoopyTacoargs)
{
int LoopyTacoi;
int LoopyTacoj;
int LoopyTacok;
int LoopyTacon;
int LoopyTacol;
int LoopyTacot1;
int LoopyTacot2;
int LoopyTacot3;
int LoopyTacot4;
int LoopyTacot5;
int[] LoopyTacoarr;
boolean LoopyTacof1;
Dummy a;
a = new Dummy();
LoopyTacof1 = true;
LoopyTacot1 = 0;
LoopyTacot2 = 0;
LoopyTacok = 0;
LoopyTacon = 5;
LoopyTacol = 25;
LoopyTacoj = 3;
LoopyTacoarr = new int[LoopyTacol];
/*LOOPDISTRIBUTE*/
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
{
{
LoopyTacot1 = 2*LoopyTacok;
LoopyTacot2 = LoopyTacot1+3;
LoopyTacoarr[LoopyTacot2] = LoopyTacoi;
}
LoopyTacot1 = 3*LoopyTacoj;
LoopyTacot2 = LoopyTacot1+4;
LoopyTacot1 = LoopyTacoarr[LoopyTacot2];
}
System.out.println(LoopyTacot1);
/*LOOPDISTRIBUTE*/
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
{
{
LoopyTacot1 = 2*LoopyTacoi;
LoopyTacoarr[LoopyTacot1] = LoopyTacoi;
}
LoopyTacot1 = 2*LoopyTacoi;
LoopyTacot2 = LoopyTacot1+2;
LoopyTacot1 = LoopyTacoarr[LoopyTacot2];
}
System.out.println(LoopyTacot1);
/*LOOPDISTRIBUTE*/
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
{
if(LoopyTacof1)
{
LoopyTacot1 = 2*LoopyTacoi;
LoopyTacot2 = LoopyTacot1+1;
LoopyTacoarr[LoopyTacot2] = LoopyTacoi;
}
else
{
LoopyTacot4 = 2*LoopyTacoi;
LoopyTacot5 = LoopyTacot4+3;
LoopyTacoarr[LoopyTacot5] = LoopyTacoj;
}
LoopyTacot3 = 2*LoopyTacoi;
LoopyTacoarr[LoopyTacot3] = LoopyTacot3;
}
System.out.println(LoopyTacot1);
}
}
class Dummy
{public int divide(int n, int d){
int i;
int ret;
boolean b;
boolean c;
boolean e;
boolean f;
f = n<0;
if(f)
{
ret = 0;
}
else
{
i = 0;
b = d<n;
while(b)
{
n = n-d;
i = i+1;
b = d<n;
}
b = d<n;
c = n<d;
b = !b;
c = !c;
e = b&c;
if(e)
ret = i+1;
else
ret = i;
}
return ret;
}

}

