class LICM6
{
public static void main( String[] LoopyTacoargs)
{
int LoopyTacoi;
int LoopyTacon;
int LoopyTacom;
boolean LoopyTacof1;
int LoopyTacop;
int LoopyTacox;
int LoopyTacoy;
Dummy a;
boolean t0;
a = new Dummy();
LoopyTacon = 10;
LoopyTacof1 = true;
LoopyTacop = 1;
LoopyTacox = 0;
LoopyTacoy = 0;
LoopyTacoi = 0;
t0 = LoopyTacoi<LoopyTacon;
if(t0)
{
LoopyTacom = 10;
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
{
if(LoopyTacof1)
{
LoopyTacox = 10;
LoopyTacop = LoopyTacop+1;
}
else
{
LoopyTacox = 5;
LoopyTacop = LoopyTacop+1;
}
}
}
else
{
}
System.out.println(LoopyTacox);
System.out.println(LoopyTacop);
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

