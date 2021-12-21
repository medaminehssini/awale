package Server;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.JTextPane;

class Server extends Thread {
	
     ServerSocket serverSocket = null;
     Socket socket = null;
     static private ArrayList<ServerThread> clients = new ArrayList<>();
     boolean isClosed = false ; 
	 public Server (ServerSocket serverSocket ) {
		 this.serverSocket = serverSocket;
		
	 }
	 
	 public void run () {


	        while (true) {
	        	
	            try {
	  
		        		socket = serverSocket.accept();	
		        		ServerThread client = new ServerThread(socket , clients );
		        		client.start();
		        		clients.add(client);
		        		
		        		
		        		
		        		
	        
	            } catch (IOException e) {
	            	
	            	
	            	
	                System.out.println("I/O error: " + e);
	                break;
	                
	                
	            }
	        } 
	 }
	 
	 public void closeSocket () {
		 
	    isClosed = true;
	    
	 }
	 
	 
	  
	 static public  void sendListClient () {
		 for (ServerThread serverThread : clients) {
			 serverThread.out.println("sendCls");	
		 }
		 for (ServerThread serverThread : clients) {
			

			 for (ServerThread client : clients) {
				 if( ! client.nom.equals(serverThread.nom))
					 serverThread.out.println("client "+client.nom);	
			}
		}
	 }
	 
	 
	public static void removeClient (String str) {
		
		for (int j = 0; j < clients.size(); j++) {
			System.out.println(clients.get(j).nom);
			if(clients.get(j).nom.equals(str)) {
				System.out.println( clients.get(j).nom + " is removed");
				 clients.remove(j);
			}
		}
		sendListClient ();
	}

}