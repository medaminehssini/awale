package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.List;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceListClient {

	 JFrame frame;
	 List listclient;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public InterfaceListClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 304, 460);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		listclient = new List();
		listclient.setBounds(10, 10, 270, 345);
		frame.getContentPane().add(listclient);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listclient.getSelectedIndex() >= 0) {
					InterfaceStartMenu.SendToServer("session if "+listclient.getItem(listclient.getSelectedIndex()));
					InterfaceStartMenu.c.nomClient = listclient.getItem(listclient.getSelectedIndex());
					frame.setVisible(false);
				}
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		btnNewButton.setBounds(10, 361, 270, 48);
		frame.getContentPane().add(btnNewButton);
	}
}
