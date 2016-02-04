package servers;

/**

 * @(#)simpleClient.java

 */
 
 import java.io.*;
 import java.net.*;
 
public class simpleClient {
    
    public static void main(String[] args) {
    	
    	try {
    	
    	System.out.println("Connecting to server");
    	Socket Sock = new Socket("localhost", 3456);
    	
    	DataInputStream in = new DataInputStream( Sock.getInputStream());
    	DataOutputStream out = new DataOutputStream( Sock.getOutputStream());
    	
    	System.out.println("Connected...");
    	out.writeDouble(55.678);
    	out.writeDouble(44.8765);
    	
    	Double answer = in.readDouble();
    	
    	System.out.println("Answer is " + answer);
    	}
    	catch (IOException E) {
    		System.out.println("bad crap here");
    	}
    }
}
