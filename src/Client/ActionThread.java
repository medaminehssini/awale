package Client;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ActionThread extends Thread {
	JButton btn;
	int indice ; 
	public  ActionThread (JButton btn , int indice) {
		this.btn = btn ; 
		this.indice = indice;
	}
	public void run () {
		
		if((RoomInterface.isPlayer1 && indice < 6 ) || (  RoomInterface.isPlayer2 &&  indice >= 6  ) ) {
				
				btn.setText("0");
				int i=indice;
				
				int content = RoomInterface.bulle[indice];
				RoomInterface.bulle[indice] = 0 ; 
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
					
					RoomInterface.bulle[i] = RoomInterface.bulle[i]+1 ; 
					RoomInterface.ButtonsList.get(i).setText(RoomInterface.bulle[i]+"");
					
			
					content--;
					if (content == 0) {
						
		
						verifWin(i);
						
					}
			
				}
				
				RoomInterface.isPlayer1 = !RoomInterface.isPlayer1;
				RoomInterface.isPlayer2 = !RoomInterface.isPlayer2;
	
			}else {
				if (RoomInterface.isPlayer1) {
					JOptionPane.showMessageDialog(null, "Tour de "+RoomInterface.nomplayer1.getText()+".", "Erreur", JOptionPane.ERROR_MESSAGE);
	
				}else {
					JOptionPane.showMessageDialog(null, "Tour de "+RoomInterface.nomplayer2.getText()+".", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
	}
	
	
	int incrementGame (int i)  {
		if(i+1>RoomInterface.bulle.length-1) {
			 i=0;
		}else {
			 i++;
	
		}
		
		return i ; 
	}
	
	
	void verifWin (int index) {
		
		while ((RoomInterface.bulle[index] == 2 || RoomInterface.bulle[index] == 3) && ((RoomInterface.isPlayer1 && index > 5) || (RoomInterface.isPlayer2 && index < 6 ) )) {
			System.out.println("index est : " + index + "Score est : " + RoomInterface.bulle[index]  + "  "  + LobbyOnlineInterface.isPlayer1 );
			if(RoomInterface.isPlayer1) {
				RoomInterface.ScorePlayer1.setText((Integer.parseInt(RoomInterface.ScorePlayer1.getText())+RoomInterface.bulle[index])+"");
			}else {
				RoomInterface.ScorePlayer2.setText((Integer.parseInt(RoomInterface.ScorePlayer2.getText())+RoomInterface.bulle[index])+"");
			}
			try {
				this.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RoomInterface.bulle[index] = 0;
			RoomInterface.ButtonsList.get(index).setText(RoomInterface.bulle[index]+"");
				
			
			index--;
			if(index < 0) {
				index = 11;
			}
		}
		
		VerifWinGame();
	}
	
	
	public void VerifWinGame () {
		 
		int s = 0 ;
		
		for (int i = 0; i < RoomInterface.bulle.length; i++) {
			s+=RoomInterface.bulle[i];
		}
		if(Integer.parseInt(RoomInterface.ScorePlayer2.getText() ) > 24) {
			setWinGame(2);
		}else if (Integer.parseInt(RoomInterface.ScorePlayer1.getText()) > 24) {
			setWinGame(1);

		}else if(s <= 1) {
			if(Integer.parseInt(RoomInterface.ScorePlayer2.getText() ) > Integer.parseInt(RoomInterface.ScorePlayer1.getText()) ){
				setWinGame(2);
			}else {
				setWinGame(1);
			}
		}
		
	}
	
	
	
	
	public void setWinGame (int p)  {
		WinInterface win ;
		if (p == 1) {
			win = new WinInterface(RoomInterface.nomplayer2.getText());

		} else {

			win = new WinInterface(RoomInterface.nomplayer1.getText());

		}
		
		win.frame.setVisible(true);
		RoomInterface.frame.setVisible(false);
	}
}
