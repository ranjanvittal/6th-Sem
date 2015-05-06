class LD4
{
public static void main( String[] LoopyTacoargs)
{
int LoopyTacoi;
int LoopyTacok;
int LoopyTacon;
int LoopyTacol;
int LoopyTacoz;
int[] LoopyTacoarr;
Dummy a;
a = new Dummy();
LoopyTacok = 0;
LoopyTacon = 5;
LoopyTacol = 0;
LoopyTacoz = 0;
LoopyTacoarr = new int[LoopyTacon];
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
{
LoopyTacok = 1;
LoopyTacoz = LoopyTacoi;
}
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
{
LoopyTacoz = LoopyTacol+1;

}
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
LoopyTacok = 3;
for(LoopyTacoi=0;LoopyTacoi<LoopyTacon;LoopyTacoi = LoopyTacoi+1)
{
LoopyTacol = 3;

}
System.out.println(LoopyTacok);
System.out.println(LoopyTacol);
System.out.println(LoopyTacoz);
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

