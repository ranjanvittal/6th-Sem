
./ospf -f infile.txt -o out -i 0 > out0.txt &
./ospf -f infile.txt -o out -i 1 > out1.txt &
./ospf -f infile.txt -o out -i 2 > out2.txt &
./ospf -f infile.txt -o out -i 3 > out3.txt &
./ospf -f infile.txt -o out -i 4 > out4.txt &
./ospf -f infile.txt -o out -i 5 > out5.txt &
./ospf -f infile.txt -o out -i 6 > out6.txt &
./ospf -f infile.txt -o out -i 7 > out7.txt

#scp -P 35642 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out-0.txt out-0.txt
#scp -P 35643 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out-1.txt out-1.txt
#scp -P 35644 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out-2.txt out-2.txt
#scp -P 35645 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out-3.txt out-3.txt
#scp -P 35646 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out-4.txt out-4.txt
#scp -P 35647 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out-5.txt out-5.txt
#scp -P 35648 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out-6.txt out-6.txt
# scp -P 35642 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out0.txt out0.txt
# scp -P 35643 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out1.txt out1.txt
# scp -P 35644 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out2.txt out2.txt
# scp -P 35645 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out3.txt out3.txt
# scp -P 35646 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out4.txt out4.txt
# scp -P 35647 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out5.txt out5.txt
# scp -P 35648 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out6.txt out6.txt
