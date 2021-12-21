package Client;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ActionOnlineThread extends Thread {
	JButton btn;
	int indice ; 
	public  ActionOnlineThread (JButton btn , int indice) {
		this.btn = btn ; 
		this.indice = indice;
	}
	public void run () {
		
		if((LobbyOnlineInterface.isPlayer1 && indice < 6 ) || (  LobbyOnlineInterface.isPlayer2 &&  indice >= 6  ) ) {
				if(InterfaceStartMenu.c.numberIndex != indice)
					InterfaceStartMenu.SendToServer("session game "+indice);
			
				btn.setText("0");
				int i=indice;
				
				int content = LobbyOnlineInterface.bulle[indice];
				LobbyOnlineInterface.bulle[indice] = 0 ; 
				while (content>0) {
						i = incrementGame(i);

					if(indice == i ) {
						i = incrementGame(i);
					}
					
					try {
						this.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					LobbyOnlineInterface.bulle[i] = LobbyOnlineInterface.bulle[i]+1 ; 
					LobbyOnlineInterface.ButtonsList.get(i).setText(LobbyOnlineInterface.bulle[i]+"");
					
			
					content--;
					if (content == 0) {
						
		
						verifWin(i);
						
					}
			
				}
				
				LobbyOnlineInterface.isPlayer1 = !LobbyOnlineInterface.isPlayer1;
				LobbyOnlineInterface.isPlayer2 = !LobbyOnlineInterface.isPlayer2;
	
			}else {
				if (LobbyOnlineInterface.isPlayer1) {
					JOptionPane.showMessageDialog(null, "Tour de "+LobbyOnlineInterface.nomplayer1.getText()+".", "Erreur", JOptionPane.ERROR_MESSAGE);
	
				}else {
					JOptionPane.showMessageDialog(null, "Tour de "+LobbyOnlineInterface.nomplayer2.getText()+".", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
	}
	
	
	int incrementGame (int i)  {
		if(i+1>LobbyOnlineInterface.bulle.length-1) {
			 i=0;
		}else {
			 i++;
	
		}
		
		return i ; 
	}
	
	
	void verifWin (int index) {
		
		while ((LobbyOnlineInterface.bulle[index] == 2 || LobbyOnlineInterface.bulle[index] == 3) && ((LobbyOnlineInterface.isPlayer1 && index > 5) || (LobbyOnlineInterface.isPlayer2 && index < 6 ) )) {
			System.out.println("index est : " + index + "  Score est : " + LobbyOnlineInterface.bulle[index] );
			if(LobbyOnlineInterface.isPlayer1) {
				LobbyOnlineInterface.ScorePlayer1.setText((Integer.parseInt(LobbyOnlineInterface.ScorePlayer1.getText())+LobbyOnlineInterface.bulle[index])+"");
			}else {
				LobbyOnlineInterface.ScorePlayer2.setText((Integer.parseInt(LobbyOnlineInterface.ScorePlayer2.getText())+LobbyOnlineInterface.bulle[index])+"");
			}
			try {
				this.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LobbyOnlineInterface.bulle[index] = 0;
			LobbyOnlineInterface.ButtonsList.get(index).setText(LobbyOnlineInterface.bulle[index]+"");
				
			
			index--;
			if(index < 0) {
				index = 11;
			}
		}
		
		VerifWinGame();
	}
	
	

	public void VerifWinGame () {
		 
		int s = 0 ;
		
		for (int i = 0; i < LobbyOnlineInterface.bulle.length; i++) {
			s+=LobbyOnlineInterface.bulle[i];
		}
		if(Integer.parseInt(LobbyOnlineInterface.ScorePlayer2.getText() ) > 24) {
			setWinGame(2);
		}else if (Integer.parseInt(LobbyOnlineInterface.ScorePlayer1.getText()) > 24) {
			setWinGame(1);

		}else if(s <= 1) {
			if(Integer.parseInt(LobbyOnlineInterface.ScorePlayer2.getText() ) > Integer.parseInt(LobbyOnlineInterface.ScorePlayer1.getText()) ){
				setWinGame(2);
			}else {
				setWinGame(1);
			}
		}
		
	}
	
	
	
	
	public void setWinGame (int p)  {
		WinInterface win ;
		if (p == 1) {
			win = new WinInterface(LobbyOnlineInterface.nomplayer2.getText());

		} else {

			win = new WinInterface(LobbyOnlineInterface.nomplayer1.getText());

		}
		
		win.frame.setVisible(true);
		LobbyOnlineInterface.frame.setVisible(false);
	}
	
	
}
