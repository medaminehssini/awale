package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private Socket socket;
    String nom = "" ; 
    PrintWriter out ;
    BufferedReader in ;
    String nomClient = null;
     ArrayList<ServerThread> clients ;
    public ServerThread(Socket clientSocket , ArrayList<ServerThread> clients)  throws IOException {
        this.socket = clientSocket;
        this.clients = clients ;
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream())) ; 
    }
    
    
   public void run () {
	   try {
           while (true) {
           	String request = in.readLine();
           	if(request == null) {
           		InterfaceServer.addMessage(nom + " is Desconnected\n");
           		Server.removeClient(nom);
       
           		break;
           	}
           	if (nom.equals("") ) {
           		nom = request;
           		Server.sendListClient();
           		InterfaceServer.addMessage(request+" is Connected\n");
           	}else {
           		
           		if(request.indexOf("session if ") == 0) {
           			nomClient  = request.split(" ")[2];
           			sentToClient(nomClient, "session if " + nom  );
           		}else if(request.indexOf("session set ") == 0) {
           			nomClient  = request.split(" ")[2];
           			sentToClient(nomClient, "session set " + nom  );
           		}else if(request.indexOf("session ") == 0) {
           			sentToClient(nomClient, request  );
           		}else if(request.indexOf("session game ") == 0) {
           			sentToClient(nomClient, request  );
           		}else {
               		sendToAll (nom + " : " + request);
           		}
           	}

           	
			} 
		} catch (IOException e) {
       		InterfaceServer.addMessage(nom + " is Desconnected\n");
       		Server.removeClient(nom);
			System.err.println("IO exception in client server side");
		}finally {
			out.close();
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
    
   void sendToAll(String msj) {
	   for (ServerThread serverThread : clients) {
		   serverThread.out.println(msj);
	   }
   }
   
   void sentToClient (String to , String msj) {
	   for (ServerThread serverThread : clients) {
		   if(serverThread.nom.equals(to)) {
		
			   serverThread.out.println(msj);

		   }
	   } 
   }

}
