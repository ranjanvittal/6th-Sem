class LICM5
{
public static void main( String[] LoopyTacoargs)
{
int LoopyTacoi;
int LoopyTacon;
int LoopyTacom;
int LoopyTacox;
int LoopyTacoy;
int LoopyTacoz;
Dummy a;
boolean t0;
boolean t1;
a = new Dummy();
LoopyTacon = 10;
LoopyTacoy = 10;
LoopyTacoz = 2;
LoopyTacox = 17;
LoopyTacoi = 0;
t0 = LoopyTacoi<LoopyTacon;
if(t0)
{
LoopyTacom = 10;
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
{
LoopyTacox = LoopyTacoy;
LoopyTacoy = 3;
}
}
else
{
}
System.out.println(LoopyTacox);
System.out.println(LoopyTacoy);
LoopyTacoi = 0;
t1 = LoopyTacoi<LoopyTacon;
if(t1)
{
LoopyTacom = 10;
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
{
LoopyTacox = LoopyTacoy;
LoopyTacoy = LoopyTacox;
}
}
else
{
}
System.out.println(LoopyTacox);
System.out.println(LoopyTacoy);
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

