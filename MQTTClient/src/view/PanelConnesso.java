package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelConnesso extends JPanel {
	private JTextField textFieldTopic;
	private JLabel lblCLIENTIDdinamic;
	private JLabel lblServer;
	private JRadioButton rdbtnQoS0;
	private JRadioButton rdbtnQoS1;
	private JRadioButton rdbtnQoS2;
	private JButton btnSubscribe;
	private JButton btnIndietro;
	/**
	 * Create the panel.
	 */
	public PanelConnesso() {
		setLayout(null);
		
		JLabel lblSeiConnessoAl = new JLabel("Sei connesso al broker");
		lblSeiConnessoAl.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		lblSeiConnessoAl.setBounds(12, 44, 189, 32);
		add(lblSeiConnessoAl);
		
		lblServer = new JLabel("server");
		lblServer.setFont(new Font("Titillium Web", Font.BOLD, 20));
		lblServer.setForeground(new Color(0, 255, 0));
		lblServer.setBounds(212, 44, 56, 32);
		add(lblServer);
		
		JLabel lblSubscribeWelcome = new JLabel("Benvenuto, ");
		lblSubscribeWelcome.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		lblSubscribeWelcome.setBounds(12, 0, 101, 36);
		add(lblSubscribeWelcome);
		
		lblCLIENTIDdinamic = new JLabel("CLIENTIDDINAMIC");
		lblCLIENTIDdinamic.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		lblCLIENTIDdinamic.setBounds(112, 0, 178, 36);
		add(lblCLIENTIDdinamic);
		
		JLabel lblOraPuoiSottoscriverti = new JLabel("Ora puoi sottoscriverti ad un Topic. Inserisci il topic e QoS");
		lblOraPuoiSottoscriverti.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		lblOraPuoiSottoscriverti.setBounds(12, 80, 490, 32);
		add(lblOraPuoiSottoscriverti);
		
		JLabel lblTopic = new JLabel("Topic");
		lblTopic.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		lblTopic.setBounds(98, 129, 101, 36);
		add(lblTopic);
		
		textFieldTopic = new JTextField();
		textFieldTopic.setBounds(179, 139, 116, 22);
		add(textFieldTopic);
		textFieldTopic.setColumns(10);
		
		rdbtnQoS0 = new JRadioButton("0");
		rdbtnQoS0.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		rdbtnQoS0.setBounds(179, 200, 47, 22);
		add(rdbtnQoS0);
		
		rdbtnQoS1 = new JRadioButton("1");
		rdbtnQoS1.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		rdbtnQoS1.setBounds(227, 199, 41, 25);
		add(rdbtnQoS1);
		
		rdbtnQoS2 = new JRadioButton("2");
		rdbtnQoS2.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		rdbtnQoS2.setBounds(272, 199, 41, 25);
		add(rdbtnQoS2);
		
		JLabel lblQos = new JLabel("QoS");
		lblQos.setFont(new Font("Titillium Web", Font.PLAIN, 20));
		lblQos.setBounds(98, 197, 56, 20);
		add(lblQos);
		
		btnSubscribe = new JButton("Sottoscrivi");
		btnSubscribe.setFont(new Font("Titillium Web", Font.BOLD, 15));
		btnSubscribe.setBackground(Color.GREEN);
		btnSubscribe.setBounds(283, 274, 107, 36);
		add(btnSubscribe);
		
		btnIndietro = new JButton("Indietro");
		btnIndietro.setFont(new Font("Titillium Web", Font.BOLD, 15));
		btnIndietro.setBackground(Color.GREEN);
		btnIndietro.setBounds(416, 274, 97, 36);
		add(btnIndietro);

	}
}
