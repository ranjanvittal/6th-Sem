main : ftpclient ftpserver

ftpclient: client/ftpclient.c
		   gcc $^ -o client/ftpclient

ftpserver: server/ftpserver.c
		   gcc $^ -o server/ftpserver

clean:
	rm client/ftpclient
	rm server/ftpserver
