package servers;

import java.io.*;
import java.net.*;

public class serverThread implements Runnable  {
	
	private DataInputStream in;
	private DataOutputStream out;
	private int name;
	
	public serverThread( Socket S, int n ) {
	   try {
	   
		in = new DataInputStream(S.getInputStream());
		out = new DataOutputStream(S.getOutputStream( ));
		name = n;
	   }
		catch  (IOException E) { }
	}
	
	public void run( ) {
		   try {
		   	 double x = in.readDouble( );
    		double y = in.readDouble( );
    		
    		System.out.println("Thread" + name + " Read values " + x + "   " + y);
    		out.writeDouble( x*y);
		   } catch (IOException E) { }
	}
	
	
}