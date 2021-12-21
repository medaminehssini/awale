package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrivateChatBox {

	JFrame frame;
	private JTextField textField;


	/**
	 * Create the application.
	 */
	public PrivateChatBox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 93);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		JLabel lblNewLabel = new JLabel("Envoyer une Message : ");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		JButton btnNewButton = new JButton("Envoyer ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfaceStartMenu.SendToServer("session "+textField.getText());
				textField.setText("");
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.EAST);
		

	
	}

}
