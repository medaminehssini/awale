package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class InterfaceStartMenu {

	JFrame frame;
	String nom ; 
	static Client c;
	Socket skt ; 
	static LobbyInterface l;
	static InterfacechatBox chat;
	static InterfaceListClient listClient;
	static private PrintWriter out ;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public InterfaceStartMenu(String nom) {
		initialize();
		frame.setVisible(true);
		this.nom = nom ;
		
		 chat = new InterfacechatBox ();
		 listClient = new InterfaceListClient();
		 
		try {
			skt = new Socket("localhost", 2020);
			c = new Client(nom , skt);
			c.start();
			out = new PrintWriter(skt.getOutputStream() , true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SendToServer(nom );
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 449, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/images/icon2.png")));
		lblNewLabel.setBounds(66, 54, 300, 159);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("play offline");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				l = new LobbyInterface();
				l.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(143, 245, 167, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Play online");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listClient.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(143, 311, 167, 44);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Quitter");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(143, 379, 167, 44);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chat.frame.setVisible(true);
				
				
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(this.getClass().getResource("/images/chat.png")));
		btnNewButton_4.setBounds(10, 10, 71, 58);
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorderPainted(false);
		frame.getContentPane().add(btnNewButton_4);
	}
	
	
	public static void SendToServer (String msj)  {
 		out.println(msj);
	}
	
	public static void setMessage (String msj) {
		chat.textArea.setText(chat.textArea.getText()+"\n" + msj);
	}

}
