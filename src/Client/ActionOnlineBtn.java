package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ActionOnlineBtn   implements ActionListener{
	int indice ;
	
	public ActionOnlineBtn (int indice) {
		this.indice = indice;
	}

	@Override
	public void actionPerformed(ActionEvent btn) {
		new ActionOnlineThread((JButton)btn.getSource() , indice).start();
		
	}
	
	
	
	

}
