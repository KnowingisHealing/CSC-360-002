package servers;

/**
 * @(#)basicServer.java
 */
 
import java.net.*;
import java.io.*;


public class basicServer {
    
    public static void main(String[] args) {
Socket Sock;
    	
    	try {
    		System.out.println("Binding to port 3456");
    		
    		ServerSocket SS = new ServerSocket(3456);
    		System.out.println("Waiting for client connection");
    		Sock = SS.accept( );
    		
    		System.out.println("Client CONNECTED");
    		
    		DataInputStream in = new DataInputStream( Sock.getInputStream());
    		DataOutputStream out = new DataOutputStream( Sock.getOutputStream());
    		
    		double x = in.readDouble( );
    		double y = in.readDouble( );
    		
    		System.out.println("Read values " + x + "   " + y);
    		out.writeDouble( x*y);
    	}
    	catch (IOException E) {
    		System.out.println("Some bad shit happened");
    	}
    	
    	
    }
}
