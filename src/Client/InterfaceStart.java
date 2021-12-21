package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class InterfaceStart {

	private JFrame frame;
	private JTextField textField;
	static InterfaceStartMenu menu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceStart window = new InterfaceStart();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceStart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 213);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(88, 56, 282, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setOpaque(false);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setHorizontalTextPosition(JButton.CENTER);
        btnNewButton.setVerticalTextPosition(JButton.CENTER);
        btnNewButton.setBorderPainted(false);
		btnNewButton.setToolTipText("");
		btnNewButton.setIcon(new ImageIcon(this.getClass().getResource("/images/btn_.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu = new InterfaceStartMenu(textField.getText());
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(88, 101, 282, 53);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Your name : ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(88, 28, 162, 24);
		frame.getContentPane().add(lblNewLabel);
	}

}
