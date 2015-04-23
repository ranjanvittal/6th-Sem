# scp -P 35642 infile.txt cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/infile.txt
# scp -P 35643 infile.txt cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/infile.txt
# scp -P 35644 infile.txt cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/infile.txt
# scp -P 35645 infile.txt cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/infile.txt
# scp -P 35646 infile.txt cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/infile.txt
# scp -P 35647 infile.txt cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/infile.txt
# scp -P 35648 infile.txt cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/infile.txt

scp -P 35642 ospf_geni.cpp cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/ospf_geni.cpp
scp -P 35643 ospf_geni.cpp cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/ospf_geni.cpp
scp -P 35644 ospf_geni.cpp cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/ospf_geni.cpp
scp -P 35645 ospf_geni.cpp cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/ospf_geni.cpp
scp -P 35646 ospf_geni.cpp cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/ospf_geni.cpp
scp -P 35647 ospf_geni.cpp cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/ospf_geni.cpp
scp -P 35648 ospf_geni.cpp cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/ospf_geni.cpp

ssh cs12b050@pc5.lan.sdn.uky.edu -p 35642 "g++ ospf_geni.cpp -o ospf_geni -pthread;./ospf_geni -f infile.txt -o out_mohan -i 0 > out_mohan0.txt" &
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35643 "g++ ospf_geni.cpp -o ospf_geni -pthread;./ospf_geni -f infile.txt -o out_mohan -i 1 > out_mohan1.txt" &
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35644 "g++ ospf_geni.cpp -o ospf_geni -pthread;./ospf_geni -f infile.txt -o out_mohan -i 2 > out_mohan2.txt" &
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35645 "g++ ospf_geni.cpp -o ospf_geni -pthread;./ospf_geni -f infile.txt -o out_mohan -i 3 > out_mohan3.txt" &
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35646 "g++ ospf_geni.cpp -o ospf_geni -pthread;./ospf_geni -f infile.txt -o out_mohan -i 4 > out_mohan4.txt" &
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35647 "g++ ospf_geni.cpp -o ospf_geni -pthread;./ospf_geni -f infile.txt -o out_mohan -i 5 > out_mohan5.txt" &
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35648 "g++ ospf_geni.cpp -o ospf_geni -pthread;./ospf_geni -f infile.txt -o out_mohan -i 6 > out_mohan6.txt" &
sleep 300
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35642 "pkill ospf_geni"
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35643 "pkill ospf_geni"
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35644 "pkill ospf_geni"
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35645 "pkill ospf_geni"
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35646 "pkill ospf_geni"
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35647 "pkill ospf_geni"
ssh cs12b050@pc5.lan.sdn.uky.edu -p 35648 "pkill ospf_geni"
scp -P 35642 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out_mohan-0.txt out_mohan-0.txt
scp -P 35643 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out_mohan-1.txt out_mohan-1.txt
scp -P 35644 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out_mohan-2.txt out_mohan-2.txt
scp -P 35645 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out_mohan-3.txt out_mohan-3.txt
scp -P 35646 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out_mohan-4.txt out_mohan-4.txt
scp -P 35647 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out_mohan-5.txt out_mohan-5.txt
scp -P 35648 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out_mohan-6.txt out_mohan-6.txt
scp -P 35642 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out_mohan0.txt out_mohan0.txt
scp -P 35643 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out_mohan1.txt out_mohan1.txt
scp -P 35644 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out_mohan2.txt out_mohan2.txt
scp -P 35645 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out_mohan3.txt out_mohan3.txt
scp -P 35646 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out_mohan4.txt out_mohan4.txt
scp -P 35647 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out_mohan5.txt out_mohan5.txt
scp -P 35648 cs12b050@pc5.lan.sdn.uky.edu:/users/cs12b050/out_mohan6.txt out_mohan6.txt
