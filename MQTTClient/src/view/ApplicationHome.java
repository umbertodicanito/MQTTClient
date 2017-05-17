package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ApplicationHome extends JFrame {

	private JPanel contentPane;
	private JTextField txtClientID;
	private JTextField txtServer;
	private JTextField txtPorta;
	private JButton btnConnetti;


	public ApplicationHome() {
		super();
		contentPane = new JPanel();
		setType(Type.UTILITY);
		setTitle("MQTT CLIENT ");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\umber\\Desktop\\MQTTClient\\src\\images\\icon.png"));
		setForeground(Color.WHITE); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 650, 500);
		
		contentPane.setLayout(null);
		contentPane.validate();
		
		JLabel lblWelcome = new JLabel("Benvenuto nell'applicazione per connessione MQTT");
		lblWelcome.setFont(new Font("Titillium Web", Font.BOLD, 18));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(0, 13, 632, 28);
		contentPane.add(lblWelcome);
		
		JLabel lblWelcomeSubtitles = new JLabel("Qui \u00E9 possibile collegarsi ad un broker MQTT, inserendo un ID, un server e una porta.");
		lblWelcomeSubtitles.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeSubtitles.setFont(new Font("Titillium Web", Font.PLAIN, 14));
		lblWelcomeSubtitles.setBounds(0, 54, 632, 28);
		contentPane.add(lblWelcomeSubtitles);
		
		JLabel lblClientID = new JLabel("Client ID");
		lblClientID.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		lblClientID.setBounds(70, 143, 103, 28);
		contentPane.add(lblClientID);
		
		JLabel lblServer = new JLabel("Server");
		lblServer.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		lblServer.setBounds(70, 201, 103, 28);
		contentPane.add(lblServer);
		
		JLabel lblPort = new JLabel("Porta");
		lblPort.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		lblPort.setBounds(70, 261, 103, 28);
		contentPane.add(lblPort);
		
		txtClientID = new JTextField();
		txtClientID.setSelectionColor(new Color(0, 255, 0));
		txtClientID.setToolTipText("");
		txtClientID.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		txtClientID.setBounds(221, 143, 327, 28);
		contentPane.add(txtClientID);
		txtClientID.setColumns(10);
		
		txtServer = new JTextField();
		txtServer.setSelectionColor(new Color(0, 255, 0));
		txtServer.setToolTipText("");
		txtServer.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		txtServer.setColumns(10);
		txtServer.setBounds(221, 201, 327, 28);
		contentPane.add(txtServer);
		
		txtPorta = new JTextField();
		txtPorta.setSelectionColor(new Color(0, 255, 0));
		txtPorta.setToolTipText("");
		txtPorta.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		txtPorta.setColumns(10);
		txtPorta.setBounds(221, 261, 64, 28);
		contentPane.add(txtPorta);
		
		btnConnetti = new JButton("Connetti");
		btnConnetti.setBackground(new Color(0, 255, 0));
		btnConnetti.setFont(new Font("Titillium Web", Font.BOLD, 15));
		btnConnetti.setBounds(451, 315, 97, 36);
		contentPane.add(btnConnetti);
		contentPane.validate();
		setContentPane(contentPane);
	}
	

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTxtClientID() {
		return txtClientID;
	}

	public void setTxtClientID(JTextField txtClientID) {
		this.txtClientID = txtClientID;
	}

	public JTextField getTxtServer() {
		return txtServer;
	}

	public void setTxtServer(JTextField txtServer) {
		this.txtServer = txtServer;
	}

	public JTextField getTxtPorta() {
		return txtPorta;
	}

	public void setTxtPorta(JTextField txtPorta) {
		this.txtPorta = txtPorta;
	}
	
	public JButton getBtnConnetti() {
		return btnConnetti;
	}

	public void setBtnConnetti(JButton btnConnetti) {
		this.btnConnetti = btnConnetti;
	}


}
