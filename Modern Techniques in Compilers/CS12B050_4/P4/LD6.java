class LD6
{
public static void main( String[] LoopyTacoargs)
{
int LoopyTacoi;
int LoopyTacok;
int LoopyTacon;
int LoopyTacol;
int LoopyTacot1;
int LoopyTacot2;
int LoopyTacot3;
int[] LoopyTacoarr;
boolean LoopyTacof1;
Dummy a;
a = new Dummy();
LoopyTacof1 = false;
LoopyTacot1 = 0;
LoopyTacot2 = 0;
LoopyTacok = 0;
LoopyTacon = 5;
LoopyTacol = 25;
LoopyTacoarr = new int[LoopyTacol];
/*LOOPDISTRIBUTE*/
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
{
LoopyTacoarr[LoopyTacoi] = LoopyTacoi;
LoopyTacot1 = LoopyTacoarr[LoopyTacoi];
}
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
while(LoopyTacof1)
{
LoopyTacot1 = 2*LoopyTacoi;
LoopyTacot2 = LoopyTacot1+1;
LoopyTacoarr[LoopyTacot2] = LoopyTacoi;
}
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
{
LoopyTacot3 = 2*LoopyTacoi;
LoopyTacot3 = LoopyTacoarr[LoopyTacot1];

}
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
{
LoopyTacot1 = LoopyTacoarr[LoopyTacon];
System.out.println(LoopyTacot1);
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

