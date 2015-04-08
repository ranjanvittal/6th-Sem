class FunctionInliningHa{
    public static void main(String[] a){
    	int i1;
    	c99 o1;
    	o1=new c99();
    	/* INLINE */
    	i1=o1.f1();
        System.out.println(i1);
    }
}
class c1{
	public int f2(){
		int i2;
		i2=2;
		return i2;	
	}
}class c2 extends c1{
	
}class c3 extends c2{
	
}class c4 extends c3{
	
}class c5 extends c4{
	
}class c6 extends c5{
	public int f4(){
		int i4;
		i4=4;
		return i4;	
	}	
}class c7 extends c6{
	
}class c8 extends c7{
	
}class c9 extends c8{
	
}class c10 extends c9{
	
}class c11 extends c10{
	
}class c12 extends c11{
	
}class c13 extends c12{
	
}class c14 extends c13{
	
}class c15 extends c14{
	
}class c16 extends c15{
	
}class c17 extends c16{
	
}class c18 extends c17{
	
}class c19 extends c18{
	
}class c20 extends c19{
	
}class c21 extends c20{
	
}class c22 extends c21{
	
}class c23 extends c22{
	
}class c24 extends c23{
	
}class c25 extends c24{
	
}class c26 extends c25{
	
}class c27 extends c26{
	
}class c28 extends c27{
	
}class c29 extends c28{
	
}class c30 extends c29{
	
}class c31 extends c30{
	
}class c32 extends c31{
	
}class c33 extends c32{
	public int f3(){
		int i3;
		i3=3;
		return i3;
	}	
}class c34 extends c33{
	
}class c35 extends c34{
	
}class c36 extends c35{
	
}class c37 extends c36{
	
}class c38 extends c37{
	
}class c39 extends c38{
	
}class c40 extends c39{
	
}class c41 extends c40{
	
}class c42 extends c41{
	
}class c43 extends c42{
	
}class c44 extends c43{
	
}class c45 extends c44{
	
}class c46 extends c45{
	
}class c47 extends c46{
	
}class c48 extends c47{
	
}class c49 extends c48{
	
}class c50 extends c49{
	
}class c51 extends c50{
	
}class c52 extends c51{
	
}class c53 extends c52{
	
}class c54 extends c53{
	
}class c55 extends c54{
	
}class c56 extends c55{
	
}class c57 extends c56{
	
}class c58 extends c57{
	
}class c59 extends c58{
	
}class c60 extends c59{
	
}class c61 extends c60{
	
}class c62 extends c61{
	
}class c63 extends c62{
	
}class c64 extends c63{
	
}class c65 extends c64{
	
}class c66 extends c65{
	
}class c67 extends c66{
	
}class c68 extends c67{
	
}class c69 extends c68{
	
}class c70 extends c69{
	
}class c71 extends c70{
	
}class c72 extends c71{
	
}class c73 extends c72{
	
}class c74 extends c73{
	
}class c75 extends c74{
	
}class c76 extends c75{
	
}class c77 extends c76{
	
}class c78 extends c77{
	
}class c79 extends c78{
	
}class c80 extends c79{
	
}class c81 extends c80{
	
}class c82 extends c81{
	
}class c83 extends c82{
	
}class c84 extends c83{
	
}class c85 extends c84{
	
}class c86 extends c85{
	
}class c87 extends c86{
	
}class c88 extends c87{
	
}class c89 extends c88{
	
}class c90 extends c89{
	
}class c91 extends c90{
	
}class c92 extends c91{
	
}class c93 extends c92{
	
}class c94 extends c93{
	
}class c95 extends c94{
	
}class c96 extends c95{
	
}class c97 extends c96{
	
}class c98 extends c97{
	
}class c99 extends c98{
public int f1(){
	c25 o1;
	c50 o2;
	c75 o3;
	c98 o4;
	c29 o5;
	c54 o6;
	c6 o7;
	c100 o8;
	int i1;
	int i2;
	int i3;
	int i4;
	int i5;
	int i6;
	int i7;
	int i8;
	o1=new c25();
	o2=new c50();
	o3=new c75();
	o4=new c98();
	o5=new c29();
	o6=new c54();
	o7=new c6();
	o8=new c100();
	/* INLINE */
	i1=o1.f2();
	/* INLINE */
	i2=o2.f3();
	/* INLINE */
	i3=o3.f2();
	/* INLINE */
	i4=o4.f4();
	/* INLINE */
	i5=o5.f2();
	/* INLINE */
	i6=o6.f3();
	/* INLINE */
	i7=o7.f2();
	/* INLINE */
	i8=o8.f4();
	i1=i1+i2;
	i3=i3-i4;
	i1=i1+i3;
	i5=i5-i6;
	i7=i7+i8;
	i5=i5+i7;
	i1=i1-i5;
	return i1;
}	
}class c100 extends c99{
	
}
