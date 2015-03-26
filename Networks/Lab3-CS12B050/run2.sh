./udpserver -p 12345 -N 2000 -e 0.001 -B 200 -n 8 -W 16 &
./udpclient -s localhost -p 12345 -L 256 -R 20 -N 2000 -W 16 -B 200 -n 8 > r1c.txt
wait

./udpserver -p 12345 -N 2000 -e 0.001 -B 200 -n 8 -W 16 &
./udpclient -s localhost -p 12345 -L 256 -R 300 -N 2000 -W 16 -B 200 -n 8 > r2c.txt
wait

./udpserver -p 12345 -N 2000 -e 0.001 -B 200 -n 8 -W 16 &
./udpclient -s localhost -p 12345 -L 1500 -R 20 -N 2000 -W 16 -B 200 -n 8 > r3c.txt
wait

./udpserver -p 12345 -N 2000 -e 0.001 -B 200 -n 8 -W 16 &
./udpclient -s localhost -p 12345 -L 1500 -R 300 -N 2000 -W 16 -B 200 -n 8 > r4c.txt
wait

./udpserver -p 12345 -N 2000 -e 0.00001 -B 200 -n 8 -W 16 &
./udpclient -s localhost -p 12345 -L 256 -R 20 -N 2000 -W 16 -B 200 -n 8 > r5c.txt
wait

./udpserver -p 12345 -N 2000 -e 0.00001 -B 200 -n 8 -W 16 &
./udpclient -s localhost -p 12345 -L 256 -R 300 -N 2000 -W 16 -B 200 -n 8 > r6c.txt
wait

./udpserver -p 12345 -N 2000 -e 0.00001 -B 200 -n 8 -W 16 &
./udpclient -s localhost -p 12345 -L 1500 -R 20 -N 2000 -W 16 -B 200 -n 8 > r7c.txt
wait

./udpserver -p 12345 -N 2000 -e 0.00001 -B 200 -n 8 -W 16 &
./udpclient -s localhost -p 12345 -L 1500 -R 300 -N 2000 -W 16 -B 200 -n 8 > r8c.txt
wait

./udpserver -p 12345 -N 2000 -e 0.0000001 -B 200 -n 8 -W 16 &
./udpclient -s localhost -p 12345 -L 256 -R 20 -N 2000 -W 16 -B 200 -n 8 > r9c.txt
wait

./udpserver -p 12345 -N 2000 -e 0.0000001 -B 200 -n 8 -W 16 &
./udpclient -s localhost -p 12345 -L 256 -R 300 -N 2000 -W 16 -B 200 -n 8 > r10c.txt
wait

./udpserver -p 12345 -N 2000 -e 0.0000001 -B 200 -n 8 -W 16 &
./udpclient -s localhost -p 12345 -L 1500 -R 20 -N 2000 -W 16 -B 200 -n 8 > r11c.txt
wait

./udpserver -p 12345 -N 2000 -e 0.0000001 -B 200 -n 8 -W 16 &
./udpclient -s localhost -p 12345 -L 1500 -R 300 -N 2000 -W 16 -B 200 -n 8 > r12c.txt
wait

