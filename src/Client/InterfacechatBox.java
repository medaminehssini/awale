package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfacechatBox {

	JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel;
	TextArea textArea;


	/**
	 * Create the application.
	 */
	public InterfacechatBox() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Chat Box");
		frame.setBounds(100, 100, 384, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(10, 99, 346, 319);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InterfaceStartMenu.SendToServer(textField.getText());
				textField.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(258, 424, 98, 33);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(10, 424, 238, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Chat Box");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 65));
		lblNewLabel.setBounds(10, 10, 346, 83);
		frame.getContentPane().add(lblNewLabel);
	}
}
