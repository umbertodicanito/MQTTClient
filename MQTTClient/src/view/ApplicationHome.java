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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

/*Classe dell'instanza finestra.
 * Crea tutta la GUI del programma
 */
public class ApplicationHome extends JFrame {

	private JPanel contentPane;
	private JTextField txtClientID,txtServer,txtPorta,txtNomeTopic,txtMsgInviato;
	private JButton btnConnetti, btnSottoscrivi,btnInvia;
	private JLabel lblConnessioneRiuscita,lblWelcome,lblWelcomeSubtitles,lblServer,
			lblPort,lblClientID,lblNomeTopic,lblTopicSottoscritti,lblMsgInviato,lblMsgRicevuti;
	private JTextArea txtAreaTopicsSubscribed,txtAreaMsgRicevuti;
	private JTabbedPane menuMain;
	private JLayeredPane schedaTopic,schedaMessaggi,schedaConnessione;
	private JScrollPane contenitoreMsgRicevuti;
	private JLayeredPane schedaInformazioni;
	private JLabel lblInfoUno;
	private JTextArea txtareaInformazioni;
	private JLayeredPane schedaGuida;
	private JLabel lblGuidaUno;
	private JTextArea txtareaGuida;
	private JLabel lblQoS;
	private ButtonGroup buttonGroup;
	private JComboBox comboBox; 

	//Costruttore
	public ApplicationHome() {
		super();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setResizable(false);
		contentPane = new JPanel();
		setTitle("MQTT CLIENT ");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\umber\\Desktop\\MQTTClient\\src\\images\\icon.png"));
		setForeground(Color.WHITE); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 650, 500);
		contentPane.validate();
		contentPane.setLayout(null);
		
		lblWelcome = new JLabel("Benvenuto nell'applicazione per connessione MQTT");
		lblWelcome.setBounds(0, 13, 632, 28);
		lblWelcome.setFont(new Font("Titillium Web", Font.BOLD, 18));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblWelcome);
		
		lblWelcomeSubtitles = new JLabel("Qui \u00E9 possibile collegarsi ad un broker MQTT, inserendo un ID, un server e una porta.");
		lblWelcomeSubtitles.setBounds(0, 43, 632, 28);
		lblWelcomeSubtitles.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeSubtitles.setFont(new Font("Titillium Web", Font.PLAIN, 14));
		contentPane.add(lblWelcomeSubtitles);
		contentPane.validate();
		setContentPane(contentPane);
		
		menuMain = new JTabbedPane(JTabbedPane.TOP);
		menuMain.setBackground(Color.WHITE);
		menuMain.setBounds(10, 71, 622, 381);
		contentPane.add(menuMain);
		
		schedaConnessione = new JLayeredPane();
		schedaConnessione.setBackground(Color.WHITE);
		menuMain.addTab("Connessione", new ImageIcon(ApplicationHome.class.getResource("/images/1496464261_Black_Connect.png")), schedaConnessione, "connetti ad un broker mqtt");
		menuMain.setBackgroundAt(0, Color.WHITE);
		schedaConnessione.setLayout(null);
		
		lblServer = new JLabel("Server");
		lblServer.setBounds(75, 93, 93, 18);
		schedaConnessione.add(lblServer);
		lblServer.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		
		lblPort = new JLabel("Porta");
		lblPort.setBounds(75, 138, 93, 18);
		schedaConnessione.add(lblPort);
		lblPort.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		
		lblClientID = new JLabel("Client ID");
		lblClientID.setBounds(75, 47, 93, 18);
		schedaConnessione.add(lblClientID);
		lblClientID.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		
		lblConnessioneRiuscita = new JLabel("Sei connesso ad un broker MQTT");
		lblConnessioneRiuscita.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnessioneRiuscita.setBackground(Color.GREEN);
		lblConnessioneRiuscita.setFont(new Font("Titillium Web", Font.PLAIN, 16));
		lblConnessioneRiuscita.setBounds(12, 253, 593, 18);
		schedaConnessione.add(lblConnessioneRiuscita);
		lblConnessioneRiuscita.setVisible(false);
		
		txtClientID = new JTextField();
		txtClientID.setBounds(171, 42, 202, 29);
		schedaConnessione.add(txtClientID);
		txtClientID.setSelectionColor(new Color(0, 255, 0));
		txtClientID.setToolTipText("");
		txtClientID.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		txtClientID.setColumns(10);
		
		txtServer = new JTextField();
		txtServer.setBounds(171, 88, 202, 29);
		schedaConnessione.add(txtServer);
		txtServer.setSelectionColor(new Color(0, 255, 0));
		txtServer.setToolTipText("");
		txtServer.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		txtServer.setColumns(10);
		
		txtPorta = new JTextField();
		txtPorta.setBounds(171, 133, 202, 29);
		schedaConnessione.add(txtPorta);
		txtPorta.setSelectionColor(new Color(0, 255, 0));
		txtPorta.setToolTipText("");
		txtPorta.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		txtPorta.setColumns(10);
		
		btnConnetti = new JButton("Connetti");
		btnConnetti.setBounds(273, 185, 100, 37);
		schedaConnessione.add(btnConnetti);
		btnConnetti.setBackground(new Color(0, 255, 0));
		btnConnetti.setFont(new Font("Titillium Web", Font.BOLD, 15));
		
		schedaTopic = new JLayeredPane();
		schedaTopic.setBackground(Color.WHITE);
		menuMain.addTab("Topic", new ImageIcon(ApplicationHome.class.getResource("/images/1496464273_26_google_trends_topic_featured_service.png")), schedaTopic, "sottoscrivi ad un topic per ricevere ed inviare messaggi");
		schedaTopic.setLayout(null);
		
		lblNomeTopic = new JLabel("Nome Topic:");
		lblNomeTopic.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		lblNomeTopic.setBounds(72, 48, 122, 24);
		schedaTopic.add(lblNomeTopic);
		
		txtNomeTopic = new JTextField();
		txtNomeTopic.setToolTipText("");
		txtNomeTopic.setSelectionColor(Color.GREEN);
		txtNomeTopic.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		txtNomeTopic.setColumns(10);
		txtNomeTopic.setBounds(206, 46, 202, 29);
		schedaTopic.add(txtNomeTopic);
		
		btnSottoscrivi = new JButton("Sottoscrivi");
		btnSottoscrivi.setFont(new Font("Titillium Web", Font.BOLD, 15));
		btnSottoscrivi.setBackground(Color.GREEN);
		btnSottoscrivi.setBounds(242, 108, 166, 37);
		schedaTopic.add(btnSottoscrivi);
		
		txtAreaTopicsSubscribed = new JTextArea();
		txtAreaTopicsSubscribed.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAreaTopicsSubscribed.setFont(new Font("Titillium Web", Font.PLAIN, 13));
		txtAreaTopicsSubscribed.setEditable(false);
		txtAreaTopicsSubscribed.setBounds(32, 186, 568, 129);
		schedaTopic.add(txtAreaTopicsSubscribed);
		
		lblTopicSottoscritti = new JLabel("Topic sottoscritti:");
		lblTopicSottoscritti.setFont(new Font("Titillium Web", Font.PLAIN, 16));
		lblTopicSottoscritti.setBounds(32, 149, 122, 24);
		schedaTopic.add(lblTopicSottoscritti);
		
		JLabel lblqos = new JLabel("QoS:");
		lblqos.setBounds(444, 50, 42, 24);
		schedaTopic.add(lblqos);
		lblqos.setFont(new Font("Titillium Web", Font.PLAIN, 16));
		String qos[] = {"0","1"};
		comboBox = new JComboBox(qos);
		comboBox.setBounds(487, 52, 34, 22);
		schedaTopic.add(comboBox);
		comboBox.setSelectedIndex(0);
		
		schedaMessaggi = new JLayeredPane();
		schedaMessaggi.setBackground(Color.WHITE);
		menuMain.addTab("Messaggi", new ImageIcon(ApplicationHome.class.getResource("/images/1496464290_icons_email.png")), schedaMessaggi, "in questa sezione \u00E9 possibile visualizzare i messaggi ricevuti e inviare messaggi al topic");
		schedaMessaggi.setLayout(null);
		
		lblMsgInviato = new JLabel("Messaggio da inviare:");
		lblMsgInviato.setFont(new Font("Titillium Web", Font.PLAIN, 16));
		lblMsgInviato.setBounds(51, 13, 160, 24);
		schedaMessaggi.add(lblMsgInviato);
		
		txtMsgInviato = new JTextField();
		txtMsgInviato.setToolTipText("");
		txtMsgInviato.setSelectionColor(Color.GREEN);
		txtMsgInviato.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		txtMsgInviato.setColumns(10);
		txtMsgInviato.setBounds(223, 9, 202, 29);
		schedaMessaggi.add(txtMsgInviato);
		
		btnInvia = new JButton("Invia");
		btnInvia.setFont(new Font("Titillium Web", Font.BOLD, 15));
		btnInvia.setBackground(Color.GREEN);
		btnInvia.setBounds(434, 11, 93, 28);
		schedaMessaggi.add(btnInvia);
		
		lblMsgRicevuti = new JLabel("Messaggi ricevuti:");
		lblMsgRicevuti.setFont(new Font("Titillium Web", Font.PLAIN, 16));
		lblMsgRicevuti.setBounds(51, 82, 160, 24);
		schedaMessaggi.add(lblMsgRicevuti);
		
		txtAreaMsgRicevuti = new JTextArea();
		txtAreaMsgRicevuti.setSelectionColor(Color.GREEN);
		txtAreaMsgRicevuti.setFont(new Font("Titillium Web", Font.PLAIN, 13));
		txtAreaMsgRicevuti.setEditable(false);
		txtAreaMsgRicevuti.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAreaMsgRicevuti.setBounds(30, 105, 568, 197);
		
		
		contenitoreMsgRicevuti = new JScrollPane(txtAreaMsgRicevuti);
		contenitoreMsgRicevuti.setBounds(30, 105, 568, 197);
		schedaMessaggi.add(contenitoreMsgRicevuti);
		

		schedaGuida = new JLayeredPane();
		menuMain.addTab("Guida", new ImageIcon(ApplicationHome.class.getResource("/images/1496464315_thefreeforty_map.png")), schedaGuida, null);
		
		lblGuidaUno = new JLabel("guida all'applicazione MQTT CLIENT");
		lblGuidaUno.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuidaUno.setFont(new Font("Titillium Web", Font.BOLD, 18));
		lblGuidaUno.setBounds(0, 0, 632, 28);
		schedaGuida.add(lblGuidaUno);
		
		txtareaGuida = new JTextArea();
		txtareaGuida.setText("[1] per connettersi al broker inserire nella scheda 'Connessione' tutti i dati relativi al broker \r\nMQTT e di conseguenza premere il tasto 'Connetti'\r\n[2] per sottoscriversi al topic inserire il nome del topic nel campo apposito situato nella \r\nscheda Topic e premere il tasto 'Sottoscrivi'. \u00C9 possibile sottoscriversi a pi\u00FA topic. I topic \r\nsottoscritti saranno visualizzati nell'area in basso della scheda.\r\n[3] per inviare e ricevere messaggi del topic sottoscritto occorre recarsi nella scheda \r\n\"Messaggi\". \r\nEsso sar\u00E1 inviato all'ultimo topic sottoscritto, mentre i messaggi ricevuti sono relativi \r\na tutti i topic sottoscritti.");
		txtareaGuida.setFont(new Font("Titillium Web", Font.PLAIN, 15));
		txtareaGuida.setEditable(false);
		txtareaGuida.setBounds(10, 29, 595, 285);
		schedaGuida.add(txtareaGuida);
		
		schedaInformazioni = new JLayeredPane();
		menuMain.addTab("Informazioni", new ImageIcon(ApplicationHome.class.getResource("/images/1496464326_info.png")), schedaInformazioni, null);
		
		lblInfoUno = new JLabel("Informazioni sull'applicazione MQTT CLIENT");
		lblInfoUno.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoUno.setFont(new Font("Titillium Web", Font.BOLD, 18));
		lblInfoUno.setBounds(12, 0, 632, 28);
		schedaInformazioni.add(lblInfoUno);
		
		txtareaInformazioni = new JTextArea();
		txtareaInformazioni.setText("realizzato da Umberto Di Canito, Enzo Pio Palmisano\r\nemail: info@lowboys.it\r\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\r\nprogetto di Calcolatori Elettronici e Reti Di Calcolatori\r\ndocente: Adriano Mancini\r\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\r\nUniversit\u00E0 politecnica delle Marche\r\nVia Brecce Bianche, 10 \r\nMonte Dago, Ancona\r\n60131");
		txtareaInformazioni.setFont(new Font("Titillium Web", Font.PLAIN, 16));
		txtareaInformazioni.setEditable(false);
		txtareaInformazioni.setBounds(124, 41, 409, 273);
		schedaInformazioni.add(txtareaInformazioni);
		
	}
	
	//Inizio dei metodi set e get	
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
	
	public JLabel getlblConnessioneRiuscita(){
		return lblConnessioneRiuscita;
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
	
	public JButton getBtnSottoscrivi(){
		return btnSottoscrivi;
	}
	
	public JTextField getTxtNomeTopic(){
		return txtNomeTopic;
	}
	
	public JTextArea getTxtAreaTopicsSubscribed(){
		return txtAreaTopicsSubscribed;
	}
	
	public JTextField getTxtMsgInviato(){
		return txtMsgInviato;
	}
	
	public JButton getBtnInvia(){
		return btnInvia;
	}
	
	public JTextArea getTxtAreaMsgRicevuti(){
		return txtAreaMsgRicevuti;
	}
	
	public ButtonGroup getButtonGroup(){
		return buttonGroup;
	}
	
	public JComboBox getComboBox(){
		
		return comboBox;
	}
}
