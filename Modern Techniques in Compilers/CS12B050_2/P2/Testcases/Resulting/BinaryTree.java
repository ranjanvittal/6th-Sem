class BinaryTree
{
 public static void main ( String [] Tacoa)
{
TacoBT temp0;
int temp1;
temp0 =  new TacoBT();
temp1 = temp0.TacoStart();
System.out.println(temp1);

}
}

class TacoBT
{
public int TacoStart()
{
TacoTree Tacoroot;
boolean Tacontb;
int Taconti;
TacoTree temp2;
int temp3;
boolean temp4;
boolean temp5;
int temp6;
int temp7;
boolean temp8;
boolean temp9;
int temp10;
boolean temp11;
int temp12;
boolean temp13;
int temp14;
boolean temp15;
int temp16;
boolean temp17;
int temp18;
boolean temp19;
int temp20;
boolean temp21;
boolean temp22;
int temp23;
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
boolean temp34;
boolean temp35;
int temp36;
int temp37;
int temp38;
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
temp9 = Tacoroot.TacoPrint();
Tacontb = temp9;
temp10 = 24;
temp11 = Tacoroot.TacoInsert(temp10);
Tacontb = temp11;
temp12 = 4;
temp13 = Tacoroot.TacoInsert(temp12);
Tacontb = temp13;
temp14 = 12;
temp15 = Tacoroot.TacoInsert(temp14);
Tacontb = temp15;
temp16 = 20;
temp17 = Tacoroot.TacoInsert(temp16);
Tacontb = temp17;
temp18 = 28;
temp19 = Tacoroot.TacoInsert(temp18);
Tacontb = temp19;
temp20 = 14;
temp21 = Tacoroot.TacoInsert(temp20);
Tacontb = temp21;
temp22 = Tacoroot.TacoPrint();
Tacontb = temp22;
temp23 = 24;
temp24 = Tacoroot.TacoSearch(temp23);
System.out.println(temp24);
temp25 = 12;
temp26 = Tacoroot.TacoSearch(temp25);
System.out.println(temp26);
temp27 = 16;
temp28 = Tacoroot.TacoSearch(temp27);
System.out.println(temp28);
temp29 = 50;
temp30 = Tacoroot.TacoSearch(temp29);
System.out.println(temp30);
temp31 = 12;
temp32 = Tacoroot.TacoSearch(temp31);
System.out.println(temp32);
temp33 = 12;
temp34 = Tacoroot.TacoDelete(temp33);
Tacontb = temp34;
temp35 = Tacoroot.TacoPrint();
Tacontb = temp35;
temp36 = 12;
temp37 = Tacoroot.TacoSearch(temp36);
System.out.println(temp37);
temp38 = 0;

return temp38;
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
boolean temp39;
boolean temp40;
boolean temp41;
Tacokey = Tacov_key;
temp39 = false;
Tacohas_left = temp39;
temp40 = false;
Tacohas_right = temp40;
temp41 = true;

return temp41;
}
public boolean TacoSetRight(TacoTree Tacorn)
{
boolean temp42;
Tacoright = Tacorn;
temp42 = true;

return temp42;
}
public boolean TacoSetLeft(TacoTree Tacoln)
{
boolean temp43;
Tacoleft = Tacoln;
temp43 = true;

return temp43;
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
boolean temp44;
Tacokey = Tacov_key;
temp44 = true;

return temp44;
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
boolean temp45;
Tacohas_left = Tacoval;
temp45 = true;

return temp45;
}
public boolean TacoSetHas_Right(boolean Tacoval)
{
boolean temp46;
Tacohas_right = Tacoval;
temp46 = true;

return temp46;
}
public boolean TacoCompare(int Taconum1, int Taconum2)
{
boolean Tacontb;
int Taconti;
boolean temp47;
int temp48;
int temp49;
boolean temp50;
boolean temp51;
boolean temp52;
boolean temp53;
boolean temp54;
boolean temp55;
temp47 = false;
Tacontb = temp47;
temp48 = 1;
temp49 = Taconum2+temp48;
Taconti = temp49;
temp50 = Taconum1<Taconum2;
if(temp50)
{
temp51 = false;
Tacontb = temp51;
}
else
{
temp52 = Taconum1<Taconti;
temp53 = !temp52;
if(temp53)
{
temp54 = false;
Tacontb = temp54;
}
else
{
temp55 = true;
Tacontb = temp55;
}
}

return Tacontb;
}
public boolean TacoInsert(int Tacov_key)
{
TacoTree Taconew_node;
boolean Tacontb;
boolean Tacocont;
int Tacokey_aux;
TacoTree Tacocurrent_node;
TacoTree temp56;
boolean temp57;
TacoTree temp58;
boolean temp59;
int temp60;
boolean temp61;
boolean temp62;
TacoTree temp63;
boolean temp64;
boolean temp65;
boolean temp66;
boolean temp67;
boolean temp68;
TacoTree temp69;
boolean temp70;
boolean temp71;
boolean temp72;
boolean temp73;
boolean temp74;
temp56 =  new TacoTree();
Taconew_node = temp56;
temp57 = Taconew_node.TacoInit(Tacov_key);
Tacontb = temp57;
temp58 = this;
Tacocurrent_node = temp58;
temp59 = true;
Tacocont = temp59;
while(Tacocont)
{
{
temp60 = Tacocurrent_node.TacoGetKey();
Tacokey_aux = temp60;
temp61 = Tacov_key<Tacokey_aux;
if(temp61)
{
{
temp62 = Tacocurrent_node.TacoGetHas_Left();
if(temp62)
{
temp63 = Tacocurrent_node.TacoGetLeft();
Tacocurrent_node = temp63;
}
else
{
{
temp64 = false;
Tacocont = temp64;
temp65 = true;
temp66 = Tacocurrent_node.TacoSetHas_Left(temp65);
Tacontb = temp66;
temp67 = Tacocurrent_node.TacoSetLeft(Taconew_node);
Tacontb = temp67;

}
}

}
}
else
{
{
temp68 = Tacocurrent_node.TacoGetHas_Right();
if(temp68)
{
temp69 = Tacocurrent_node.TacoGetRight();
Tacocurrent_node = temp69;
}
else
{
{
temp70 = false;
Tacocont = temp70;
temp71 = true;
temp72 = Tacocurrent_node.TacoSetHas_Right(temp71);
Tacontb = temp72;
temp73 = Tacocurrent_node.TacoSetRight(Taconew_node);
Tacontb = temp73;

}
}

}
}

}
Tacocont = Tacocont;

}
temp74 = true;

return temp74;
}
public boolean TacoDelete(int Tacov_key)
{
TacoTree Tacocurrent_node;
TacoTree Tacoparent_node;
boolean Tacocont;
boolean Tacofound;
boolean Tacois_root;
int Tacokey_aux;
boolean Tacontb;
TacoTree temp75;
TacoTree temp76;
boolean temp77;
boolean temp78;
boolean temp79;
int temp80;
boolean temp81;
boolean temp82;
TacoTree temp83;
boolean temp84;
boolean temp85;
boolean temp86;
TacoTree temp87;
boolean temp88;
boolean temp89;
boolean temp90;
boolean temp91;
boolean temp92;
boolean temp93;
boolean temp94;
TacoTree temp95;
boolean temp96;
TacoTree temp97;
boolean temp98;
boolean temp99;
boolean temp100;
boolean temp101;
temp75 = this;
Tacocurrent_node = temp75;
temp76 = this;
Tacoparent_node = temp76;
temp77 = true;
Tacocont = temp77;
temp78 = false;
Tacofound = temp78;
temp79 = true;
Tacois_root = temp79;
while(Tacocont)
{
{
temp80 = Tacocurrent_node.TacoGetKey();
Tacokey_aux = temp80;
temp81 = Tacov_key<Tacokey_aux;
if(temp81)
{
temp82 = Tacocurrent_node.TacoGetHas_Left();
if(temp82)
{
{
Tacoparent_node = Tacocurrent_node;
temp83 = Tacocurrent_node.TacoGetLeft();
Tacocurrent_node = temp83;

}
}
else
{
temp84 = false;
Tacocont = temp84;
}
}
else
{
temp85 = Tacokey_aux<Tacov_key;
if(temp85)
{
temp86 = Tacocurrent_node.TacoGetHas_Right();
if(temp86)
{
{
Tacoparent_node = Tacocurrent_node;
temp87 = Tacocurrent_node.TacoGetRight();
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
{
if(Tacois_root)
{
temp89 = Tacocurrent_node.TacoGetHas_Right();
temp90 = !temp89;
temp91 = Tacocurrent_node.TacoGetHas_Left();
temp92 = !temp91;
temp93 = temp90&temp92;
if(temp93)
{
temp94 = true;
Tacontb = temp94;
}
else
{
temp95 = this;
temp96 = temp95.TacoRemove(Tacoparent_node, Tacocurrent_node);
Tacontb = temp96;
}
}
else
{
temp97 = this;
temp98 = temp97.TacoRemove(Tacoparent_node, Tacocurrent_node);
Tacontb = temp98;
}
temp99 = true;
Tacofound = temp99;
temp100 = false;
Tacocont = temp100;

}
}
}
temp101 = false;
Tacois_root = temp101;

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
boolean temp102;
TacoTree temp103;
boolean temp104;
boolean temp105;
TacoTree temp106;
boolean temp107;
int temp108;
TacoTree temp109;
int temp110;
TacoTree temp111;
boolean temp112;
boolean temp113;
boolean temp114;
boolean temp115;
boolean temp116;
boolean temp117;
boolean temp118;
boolean temp119;
temp102 = Tacoc_node.TacoGetHas_Left();
if(temp102)
{
temp103 = this;
temp104 = temp103.TacoRemoveLeft(Tacop_node, Tacoc_node);
Tacontb = temp104;
}
else
{
temp105 = Tacoc_node.TacoGetHas_Right();
if(temp105)
{
temp106 = this;
temp107 = temp106.TacoRemoveRight(Tacop_node, Tacoc_node);
Tacontb = temp107;
}
else
{
{
temp108 = Tacoc_node.TacoGetKey();
Tacoauxkey1 = temp108;
temp109 = Tacop_node.TacoGetLeft();
temp110 = temp109.TacoGetKey();
Tacoauxkey2 = temp110;
temp111 = this;
temp112 = temp111.TacoCompare(Tacoauxkey1, Tacoauxkey2);
if(temp112)
{
{
temp113 = Tacop_node.TacoSetLeft(Tacomy_null);
Tacontb = temp113;
temp114 = false;
temp115 = Tacop_node.TacoSetHas_Left(temp114);
Tacontb = temp115;

}
}
else
{
{
temp116 = Tacop_node.TacoSetRight(Tacomy_null);
Tacontb = temp116;
temp117 = false;
temp118 = Tacop_node.TacoSetHas_Right(temp117);
Tacontb = temp118;

}
}

}
}
}
temp119 = true;

return temp119;
}
public boolean TacoRemoveRight(TacoTree Tacop_node, TacoTree Tacoc_node)
{
boolean Tacontb;
boolean temp120;
TacoTree temp121;
int temp122;
boolean temp123;
TacoTree temp124;
boolean temp125;
boolean temp126;
boolean temp127;
boolean temp128;
boolean temp129;
temp120 = Tacoc_node.TacoGetHas_Right();
while(temp120)
{
{
temp121 = Tacoc_node.TacoGetRight();
temp122 = temp121.TacoGetKey();
temp123 = Tacoc_node.TacoSetKey(temp122);
Tacontb = temp123;
Tacop_node = Tacoc_node;
temp124 = Tacoc_node.TacoGetRight();
Tacoc_node = temp124;

}
temp125 = Tacoc_node.TacoGetHas_Right();
temp120 = temp125;

}
temp126 = Tacop_node.TacoSetRight(Tacomy_null);
Tacontb = temp126;
temp127 = false;
temp128 = Tacop_node.TacoSetHas_Right(temp127);
Tacontb = temp128;
temp129 = true;

return temp129;
}
public boolean TacoRemoveLeft(TacoTree Tacop_node, TacoTree Tacoc_node)
{
boolean Tacontb;
boolean temp130;
TacoTree temp131;
int temp132;
boolean temp133;
TacoTree temp134;
boolean temp135;
boolean temp136;
boolean temp137;
boolean temp138;
boolean temp139;
temp130 = Tacoc_node.TacoGetHas_Left();
while(temp130)
{
{
temp131 = Tacoc_node.TacoGetLeft();
temp132 = temp131.TacoGetKey();
temp133 = Tacoc_node.TacoSetKey(temp132);
Tacontb = temp133;
Tacop_node = Tacoc_node;
temp134 = Tacoc_node.TacoGetLeft();
Tacoc_node = temp134;

}
temp135 = Tacoc_node.TacoGetHas_Left();
temp130 = temp135;

}
temp136 = Tacop_node.TacoSetLeft(Tacomy_null);
Tacontb = temp136;
temp137 = false;
temp138 = Tacop_node.TacoSetHas_Left(temp137);
Tacontb = temp138;
temp139 = true;

return temp139;
}
public int TacoSearch(int Tacov_key)
{
boolean Tacocont;
int Tacoifound;
TacoTree Tacocurrent_node;
int Tacokey_aux;
TacoTree temp140;
boolean temp141;
int temp142;
int temp143;
boolean temp144;
boolean temp145;
TacoTree temp146;
boolean temp147;
boolean temp148;
boolean temp149;
TacoTree temp150;
boolean temp151;
int temp152;
boolean temp153;
temp140 = this;
Tacocurrent_node = temp140;
temp141 = true;
Tacocont = temp141;
temp142 = 0;
Tacoifound = temp142;
while(Tacocont)
{
{
temp143 = Tacocurrent_node.TacoGetKey();
Tacokey_aux = temp143;
temp144 = Tacov_key<Tacokey_aux;
if(temp144)
{
temp145 = Tacocurrent_node.TacoGetHas_Left();
if(temp145)
{
temp146 = Tacocurrent_node.TacoGetLeft();
Tacocurrent_node = temp146;
}
else
{
temp147 = false;
Tacocont = temp147;
}
}
else
{
temp148 = Tacokey_aux<Tacov_key;
if(temp148)
{
temp149 = Tacocurrent_node.TacoGetHas_Right();
if(temp149)
{
temp150 = Tacocurrent_node.TacoGetRight();
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
{
temp152 = 1;
Tacoifound = temp152;
temp153 = false;
Tacocont = temp153;

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
TacoTree Tacocurrent_node;
boolean Tacontb;
TacoTree temp154;
TacoTree temp155;
boolean temp156;
boolean temp157;
temp154 = this;
Tacocurrent_node = temp154;
temp155 = this;
temp156 = temp155.TacoRecPrint(Tacocurrent_node);
Tacontb = temp156;
temp157 = true;

return temp157;
}
public boolean TacoRecPrint(TacoTree Taconode)
{
boolean Tacontb;
boolean temp158;
TacoTree temp159;
TacoTree temp160;
boolean temp161;
boolean temp162;
int temp163;
boolean temp164;
TacoTree temp165;
TacoTree temp166;
boolean temp167;
boolean temp168;
boolean temp169;
temp158 = Taconode.TacoGetHas_Left();
if(temp158)
{
{
temp159 = this;
temp160 = Taconode.TacoGetLeft();
temp161 = temp159.TacoRecPrint(temp160);
Tacontb = temp161;

}
}
else
{
temp162 = true;
Tacontb = temp162;
}
temp163 = Taconode.TacoGetKey();
System.out.println(temp163);
temp164 = Taconode.TacoGetHas_Right();
if(temp164)
{
{
temp165 = this;
temp166 = Taconode.TacoGetRight();
temp167 = temp165.TacoRecPrint(temp166);
Tacontb = temp167;

}
}
else
{
temp168 = true;
Tacontb = temp168;
}
temp169 = true;

return temp169;
}

}


