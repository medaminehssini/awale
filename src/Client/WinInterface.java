package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class WinInterface {

	public JFrame frame;
	JLabel lblNewLabel_1;
	public WinInterface (String nom) {
		
		initialize();
		lblNewLabel_1.setText(nom);
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		try {
			frame.setIconImage(ImageIO.read(new File("images/icon.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setBounds(100, 100, 406, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim =  Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				LobbyInterface.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(117, 342, 199, 41);
		frame.getContentPane().add(btnNewButton);
		
		 lblNewLabel_1 = new JLabel("Ahmed ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setBounds(0, 0, 392, 72);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/images/ww.jpg")));
		lblNewLabel.setBounds(0, 0, 413, 393);
		frame.getContentPane().add(lblNewLabel);
		

	}
}
