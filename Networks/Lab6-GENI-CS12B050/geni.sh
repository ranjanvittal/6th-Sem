# scp -P 35642 infile.txt cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/infile.txt
# scp -P 35643 infile.txt cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/infile.txt
# scp -P 35644 infile.txt cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/infile.txt
# scp -P 35645 infile.txt cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/infile.txt
# scp -P 35646 infile.txt cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/infile.txt
# scp -P 35647 infile.txt cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/infile.txt
# scp -P 35648 infile.txt cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/infile.txt

scp -P 35642 ospf.cpp cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/ospf.cpp
scp -P 35643 ospf.cpp cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/ospf.cpp
scp -P 35644 ospf.cpp cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/ospf.cpp
scp -P 35645 ospf.cpp cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/ospf.cpp
scp -P 35646 ospf.cpp cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/ospf.cpp
scp -P 35647 ospf.cpp cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/ospf.cpp
scp -P 35648 ospf.cpp cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/ospf.cpp

ssh cs12b050@pc5.lan.sdn.uky.edu -p 35642 "g++ ospf.cpp -o ospf -pthread;./ospf -f infile.txt -o out -i 0 > out0.txt" &
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35643 "g++ ospf.cpp -o ospf -pthread;./ospf -f infile.txt -o out -i 1 > out1.txt" &
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35644 "g++ ospf.cpp -o ospf -pthread;./ospf -f infile.txt -o out -i 2 > out2.txt" &
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35645 "g++ ospf.cpp -o ospf -pthread;./ospf -f infile.txt -o out -i 3 > out3.txt" &
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35646 "g++ ospf.cpp -o ospf -pthread;./ospf -f infile.txt -o out -i 4 > out4.txt" &
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35647 "g++ ospf.cpp -o ospf -pthread;./ospf -f infile.txt -o out -i 5 > out5.txt" &
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35648 "g++ ospf.cpp -o ospf -pthread;./ospf -f infile.txt -o out -i 6 > out6.txt" &
sleep 350
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35642 "pkill ospf"
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35643 "pkill ospf"
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35644 "pkill ospf"
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35645 "pkill ospf"
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35646 "pkill ospf"
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35647 "pkill ospf"
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35648 "pkill ospf"
scp -P 35642 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out-0.txt out-0.txt
scp -P 35643 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out-1.txt out-1.txt
scp -P 35644 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out-2.txt out-2.txt
scp -P 35645 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out-3.txt out-3.txt
scp -P 35646 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out-4.txt out-4.txt
scp -P 35647 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out-5.txt out-5.txt
scp -P 35648 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out-6.txt out-6.txt
# scp -P 35642 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out0.txt out0.txt
# scp -P 35643 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out1.txt out1.txt
# scp -P 35644 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out2.txt out2.txt
# scp -P 35645 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out3.txt out3.txt
# scp -P 35646 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out4.txt out4.txt
# scp -P 35647 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out5.txt out5.txt
# scp -P 35648 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out6.txt out6.txt
