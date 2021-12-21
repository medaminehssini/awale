package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ActionBtn   implements ActionListener{
	int indice ;
	
	public ActionBtn (int indice) {
		this.indice = indice;
	}

	@Override
	public void actionPerformed(ActionEvent btn) {
		new ActionThread((JButton)btn.getSource() , indice).start();
		
	}
	
	
	
	

}
