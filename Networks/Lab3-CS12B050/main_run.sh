g++ udpclient.cpp -o udpclient;
g++ udpserver.cpp -o udpserver;
python gen_sh.py > run2.sh;
bash run2.sh;
rm run2.sh;
