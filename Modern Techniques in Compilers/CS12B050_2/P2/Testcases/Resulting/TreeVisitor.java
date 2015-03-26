class TreeVisitor
{
 public static void main ( String [] Tacoa)
{
TacoTV temp0;
int temp1;
temp0 =  new TacoTV();
temp1 = temp0.TacoStart();
System.out.println(temp1);

}
}

class TacoTV
{
public int TacoStart()
{
TacoTree Tacoroot;
boolean Tacontb;
int Taconti;
TacoMyVisitor Tacov;
TacoTree temp2;
int temp3;
boolean temp4;
boolean temp5;
int temp6;
int temp7;
boolean temp8;
int temp9;
boolean temp10;
int temp11;
boolean temp12;
int temp13;
boolean temp14;
int temp15;
boolean temp16;
int temp17;
boolean temp18;
int temp19;
boolean temp20;
boolean temp21;
int temp22;
TacoMyVisitor temp23;
int temp24;
int temp25;
int temp26;
int temp27;
int temp28;
int temp29;
int temp30;
int temp31;
int temp32;
int temp33;
int temp34;
int temp35;
int temp36;
int temp37;
boolean temp38;
boolean temp39;
int temp40;
int temp41;
int temp42;
temp2 =  new TacoTree();
Tacoroot = temp2;
temp3 = 16;
temp4 = Tacoroot.TacoInit(temp3);
Tacontb = temp4;
temp5 = Tacoroot.TacoPrint();
Tacontb = temp5;
temp6 = 100000000;
System.out.println(temp6);
temp7 = 8;
temp8 = Tacoroot.TacoInsert(temp7);
Tacontb = temp8;
temp9 = 24;
temp10 = Tacoroot.TacoInsert(temp9);
Tacontb = temp10;
temp11 = 4;
temp12 = Tacoroot.TacoInsert(temp11);
Tacontb = temp12;
temp13 = 12;
temp14 = Tacoroot.TacoInsert(temp13);
Tacontb = temp14;
temp15 = 20;
temp16 = Tacoroot.TacoInsert(temp15);
Tacontb = temp16;
temp17 = 28;
temp18 = Tacoroot.TacoInsert(temp17);
Tacontb = temp18;
temp19 = 14;
temp20 = Tacoroot.TacoInsert(temp19);
Tacontb = temp20;
temp21 = Tacoroot.TacoPrint();
Tacontb = temp21;
temp22 = 100000000;
System.out.println(temp22);
temp23 =  new TacoMyVisitor();
Tacov = temp23;
temp24 = 50000000;
System.out.println(temp24);
temp25 = Tacoroot.Tacoaccept(Tacov);
Taconti = temp25;
temp26 = 100000000;
System.out.println(temp26);
temp27 = 24;
temp28 = Tacoroot.TacoSearch(temp27);
System.out.println(temp28);
temp29 = 12;
temp30 = Tacoroot.TacoSearch(temp29);
System.out.println(temp30);
temp31 = 16;
temp32 = Tacoroot.TacoSearch(temp31);
System.out.println(temp32);
temp33 = 50;
temp34 = Tacoroot.TacoSearch(temp33);
System.out.println(temp34);
temp35 = 12;
temp36 = Tacoroot.TacoSearch(temp35);
System.out.println(temp36);
temp37 = 12;
temp38 = Tacoroot.TacoDelete(temp37);
Tacontb = temp38;
temp39 = Tacoroot.TacoPrint();
Tacontb = temp39;
temp40 = 12;
temp41 = Tacoroot.TacoSearch(temp40);
System.out.println(temp41);
temp42 = 0;

return temp42;
}

}

class TacoTree
{
TacoTree Tacoleft;
TacoTree Tacoright;
int Tacokey;
boolean Tacohas_left;
boolean Tacohas_right;
TacoTree Tacomy_null;
public boolean TacoInit(int Tacov_key)
{
boolean temp43;
boolean temp44;
boolean temp45;
Tacokey = Tacov_key;
temp43 = false;
Tacohas_left = temp43;
temp44 = false;
Tacohas_right = temp44;
temp45 = true;

return temp45;
}
public boolean TacoSetRight(TacoTree Tacorn)
{
boolean temp46;
Tacoright = Tacorn;
temp46 = true;

return temp46;
}
public boolean TacoSetLeft(TacoTree Tacoln)
{
boolean temp47;
Tacoleft = Tacoln;
temp47 = true;

return temp47;
}
public TacoTree TacoGetRight()
{

return Tacoright;
}
public TacoTree TacoGetLeft()
{

return Tacoleft;
}
public int TacoGetKey()
{

return Tacokey;
}
public boolean TacoSetKey(int Tacov_key)
{
boolean temp48;
Tacokey = Tacov_key;
temp48 = true;

return temp48;
}
public boolean TacoGetHas_Right()
{

return Tacohas_right;
}
public boolean TacoGetHas_Left()
{

return Tacohas_left;
}
public boolean TacoSetHas_Left(boolean Tacoval)
{
boolean temp49;
Tacohas_left = Tacoval;
temp49 = true;

return temp49;
}
public boolean TacoSetHas_Right(boolean Tacoval)
{
boolean temp50;
Tacohas_right = Tacoval;
temp50 = true;

return temp50;
}
public boolean TacoCompare(int Taconum1, int Taconum2)
{
boolean Tacontb;
int Taconti;
boolean temp51;
int temp52;
int temp53;
boolean temp54;
boolean temp55;
boolean temp56;
boolean temp57;
boolean temp58;
boolean temp59;
temp51 = false;
Tacontb = temp51;
temp52 = 1;
temp53 = Taconum2+temp52;
Taconti = temp53;
temp54 = Taconum1<Taconum2;
if(temp54)
{
temp55 = false;
Tacontb = temp55;
}
else
{
temp56 = Taconum1<Taconti;
temp57 = !temp56;
if(temp57)
{
temp58 = false;
Tacontb = temp58;
}
else
{
temp59 = true;
Tacontb = temp59;
}
}

return Tacontb;
}
public boolean TacoInsert(int Tacov_key)
{
TacoTree Taconew_node;
boolean Tacontb;
TacoTree Tacocurrent_node;
boolean Tacocont;
int Tacokey_aux;
TacoTree temp60;
boolean temp61;
TacoTree temp62;
boolean temp63;
int temp64;
boolean temp65;
boolean temp66;
TacoTree temp67;
boolean temp68;
boolean temp69;
boolean temp70;
boolean temp71;
boolean temp72;
TacoTree temp73;
boolean temp74;
boolean temp75;
boolean temp76;
boolean temp77;
boolean temp78;
temp60 =  new TacoTree();
Taconew_node = temp60;
temp61 = Taconew_node.TacoInit(Tacov_key);
Tacontb = temp61;
temp62 = this;
Tacocurrent_node = temp62;
temp63 = true;
Tacocont = temp63;
while(Tacocont)
{
{
temp64 = Tacocurrent_node.TacoGetKey();
Tacokey_aux = temp64;
temp65 = Tacov_key<Tacokey_aux;
if(temp65)
{
{
temp66 = Tacocurrent_node.TacoGetHas_Left();
if(temp66)
{
temp67 = Tacocurrent_node.TacoGetLeft();
Tacocurrent_node = temp67;
}
else
{
{
temp68 = false;
Tacocont = temp68;
temp69 = true;
temp70 = Tacocurrent_node.TacoSetHas_Left(temp69);
Tacontb = temp70;
temp71 = Tacocurrent_node.TacoSetLeft(Taconew_node);
Tacontb = temp71;

}
}

}
}
else
{
{
temp72 = Tacocurrent_node.TacoGetHas_Right();
if(temp72)
{
temp73 = Tacocurrent_node.TacoGetRight();
Tacocurrent_node = temp73;
}
else
{
{
temp74 = false;
Tacocont = temp74;
temp75 = true;
temp76 = Tacocurrent_node.TacoSetHas_Right(temp75);
Tacontb = temp76;
temp77 = Tacocurrent_node.TacoSetRight(Taconew_node);
Tacontb = temp77;

}
}

}
}

}
Tacocont = Tacocont;

}
temp78 = true;

return temp78;
}
public boolean TacoDelete(int Tacov_key)
{
TacoTree Tacocurrent_node;
TacoTree Tacoparent_node;
boolean Tacocont;
boolean Tacofound;
boolean Tacontb;
boolean Tacois_root;
int Tacokey_aux;
TacoTree temp79;
TacoTree temp80;
boolean temp81;
boolean temp82;
boolean temp83;
int temp84;
boolean temp85;
boolean temp86;
TacoTree temp87;
boolean temp88;
boolean temp89;
boolean temp90;
TacoTree temp91;
boolean temp92;
boolean temp93;
boolean temp94;
boolean temp95;
boolean temp96;
boolean temp97;
boolean temp98;
TacoTree temp99;
boolean temp100;
TacoTree temp101;
boolean temp102;
boolean temp103;
boolean temp104;
boolean temp105;
temp79 = this;
Tacocurrent_node = temp79;
temp80 = this;
Tacoparent_node = temp80;
temp81 = true;
Tacocont = temp81;
temp82 = false;
Tacofound = temp82;
temp83 = true;
Tacois_root = temp83;
while(Tacocont)
{
{
temp84 = Tacocurrent_node.TacoGetKey();
Tacokey_aux = temp84;
temp85 = Tacov_key<Tacokey_aux;
if(temp85)
{
temp86 = Tacocurrent_node.TacoGetHas_Left();
if(temp86)
{
{
Tacoparent_node = Tacocurrent_node;
temp87 = Tacocurrent_node.TacoGetLeft();
Tacocurrent_node = temp87;

}
}
else
{
temp88 = false;
Tacocont = temp88;
}
}
else
{
temp89 = Tacokey_aux<Tacov_key;
if(temp89)
{
temp90 = Tacocurrent_node.TacoGetHas_Right();
if(temp90)
{
{
Tacoparent_node = Tacocurrent_node;
temp91 = Tacocurrent_node.TacoGetRight();
Tacocurrent_node = temp91;

}
}
else
{
temp92 = false;
Tacocont = temp92;
}
}
else
{
{
if(Tacois_root)
{
temp93 = Tacocurrent_node.TacoGetHas_Right();
temp94 = !temp93;
temp95 = Tacocurrent_node.TacoGetHas_Left();
temp96 = !temp95;
temp97 = temp94&temp96;
if(temp97)
{
temp98 = true;
Tacontb = temp98;
}
else
{
temp99 = this;
temp100 = temp99.TacoRemove(Tacoparent_node, Tacocurrent_node);
Tacontb = temp100;
}
}
else
{
temp101 = this;
temp102 = temp101.TacoRemove(Tacoparent_node, Tacocurrent_node);
Tacontb = temp102;
}
temp103 = true;
Tacofound = temp103;
temp104 = false;
Tacocont = temp104;

}
}
}
temp105 = false;
Tacois_root = temp105;

}
Tacocont = Tacocont;

}

return Tacofound;
}
public boolean TacoRemove(TacoTree Tacop_node, TacoTree Tacoc_node)
{
boolean Tacontb;
int Tacoauxkey1;
int Tacoauxkey2;
boolean temp106;
TacoTree temp107;
boolean temp108;
boolean temp109;
TacoTree temp110;
boolean temp111;
int temp112;
TacoTree temp113;
int temp114;
TacoTree temp115;
boolean temp116;
boolean temp117;
boolean temp118;
boolean temp119;
boolean temp120;
boolean temp121;
boolean temp122;
boolean temp123;
temp106 = Tacoc_node.TacoGetHas_Left();
if(temp106)
{
temp107 = this;
temp108 = temp107.TacoRemoveLeft(Tacop_node, Tacoc_node);
Tacontb = temp108;
}
else
{
temp109 = Tacoc_node.TacoGetHas_Right();
if(temp109)
{
temp110 = this;
temp111 = temp110.TacoRemoveRight(Tacop_node, Tacoc_node);
Tacontb = temp111;
}
else
{
{
temp112 = Tacoc_node.TacoGetKey();
Tacoauxkey1 = temp112;
temp113 = Tacop_node.TacoGetLeft();
temp114 = temp113.TacoGetKey();
Tacoauxkey2 = temp114;
temp115 = this;
temp116 = temp115.TacoCompare(Tacoauxkey1, Tacoauxkey2);
if(temp116)
{
{
temp117 = Tacop_node.TacoSetLeft(Tacomy_null);
Tacontb = temp117;
temp118 = false;
temp119 = Tacop_node.TacoSetHas_Left(temp118);
Tacontb = temp119;

}
}
else
{
{
temp120 = Tacop_node.TacoSetRight(Tacomy_null);
Tacontb = temp120;
temp121 = false;
temp122 = Tacop_node.TacoSetHas_Right(temp121);
Tacontb = temp122;

}
}

}
}
}
temp123 = true;

return temp123;
}
public boolean TacoRemoveRight(TacoTree Tacop_node, TacoTree Tacoc_node)
{
boolean Tacontb;
boolean temp124;
TacoTree temp125;
int temp126;
boolean temp127;
TacoTree temp128;
boolean temp129;
boolean temp130;
boolean temp131;
boolean temp132;
boolean temp133;
temp124 = Tacoc_node.TacoGetHas_Right();
while(temp124)
{
{
temp125 = Tacoc_node.TacoGetRight();
temp126 = temp125.TacoGetKey();
temp127 = Tacoc_node.TacoSetKey(temp126);
Tacontb = temp127;
Tacop_node = Tacoc_node;
temp128 = Tacoc_node.TacoGetRight();
Tacoc_node = temp128;

}
temp129 = Tacoc_node.TacoGetHas_Right();
temp124 = temp129;

}
temp130 = Tacop_node.TacoSetRight(Tacomy_null);
Tacontb = temp130;
temp131 = false;
temp132 = Tacop_node.TacoSetHas_Right(temp131);
Tacontb = temp132;
temp133 = true;

return temp133;
}
public boolean TacoRemoveLeft(TacoTree Tacop_node, TacoTree Tacoc_node)
{
boolean Tacontb;
boolean temp134;
TacoTree temp135;
int temp136;
boolean temp137;
TacoTree temp138;
boolean temp139;
boolean temp140;
boolean temp141;
boolean temp142;
boolean temp143;
temp134 = Tacoc_node.TacoGetHas_Left();
while(temp134)
{
{
temp135 = Tacoc_node.TacoGetLeft();
temp136 = temp135.TacoGetKey();
temp137 = Tacoc_node.TacoSetKey(temp136);
Tacontb = temp137;
Tacop_node = Tacoc_node;
temp138 = Tacoc_node.TacoGetLeft();
Tacoc_node = temp138;

}
temp139 = Tacoc_node.TacoGetHas_Left();
temp134 = temp139;

}
temp140 = Tacop_node.TacoSetLeft(Tacomy_null);
Tacontb = temp140;
temp141 = false;
temp142 = Tacop_node.TacoSetHas_Left(temp141);
Tacontb = temp142;
temp143 = true;

return temp143;
}
public int TacoSearch(int Tacov_key)
{
TacoTree Tacocurrent_node;
int Tacoifound;
boolean Tacocont;
int Tacokey_aux;
TacoTree temp144;
boolean temp145;
int temp146;
int temp147;
boolean temp148;
boolean temp149;
TacoTree temp150;
boolean temp151;
boolean temp152;
boolean temp153;
TacoTree temp154;
boolean temp155;
int temp156;
boolean temp157;
temp144 = this;
Tacocurrent_node = temp144;
temp145 = true;
Tacocont = temp145;
temp146 = 0;
Tacoifound = temp146;
while(Tacocont)
{
{
temp147 = Tacocurrent_node.TacoGetKey();
Tacokey_aux = temp147;
temp148 = Tacov_key<Tacokey_aux;
if(temp148)
{
temp149 = Tacocurrent_node.TacoGetHas_Left();
if(temp149)
{
temp150 = Tacocurrent_node.TacoGetLeft();
Tacocurrent_node = temp150;
}
else
{
temp151 = false;
Tacocont = temp151;
}
}
else
{
temp152 = Tacokey_aux<Tacov_key;
if(temp152)
{
temp153 = Tacocurrent_node.TacoGetHas_Right();
if(temp153)
{
temp154 = Tacocurrent_node.TacoGetRight();
Tacocurrent_node = temp154;
}
else
{
temp155 = false;
Tacocont = temp155;
}
}
else
{
{
temp156 = 1;
Tacoifound = temp156;
temp157 = false;
Tacocont = temp157;

}
}
}

}
Tacocont = Tacocont;

}

return Tacoifound;
}
public boolean TacoPrint()
{
boolean Tacontb;
TacoTree Tacocurrent_node;
TacoTree temp158;
TacoTree temp159;
boolean temp160;
boolean temp161;
temp158 = this;
Tacocurrent_node = temp158;
temp159 = this;
temp160 = temp159.TacoRecPrint(Tacocurrent_node);
Tacontb = temp160;
temp161 = true;

return temp161;
}
public boolean TacoRecPrint(TacoTree Taconode)
{
boolean Tacontb;
boolean temp162;
TacoTree temp163;
TacoTree temp164;
boolean temp165;
boolean temp166;
int temp167;
boolean temp168;
TacoTree temp169;
TacoTree temp170;
boolean temp171;
boolean temp172;
boolean temp173;
temp162 = Taconode.TacoGetHas_Left();
if(temp162)
{
{
temp163 = this;
temp164 = Taconode.TacoGetLeft();
temp165 = temp163.TacoRecPrint(temp164);
Tacontb = temp165;

}
}
else
{
temp166 = true;
Tacontb = temp166;
}
temp167 = Taconode.TacoGetKey();
System.out.println(temp167);
temp168 = Taconode.TacoGetHas_Right();
if(temp168)
{
{
temp169 = this;
temp170 = Taconode.TacoGetRight();
temp171 = temp169.TacoRecPrint(temp170);
Tacontb = temp171;

}
}
else
{
temp172 = true;
Tacontb = temp172;
}
temp173 = true;

return temp173;
}
public int Tacoaccept(TacoVisitor Tacov)
{
int Taconti;
int temp174;
TacoTree temp175;
int temp176;
int temp177;
temp174 = 333;
System.out.println(temp174);
temp175 = this;
temp176 = Tacov.Tacovisit(temp175);
Taconti = temp176;
temp177 = 0;

return temp177;
}

}

class TacoVisitor
{
TacoTree Tacol;
TacoTree Tacor;
public int Tacovisit(TacoTree Tacon)
{
int Taconti;
boolean temp178;
TacoTree temp179;
TacoVisitor temp180;
int temp181;
int temp182;
boolean temp183;
TacoTree temp184;
TacoVisitor temp185;
int temp186;
int temp187;
int temp188;
temp178 = Tacon.TacoGetHas_Right();
if(temp178)
{
{
temp179 = Tacon.TacoGetRight();
Tacor = temp179;
temp180 = this;
temp181 = Tacor.Tacoaccept(temp180);
Taconti = temp181;

}
}
else
{
temp182 = 0;
Taconti = temp182;
}
temp183 = Tacon.TacoGetHas_Left();
if(temp183)
{
{
temp184 = Tacon.TacoGetLeft();
Tacol = temp184;
temp185 = this;
temp186 = Tacol.Tacoaccept(temp185);
Taconti = temp186;

}
}
else
{
temp187 = 0;
Taconti = temp187;
}
temp188 = 0;

return temp188;
}

}

class TacoMyVisitor extends TacoVisitor
{
public int Tacovisit(TacoTree Tacon)
{
int Taconti;
boolean temp189;
TacoTree temp190;
TacoMyVisitor temp191;
int temp192;
int temp193;
int temp194;
boolean temp195;
TacoTree temp196;
TacoMyVisitor temp197;
int temp198;
int temp199;
int temp200;
temp189 = Tacon.TacoGetHas_Right();
if(temp189)
{
{
temp190 = Tacon.TacoGetRight();
Tacor = temp190;
temp191 = this;
temp192 = Tacor.Tacoaccept(temp191);
Taconti = temp192;

}
}
else
{
temp193 = 0;
Taconti = temp193;
}
temp194 = Tacon.TacoGetKey();
System.out.println(temp194);
temp195 = Tacon.TacoGetHas_Left();
if(temp195)
{
{
temp196 = Tacon.TacoGetLeft();
Tacol = temp196;
temp197 = this;
temp198 = Tacol.Tacoaccept(temp197);
Taconti = temp198;

}
}
else
{
temp199 = 0;
Taconti = temp199;
}
temp200 = 0;

return temp200;
}

}


