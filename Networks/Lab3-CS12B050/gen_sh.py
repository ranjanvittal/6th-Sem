port_no = "12345"
B = ["200"]
N = ["2000"]
W = ["16"]
n = ["8"]
e = ["0.001", "0.00001", "0.0000001"]
L = ["256", "1500"]
R = ["20", "300"]

s = "localhost"
i = 1
for buffer_size in B :
    for number in N :
        for window in W :
            for sequence_field in n :
                for error in e :
                    for length in L :
                        for rate in R :
                            server_side = "./udpserver -p " + port_no
                            server_side += " -N " + number + " -e " + error
                            server_side += " -B " + buffer_size
                            server_side += " -n " + sequence_field
                            server_side += " -W " + window + " &"
                            print server_side
                            client_side = "./udpclient -s localhost -p "
                            client_side += port_no + " -L " + length + " -R "
                            client_side += rate + " -N " + number + " -W "
                            client_side += window + " -B " + buffer_size
                            client_side += " -n " + sequence_field
                            client_side += " > r" + str(i) + "c.txt"
                            print client_side
                            print "wait"
                            print ""
                            i = i+1
