package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

import model.Connessione;
import view.ApplicationHome;
import view.PanelConnesso;

public class ControllerMainPage implements ActionListener {

	private Connessione nuovaConnessione;
	private ApplicationHome finestraMain;
	private PanelConnesso pannelloConnessione;
	
	public  ControllerMainPage (){
		
	    nuovaConnessione = new Connessione();
		finestraMain = new  ApplicationHome();
		finestraMain.setVisible(true);
		pannelloConnessione = new PanelConnesso();
		finestraMain.getBtnConnetti().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.updateView();
	}
	
	private void updateView() {
		
		try {
			nuovaConnessione.connect(finestraMain.getTxtClientID().getText(), finestraMain.getTxtServer().getText(), 
					finestraMain.getTxtPorta().getText());
		} catch (MqttSecurityException e) {
			JOptionPane d=new JOptionPane();
            d.setFont(new java.awt.Font("Tahoma", 0, 12));
            d.showMessageDialog(null, "Errore di Connessione, Riprova!", "ERRORE",  
            		JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (MqttException e) {
			JOptionPane d=new JOptionPane();
            d.setFont(new java.awt.Font("Tahoma", 0, 12));
            d.showMessageDialog(null, "Errore di Connessione, Riprova!", "ERRORE",  
            		JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		finestraMain.getContentPane().setVisible(false);
		finestraMain.setContentPane(pannelloConnessione);
		finestraMain.getContentPane().setVisible(true);
		
	}
	

}
