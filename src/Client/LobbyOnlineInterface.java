package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Canvas;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.SwingConstants; 

public class LobbyOnlineInterface {
	JButton btnNewButton_2,btnNewButton_3;
	public static JFrame frame;
	static JLabel nomplayer2;
	static JLabel nomplayer1;
	static JLabel ScorePlayer1;
	static JLabel ScorePlayer2;
	static boolean isPlayer1 = true;
	static boolean isPlayer2 = false;
	static int[]  bulle = {4 , 4 , 4 , 4 , 4 , 4 , 4 , 4  , 4 , 4 , 4 , 4 };
	JButton btnNewButton;
	private JButton btnNewButton_1;
	static ArrayList<JButton> ButtonsList = new ArrayList<JButton>();
	private JButton btnNewButton_4;
	PrivateChatBox pchat;
	private static JLabel chatp ;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public LobbyOnlineInterface(String player1 ,String player2) {
		initialize();
		nomplayer1.setText(player1);
		nomplayer2.setText(player2);
		if(InterfaceStartMenu.c.nom.equals(player1)) {
			frame.getContentPane().remove(btnNewButton_2);
		}else {
			frame.getContentPane().remove(btnNewButton_3);
		}
		chatp = new JLabel("");
		chatp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ScorePlayer2 = new JLabel("0");
		ScorePlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		ScorePlayer2.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 31));
		ScorePlayer2.setForeground(Color.GREEN);
		ScorePlayer2.setBounds(707, 110, 109, 26);
		frame.getContentPane().add(ScorePlayer2);
		
		ScorePlayer1 = new JLabel("0");
		ScorePlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		ScorePlayer1.setForeground(Color.GREEN);
		ScorePlayer1.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 31));
		ScorePlayer1.setBounds(10, 110, 109, 26);
		frame.getContentPane().add(ScorePlayer1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(this.getClass().getResource("/images/ss.png")));
		lblNewLabel_2.setBounds(337, 48, 169, 146);
		frame.getContentPane().add(lblNewLabel_2);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pchat.frame.setVisible(true);
			}	
		});
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBounds(376, 5, 71, 58);
		btnNewButton_4.setIcon(new ImageIcon(this.getClass().getResource("/images/chat.png")));

		frame.getContentPane().add(btnNewButton_4);
		
		
			if(!InterfaceStartMenu.c.nom.equals(player1)) {
				chatp.setHorizontalAlignment(SwingConstants.RIGHT);
				chatp.setBounds(526, 10, 190, 23);
			}else {
				chatp.setHorizontalAlignment(SwingConstants.LEFT);
				chatp.setBounds(122, 15, 190, 23);
			}
		
	
			frame.getContentPane().add(chatp);
		
		pchat = new PrivateChatBox();
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Room 1");
		frame.setBounds(100, 100, 840, 411);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension dim =  Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.getContentPane().setLayout(null);
		try {
			frame.setIconImage(ImageIO.read(this.getClass().getResource("/images/icon.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(122, 285, 483, 53);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		frame.getContentPane().add(btnNewButton_2);
		
		 btnNewButton_3 = new JButton("");
		 btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(133, 215, 472, 50);
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		frame.getContentPane().add(btnNewButton_3);
		
		
		
		 nomplayer1 = new JLabel("Player 1");
		 nomplayer1.setForeground(new Color(0, 0, 205));
		nomplayer1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		nomplayer1.setBounds(127, 35, 157, 39);
		frame.getContentPane().add(nomplayer1);
		
		 nomplayer2 = new JLabel("Player 2");
		 nomplayer2.setForeground(new Color(255, 0, 0));
		nomplayer2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		nomplayer2.setBounds(583, 35, 146, 39);
		frame.getContentPane().add(nomplayer2);

		
		
		/*  player 1     */	
		
			btnNewButton = new JButton("4");
			btnNewButton.addActionListener(new ActionOnlineBtn(0));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
			btnNewButton.setForeground(new Color(0, 0, 255));
			btnNewButton.setBounds(138, 215, 80, 63);
			btnNewButton.setOpaque(false);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setBorderPainted(false);
			frame.getContentPane().add(btnNewButton);
			ButtonsList.add(btnNewButton);	
			
			btnNewButton = new JButton("4");
			btnNewButton.addActionListener(new ActionOnlineBtn(1));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
			btnNewButton.setForeground(new Color(0, 0, 255));
			btnNewButton.setBounds(217, 215, 80, 63);
			btnNewButton.setOpaque(false);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setBorderPainted(false);
			frame.getContentPane().add(btnNewButton);
			ButtonsList.add(btnNewButton);	

			btnNewButton = new JButton("4");
			btnNewButton.addActionListener(new ActionOnlineBtn(2));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
			btnNewButton.setForeground(new Color(0, 0, 255));
			btnNewButton.setBounds(294, 215, 80, 63);
			btnNewButton.setOpaque(false);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setBorderPainted(false);
			frame.getContentPane().add(btnNewButton);
			ButtonsList.add(btnNewButton);
		
			btnNewButton = new JButton("4");
			btnNewButton.addActionListener(new ActionOnlineBtn(3));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
			btnNewButton.setForeground(new Color(0, 0, 255));
			btnNewButton.setBounds(366, 215, 80, 63);
			btnNewButton.setOpaque(false);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setBorderPainted(false);
			frame.getContentPane().add(btnNewButton);
			ButtonsList.add(btnNewButton);
			
			btnNewButton = new JButton("4");
			btnNewButton.addActionListener(new ActionOnlineBtn(4));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
			btnNewButton.setForeground(new Color(0, 0, 255));
			btnNewButton.setBounds(448, 215, 80, 63);
			btnNewButton.setOpaque(false);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setBorderPainted(false);
			frame.getContentPane().add(btnNewButton);
			ButtonsList.add(btnNewButton);
			
			btnNewButton = new JButton("4");
			btnNewButton.addActionListener(new ActionOnlineBtn(5));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
			btnNewButton.setForeground(new Color(0, 0, 255));
			btnNewButton.setBounds(525, 215, 80, 63);
			btnNewButton.setOpaque(false);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setBorderPainted(false);
			frame.getContentPane().add(btnNewButton);
			ButtonsList.add(btnNewButton);
		
		/*Player 2*/
			btnNewButton = new JButton("4");
			btnNewButton.addActionListener(new ActionOnlineBtn(6));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
			btnNewButton.setForeground(new Color(255, 0, 0));
			btnNewButton.setBounds(525, 275, 80, 63);
			btnNewButton.setOpaque(false);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setBorderPainted(false);
			frame.getContentPane().add(btnNewButton);
			ButtonsList.add(btnNewButton);	
			
			btnNewButton = new JButton("4");
			btnNewButton.addActionListener(new ActionOnlineBtn(7));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
			btnNewButton.setForeground(new Color(255, 0, 0));
			btnNewButton.setBounds(448, 275, 80, 63);
			btnNewButton.setOpaque(false);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setBorderPainted(false);
			frame.getContentPane().add(btnNewButton);
			ButtonsList.add(btnNewButton);	
			
			btnNewButton = new JButton("4");
			btnNewButton.addActionListener(new ActionOnlineBtn(8));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
			btnNewButton.setForeground(new Color(255, 0, 0));
			btnNewButton.setBounds(376, 275, 80, 63);
			btnNewButton.setOpaque(false);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setBorderPainted(false);
			frame.getContentPane().add(btnNewButton);
			ButtonsList.add(btnNewButton);
			
			btnNewButton = new JButton("4");
			btnNewButton.addActionListener(new ActionOnlineBtn(9));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
			btnNewButton.setForeground(new Color(255, 0, 0));
			btnNewButton.setBounds(294, 275, 80, 63);
			btnNewButton.setOpaque(false);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setBorderPainted(false);
			frame.getContentPane().add(btnNewButton);
			ButtonsList.add(btnNewButton);
			
			btnNewButton = new JButton("4");
			btnNewButton.addActionListener(new ActionOnlineBtn(10));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
			btnNewButton.setForeground(new Color(255, 0, 0));
			btnNewButton.setBounds(217, 275, 80, 63);
			btnNewButton.setOpaque(false);
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setBorderPainted(false);
			frame.getContentPane().add(btnNewButton);
			ButtonsList.add(btnNewButton);
			
			btnNewButton_1 = new JButton("4");
			
			btnNewButton_1.addActionListener(new ActionOnlineBtn(11));
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
			btnNewButton_1.setForeground(new Color(255, 0, 0));
			btnNewButton_1.setBounds(148, 275, 80, 63);
			btnNewButton_1.setOpaque(false);
			btnNewButton_1.setContentAreaFilled(false);
			btnNewButton_1.setBorderPainted(false);
			frame.getContentPane().add(btnNewButton_1);
			ButtonsList.add(btnNewButton_1);
			
		JLabel BackgroundImage = new JLabel("");
		BackgroundImage.setBackground(new Color(255, 255, 255));
		BackgroundImage.setIcon(new ImageIcon(this.getClass().getResource("/images/background.png")));
		BackgroundImage.setBounds(58, 110, 780, 264);
		frame.getContentPane().add(BackgroundImage);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/images/p2.png")));
		lblNewLabel_1.setBounds(714, 15, 102, 80);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/images/p.png")));
		lblNewLabel.setBounds(26, 5, 120, 107);
		frame.getContentPane().add(lblNewLabel);
		
		
		

	}
	
	
	public static void openChat (String text) {
		chatp.setText(text);
		
		new Thread()
		{
		    public void run() {
		        try {
					this.sleep(2000);
					chatp.setText("");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}.start();
	}
}
