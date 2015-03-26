for i in testcases/*.java;
do
#echo $i;
        j=`echo $i | sed 's/\([^\/]*\/\)\(.*\)/\2/'`;
        java P3 < $i > testcases/resulting/`echo $j`;
done
cd testcases;
for i in *.java;
do
        j=`echo $i | sed 's/\([^\/]*\/\)\(.*\)/\2/'`;
        javac $i;
        #echo $j;
done
cd resulting;
for i in *.java;
do
        j=`echo $i | sed 's/\([^\/]*\/\)\(.*\)/\2/'`;
        javac $i;
        #echo $j;
done

cd ../;
for i in *.java;
do
        j=`echo $i | sed 's/\([^\/]*\/\)\(.*\)/\2/'`;
        class=`echo $j | sed 's/\([^\.]*\)\(.java\)/\1/'`;

        java $class > tmpoutput;
        echo $j;
        cd resulting;
        java $class > ../tmpoutput2
        cd ..;
        diff tmpoutput2 tmpoutput > /dev/null;
        if [ $? -eq 0 ]
                then
                echo "Successful"
                else
                echo "Failed"
                break
        fi
        rm tmpoutput tmpoutput2
done
rm *.class;
cd resulting;
rm *.class;
cd ../../taco2/;
javac Main.java;
for i in ../testcases/resulting/*.java;
do
        j=`echo $i | sed 's/\([^\/]*\/\)\(.*\)/\2/'`;
        echo $j;
        java Main < $i;
done
