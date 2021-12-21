package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;


import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

public class InterfaceServer {
	static final int PORT = 2020;
	private JFrame frame;
	 ServerSocket serverSocket = null;
     Socket socket = null;
     JButton btnNewButton_1;
     Server server;
     JButton btnNewButton ;
    static public TextArea textPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceServer window = new InterfaceServer();
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
	public InterfaceServer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Server :");
		frame.setBounds(100, 100, 545, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 btnNewButton = new JButton("Stop");
		 btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeServer();
			}
		});
		
		btnNewButton.setBounds(386, 281, 135, 37);
		frame.getContentPane().add(btnNewButton);
		
		 btnNewButton_1 = new JButton("Start");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startServer();
			}
		});
		btnNewButton_1.setBounds(29, 281, 135, 37);
		frame.getContentPane().add(btnNewButton_1);
		

		
		JLabel lblNewLabel = new JLabel("Server Log :");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
		lblNewLabel.setBounds(20, 24, 242, 37);
		frame.getContentPane().add(lblNewLabel);
		
		 textPane = new TextArea();
		textPane.setBounds(10, 63, 521, 208);
		frame.getContentPane().add(textPane);
	}
	
	public void startServer() {


	        try {
	            serverSocket = new ServerSocket(PORT);
	            
	            
	        } catch (IOException e) {
	            e.printStackTrace();

	        }
	        btnNewButton_1.setEnabled(false);
	        btnNewButton.setEnabled(true);
	        server = new Server(serverSocket);
	        server.start();
	        textPane.setText(textPane.getText() + "Server is Started\n");
	}
	
	public void closeServer () {
		 server.closeSocket();
		try {
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textPane.setText(textPane.getText() + "Server is closed\n");
	  btnNewButton_1.setEnabled(true);
	  btnNewButton.setEnabled(false);
	}
	
	public static void addMessage (String str) {
		textPane.setText(textPane.getText() + str);
	}
}
