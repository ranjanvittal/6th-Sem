import numpy as np
from pylab import *
file_name = raw_input()
dat = np.genfromtxt(file_name, dtype=double, delimiter="\t" )
figure(1)
xlabel('Time')
ylabel('Congestion Window Size')
title('cwnd versus time for Tcp' + file_name[:-4])

x = [row[0] for row in dat]
y = [row[1] for row in dat]
plot(x,y)

savefig('Tcp' + file_name[:-4] + ".png")
