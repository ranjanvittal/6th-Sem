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

public int LoopyTacoComputeFac(int LoopyTaconum){
LoopyTacoFac a;
int LoopyTacoi;
int LoopyTacoj;
int LoopyTacok;
int LoopyTacosum;
int LoopyTacosum2;
int[] LoopyTacoa;
int[] LoopyTacob;
int[] LoopyTacoc;
int LoopyTacokk;
int LoopyTacom;
int LoopyTacoret;
int temp0;
int temp1;
int temp2;
int temp3;
int temp4;
int temp5;
boolean t0;
boolean t1;
a = this;
LoopyTacoret = 0;
LoopyTacom = LoopyTaconum+LoopyTaconum;
LoopyTacoa = new int[LoopyTacom];
LoopyTacob = new int[LoopyTacom];
LoopyTacoc = new int[LoopyTacom];
LoopyTacok = 4;
LoopyTacosum = 0;
LoopyTacoj = 0;
t0 = LoopyTacoj<LoopyTaconum;
if(t0)
{
LoopyTacok = 5;
for(LoopyTacoj=0;LoopyTacoj<LoopyTaconum;LoopyTacoj = LoopyTacoj+1)
{
LoopyTacosum = LoopyTacosum+LoopyTacoj;
}
}
else
{
}
LoopyTacoi = 0;
t1 = LoopyTacoi<LoopyTaconum;
if(t1)
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
/*LOOPDISTRIBUTE*/
for(LoopyTacoj=1;LoopyTacoj<LoopyTaconum;LoopyTacoj = LoopyTacoj+1)
{
LoopyTacoa[LoopyTacoj] = LoopyTacoj;
LoopyTacok = LoopyTacoj-1;
LoopyTacokk = LoopyTacoa[LoopyTacok];
LoopyTacob[LoopyTacoj] = LoopyTacokk;
}
/*LOOPDISTRIBUTE*/
for(LoopyTacoj=0;LoopyTacoj<LoopyTaconum;LoopyTacoj = LoopyTacoj+1)
{
LoopyTacoa[LoopyTacoj] = LoopyTacoj;
LoopyTacok = LoopyTacoj+1;
LoopyTacokk = LoopyTacoa[LoopyTacok];
LoopyTacob[LoopyTacoj] = LoopyTacokk;
}
temp1 = 16;
temp2 = 4;
temp0 = a.divide(temp1, temp2);
temp0 = temp0*4;
for(LoopyTacoj=0;LoopyTacoj<temp0;LoopyTacoj = LoopyTacoj)
{
{
LoopyTacoa[LoopyTacoi] = LoopyTacoj;
LoopyTacosum = LoopyTacosum+LoopyTacoj;
}
LoopyTacoj = LoopyTacoj+1;
{
LoopyTacoa[LoopyTacoi] = LoopyTacoj;
LoopyTacosum = LoopyTacosum+LoopyTacoj;
}
LoopyTacoj = LoopyTacoj+1;
{
LoopyTacoa[LoopyTacoi] = LoopyTacoj;
LoopyTacosum = LoopyTacosum+LoopyTacoj;
}
LoopyTacoj = LoopyTacoj+1;
{
LoopyTacoa[LoopyTacoi] = LoopyTacoj;
LoopyTacosum = LoopyTacosum+LoopyTacoj;
}
LoopyTacoj = LoopyTacoj+1;
}
for(LoopyTacoj=LoopyTacoj;LoopyTacoj<16;LoopyTacoj = LoopyTacoj+1)
{
{
LoopyTacoa[LoopyTacoi] = LoopyTacoj;
LoopyTacosum = LoopyTacosum+LoopyTacoj;
}
}
/*LOOPTILE 4 4 */
for(LoopyTacoi=0;LoopyTacoi<64;LoopyTacoi = LoopyTacoi+1)
for(LoopyTacoj=0;LoopyTacoj<64;LoopyTacoj = LoopyTacoj+1)
{
LoopyTacok = LoopyTacoi+LoopyTacoj;
LoopyTacokk = LoopyTacoa[LoopyTacok];
LoopyTacoa[LoopyTacoi] = LoopyTacokk;
}
temp4 = 12;
temp5 = 4;
temp3 = a.divide(temp4, temp5);
temp3 = temp3*4;
for(LoopyTacoi=0;LoopyTacoi<temp3;LoopyTacoi = LoopyTacoi)
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
for(LoopyTacoi=LoopyTacoi;LoopyTacoi<12;LoopyTacoi = LoopyTacoi+1)
{
{
LoopyTacoret = LoopyTacoa[LoopyTacoi];
System.out.println(LoopyTacoret);
}
}
/*LOOPDISTRIBUTE*/
for(LoopyTacoj=0;LoopyTacoj<LoopyTaconum;LoopyTacoj = LoopyTacoj+1)
{
System.out.println(LoopyTacoj);
LoopyTacoret = LoopyTacoa[LoopyTacoj];
System.out.println(LoopyTacoret);
}
return LoopyTacoret;
}

}

