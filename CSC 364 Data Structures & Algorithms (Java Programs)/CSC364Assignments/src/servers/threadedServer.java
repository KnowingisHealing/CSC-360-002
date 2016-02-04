package servers;

/**
 * @(#)threadedServer.java
 */
 import java.net.*;
 import java.io.*;
 
public class threadedServer {
    
    public static void main(String[] args) {
    Socket Sock;
    	
    	try {
    		System.out.println("Binding to port 3456");
    		ServerSocket SS = new ServerSocket(3456);
    		int count = 0;
    	while (true) {
    	
    		System.out.println("Waiting for client connection");
    		Sock = SS.accept( );
    		count++;
    		
    		System.out.println("Client CONNECTED");
    		serverThread T = new serverThread(Sock, count);
    		Thread myThread = new Thread(T);
    		myThread.start();
    	} // end while	
    	
    	}
    	catch (IOException E) {
    		System.out.println("Some bad shit happened");
    	}
    		
    
    }
}
