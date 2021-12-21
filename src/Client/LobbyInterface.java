package Client;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
public class LobbyInterface {

	public static JFrame frame;
	private JTextField txtPlayer;
	private JTextField txtPlayer_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;


	/**
	 * Create the application.
	 */
	public LobbyInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 843, 442);
		try {
			frame.setIconImage(ImageIO.read(this.getClass().getResource("/images/icon.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dimension dim =  Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RoomInterface r = new RoomInterface(txtPlayer.getText() , txtPlayer_1.getText());
				r.frame.setVisible(true);
				frame.setVisible(false);
			}
			
		});
		btnNewButton.setBounds(602, 336, 217, 58);
		frame.getContentPane().add(btnNewButton);
		
		
		txtPlayer_1 = new JTextField();
		txtPlayer_1.setText("joueur 2");
		txtPlayer_1.setColumns(10);
		txtPlayer_1.setBounds(139, 234, 300, 40);
		frame.getContentPane().add(txtPlayer_1);
		
		
		
		txtPlayer = new JTextField();
		txtPlayer.setText("joueur 1");
		txtPlayer.setBounds(139, 75, 300, 40);
		frame.getContentPane().add(txtPlayer);
		txtPlayer.setColumns(10);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/images/p.png")));
		lblNewLabel.setBounds(24, 54, 105, 93);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/images/p2.png")));
		lblNewLabel_1.setBounds(10, 199, 105, 93);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(this.getClass().getResource("/images/pp.png")));
		lblNewLabel_2.setBounds(501, 10, 402, 333);
		frame.getContentPane().add(lblNewLabel_2);

		

		

	}
}
