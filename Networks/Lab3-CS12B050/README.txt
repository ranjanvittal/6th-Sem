Port number used is 12345.
Typing make makes two executables udpclient and udpserver where udpclient acts
as the sender and udpserver acts as the receiver.
Then we can either run it via the command line after making it.
For running a particular set of testcases which are mentioned in the
assignment run bash main_run.sh which simulates it in the localhost.
gen_sh.py is just a helper which is used
to generate the script. Running it via bash script will generate 12 files which contain information about the four parameters mentioned on the client side.
These donot generate any information about the receiver side though.
The data is represented as graph for the values got from transmitting between
two different systems. The localhost data are collected from result13c.txt
to result24c.txt and the cross machine data was collected from r1c.txt
to r12c.txt in TriedCases.