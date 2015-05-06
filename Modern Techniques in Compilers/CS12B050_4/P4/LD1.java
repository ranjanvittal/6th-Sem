class LoopyTacoLD1
{
public static void main( String[] LoopyTacoargs)
{
int LoopyTacox;
Dummy a;
a = new Dummy();
LoopyTacox = new LoopyTacoHELPER1LD1().LoopyTacofoo();
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
class LoopyTacoHELPER1LD1
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

public int LoopyTacofoo(){
LoopyTacoHELPER1LD1 a;
int LoopyTacoi;
int LoopyTacok;
int LoopyTacon;
int LoopyTacol;
int[] LoopyTacoarr;
a = this;
LoopyTacok = 0;
LoopyTacon = 5;
LoopyTacol = 0;
LoopyTacoarr = new int[LoopyTacon];
/*LOOPDISTRIBUTE*/
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
{
LoopyTacoarr[LoopyTacoi] = LoopyTacok;
LoopyTacok = LoopyTacoarr[LoopyTacoi];
}
LoopyTacol = LoopyTacoarr[LoopyTacol];
System.out.println(LoopyTacol);
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
LoopyTacok = 3;
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
{
LoopyTacol = 3;

}
System.out.println(LoopyTacok);
System.out.println(LoopyTacol);
return LoopyTacol;
}

}

