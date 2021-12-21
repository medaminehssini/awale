package Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import Server.InterfaceServer;

public class Client extends Thread  {
	Socket skt;
	String nom ;
	BufferedReader in;
	int isRemoved = 0 ;
	LobbyOnlineInterface s = null ; 
	String nomClient;
	int numberIndex = -1 ;
	public Client (String nom , Socket skt ) throws IOException{
		this.nom = nom;
		this.skt = skt;
		in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	}
	
	
	public void run () {
		 try {
	          //InterfaceClient.changeConnection(true);

				while (true) {
			        	 String serverResponse = in.readLine();
			        	 
				         if(serverResponse.equals("sendCls")) {
				        	 
				        	 InterfaceStartMenu.listClient.listclient.removeAll();
			        		 
			        	 }else if(serverResponse.indexOf("client ") == 0) {
			        		 
			        		 InterfaceStartMenu.listClient.listclient.add(serverResponse.substring(serverResponse.indexOf("client ")+7));
					         isRemoved++;
					         
				         }else if(serverResponse.indexOf("session ") == 0) {
				        	 	System.out.println(serverResponse);
				        	 	if(serverResponse.indexOf("session if ") == 0) {
				        	 		 nomClient = serverResponse.substring(serverResponse.indexOf("session if ")+11) ; 
				        	 		int verif = JOptionPane.showConfirmDialog(null, "vous voulez jouer avec " + nomClient , "Demande de participation ", JOptionPane.YES_NO_CANCEL_OPTION);
				        	 		if(verif == 0) {
				        	 			InterfaceStartMenu.SendToServer("session set " + nomClient);
					        	 		 s = new LobbyOnlineInterface (  nomClient , nom ) ;
					        	 		 s.frame.setVisible(true);
				        	 		}else {
				        	 			InterfaceStartMenu.SendToServer("session exit " + nomClient);
				        	 		}
				        	 	}else if (serverResponse.indexOf("session set ") == 0) {
				        	 		nomClient  = serverResponse.split(" ")[2];
				        	 		 s = new LobbyOnlineInterface (nom , nomClient ) ;
				        	 		 s.frame.setVisible(true);
				        	 	}if (serverResponse.indexOf("session game ") == 0) {
				        	 			numberIndex = Integer.parseInt(serverResponse.substring(13)) ;
				        	 			LobbyOnlineInterface.ButtonsList.get(Integer.parseInt(serverResponse.substring(13))).doClick();
				        	 			
				        	 	} else {
				        	 		LobbyOnlineInterface.openChat(serverResponse.substring(serverResponse.indexOf("session ")+8));
				        	 	}
				         } else {
				        	 
				        	 InterfaceStartMenu.setMessage(serverResponse);
				        	 
				         }
				         
				}

	      }
	      catch(Exception e) {
	    	 // InterfaceClient.changeConnection(false);
	         System.out.print("Whoops! It didn't work!\n");
	      }
	
	}
	
	
	public void closeSocket () {
		try {
			skt.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
