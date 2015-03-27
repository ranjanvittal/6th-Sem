class LoopyTacoLoopTest
{
public static void main( String[] LoopyTacoa)
{
LoopyTacoFac LoopyTacon;
int LoopyTacot;
int LoopyTacot1;
LoopyTacon = new LoopyTacoFac();
LoopyTacot = 64;
LoopyTacot1 = LoopyTacon.LoopyTacoComputeFac(LoopyTacot);
System.out.println(LoopyTacot1);
}
}
class LoopyTacoFac
{int LoopyTacooo;public int divide(int n, int d){
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

public int LoopyTacoComputeFac(int LoopyTaconum){
LoopyTacoFac a;
int LoopyTacoi;
int LoopyTacoj;
int LoopyTacok;
int LoopyTacosum;
int LoopyTacosum2;
int LoopyTacok1;
int LoopyTacok2;
int[] LoopyTacoa;
int[] LoopyTacob;
int[] LoopyTacoc;
int LoopyTacokk;
int LoopyTacom;
int LoopyTacoret;
boolean LoopyTacot1;
boolean LoopyTacot2;
boolean LoopyTacot12;
int temp0;
int temp1;
int temp2;
boolean t0;
int t1;
int t2;
boolean t3;
int l0;
int l1;
int l2;
int l3;
boolean l4;
int l5;
boolean l6;
int l7;
a = this;
LoopyTacoret = 0;
LoopyTacot1 = true;
LoopyTacot2 = true;
LoopyTacom = LoopyTaconum+LoopyTaconum;
LoopyTacoa = new int[LoopyTacom];
LoopyTacob = new int[LoopyTacom];
LoopyTacoc = new int[LoopyTacom];
LoopyTacok = 4;
LoopyTacosum = 0;
LoopyTacoi = 4;
LoopyTacoj = 0;
t0 = LoopyTacoj<LoopyTaconum;
if(t0)
{
t1 = 1+5;
t2 = 5*3;
for(LoopyTacoj=0;LoopyTacoj<LoopyTaconum;LoopyTacoj = LoopyTacoj+1)
{
{
if(LoopyTacot1)
{
if(LoopyTacot2)
LoopyTacok = t1;
else
LoopyTacok = 3;
}
else
{
LoopyTacok = 2+LoopyTacoi;
}
}
LoopyTacosum = LoopyTacok+LoopyTacok;
LoopyTacooo = t2;
LoopyTacosum = LoopyTacosum+LoopyTacok;
for(LoopyTacoi=0;LoopyTacoi<LoopyTaconum;LoopyTacoi = LoopyTacoi+1)
{
if(LoopyTacot1)
{
LoopyTacok1 = 2*LoopyTacok;
}
else
{
LoopyTacok1 = 7;
}
LoopyTacosum = LoopyTacosum+LoopyTacok;
}
}
}
else
{
}
LoopyTacoi = 0;
t3 = LoopyTacoi<LoopyTaconum;
if(t3)
{
for(LoopyTacoi=0;LoopyTacoi<LoopyTaconum;LoopyTacoi = LoopyTacoi+1)
{
for(LoopyTacoj=0;LoopyTacoj<LoopyTaconum;LoopyTacoj = LoopyTacoj+1)
{
LoopyTacok = 5;
LoopyTacosum = LoopyTacosum+LoopyTacoj;
}
}
}
else
{
}
for(LoopyTacoj=0;LoopyTacoj<LoopyTaconum;LoopyTacoj = LoopyTacoj+1)
LoopyTacoa[LoopyTacoj] = LoopyTacoj;
for(LoopyTacoj=0;LoopyTacoj<LoopyTaconum;LoopyTacoj = LoopyTacoj+1)
{
LoopyTacosum = LoopyTacosum+LoopyTacoj;

}
for(LoopyTacoj=1;LoopyTacoj<LoopyTaconum;LoopyTacoj = LoopyTacoj+1)
{
LoopyTacok = 2*LoopyTacoj;
LoopyTacoa[LoopyTacok] = LoopyTacoj;
}
for(LoopyTacoj=1;LoopyTacoj<LoopyTaconum;LoopyTacoj = LoopyTacoj+1)
{
LoopyTacokk = 2*LoopyTacoj;
LoopyTacok1 = LoopyTacokk+1;
LoopyTacok2 = LoopyTacoa[LoopyTacok1];

}
for(l0= 0;l0 < 64;l0 = l0 + 4)
for(l1 = 0;l1 < 64;l1 = l1 + 4) {
l2 = l0 + 4;
l3 = l1 + 4;
l4 = l2 < 64;
l6 = l3 < 64;
if(l4)
l5 = l2;
else
l5 = 64;
if(l6)
l7 = l3;
else
l7 = 64;
for(LoopyTacoi = l0;LoopyTacoi < l5;LoopyTacoi = LoopyTacoi + 1)
for(LoopyTacoj = l1;LoopyTacoj < l7;LoopyTacoj = LoopyTacoj + 1)
{
LoopyTacok1 = 2*LoopyTacoi;
LoopyTacoa[LoopyTacok1] = 1;
}
}
temp1 = 64;
temp2 = 4;
temp0 = a.divide(temp1, temp2);
temp0 = temp0*4;
for(LoopyTacoi=0;LoopyTacoi<temp0;LoopyTacoi = LoopyTacoi)
{
{
LoopyTacoret = LoopyTacoa[LoopyTacoi];
System.out.println(LoopyTacoret);
}
LoopyTacoi = LoopyTacoi+1;
{
LoopyTacoret = LoopyTacoa[LoopyTacoi];
System.out.println(LoopyTacoret);
}
LoopyTacoi = LoopyTacoi+1;
{
LoopyTacoret = LoopyTacoa[LoopyTacoi];
System.out.println(LoopyTacoret);
}
LoopyTacoi = LoopyTacoi+1;
{
LoopyTacoret = LoopyTacoa[LoopyTacoi];
System.out.println(LoopyTacoret);
}
LoopyTacoi = LoopyTacoi+1;
}
for(LoopyTacoi=LoopyTacoi;LoopyTacoi<64;LoopyTacoi = LoopyTacoi+1)
{
{
LoopyTacoret = LoopyTacoa[LoopyTacoi];
System.out.println(LoopyTacoret);
}
}
return LoopyTacoret;
}

}

