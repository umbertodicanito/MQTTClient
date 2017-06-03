package controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

import model.CheckConnection;
import model.Connessione;
import view.ApplicationHome;

/*
 * Controller: gestisce tutti gli eventi della gui in correlazione con il model(la connessione)
 * 
 */
public class ControllerMainPage implements ActionListener {

	private Connessione nuovaConnessione;
	private ApplicationHome finestraMain;
	private CheckConnection connessioneTest;
	private int ore,minuti,secondi;
	private int qos=0;
	MqttMessage messaggio;
	
	//Costruttore
	public  ControllerMainPage (){
		
	    nuovaConnessione = new Connessione(finestraMain);
		finestraMain = new ApplicationHome();
		finestraMain.setVisible(true);
		//Il metodo test, controlla se vi è la connessione ad internet
		//Avvisa l'utente nel caso in cui non c'è una connessione
		this.metodotest();
		//costruzione della connessione
		nuovaConnessione = new Connessione(finestraMain);
		//aggiungo un listener agli eventi
		finestraMain.getBtnConnetti().addActionListener(this);
		finestraMain.getBtnSottoscrivi().addActionListener(this);
		finestraMain.getBtnInvia().addActionListener(this);
		
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/* azione sul pulsante Connetti */
		if(e.getActionCommand().equals("Connetti")){
			try {
			
				nuovaConnessione.connect(finestraMain.getTxtClientID().getText(), finestraMain.getTxtServer().getText(), 
						finestraMain.getTxtPorta().getText());
				JOptionPane.showMessageDialog(finestraMain, "Connessione riuscita!");
				//se la connessione è riuscita appare una label
				finestraMain.getlblConnessioneRiuscita().setVisible(true);
			
					
				} catch (MqttSecurityException ee) {
					JOptionPane d=new JOptionPane();
					d.setFont(new java.awt.Font("Tahoma", 0, 12));
					d.showMessageDialog(null, "Errore di Connessione, Riprova!", "",  
            		JOptionPane.ERROR_MESSAGE);
					ee.printStackTrace();
				} catch (MqttException ee) {
					JOptionPane d=new JOptionPane();
					d.setFont(new java.awt.Font("Tahoma", 0, 12));
					d.showMessageDialog(null, "Errore di Connessione, Riprova!", "",  
            		JOptionPane.ERROR_MESSAGE);
					ee.printStackTrace();
				}
		
			}
		
		/* azione sul pulsante Sottoscrivi */
		if(e.getActionCommand().equals("Sottoscrivi")){
			
			try {
				 
				//prendo le ore i minuti e i secondi
				ore = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
				minuti = Calendar.getInstance().get(Calendar.MINUTE); 
				secondi = Calendar.getInstance().get(Calendar.SECOND); 
				String sessione =ore + ":" + minuti + ":" + secondi;
				
				//prelevo la selezione della combobox del qos
				String selectedItem = (String)finestraMain.getComboBox().getSelectedItem();
				qos = Integer.parseInt(selectedItem);
				//sottoscrizione al topic
				nuovaConnessione.subscribe(finestraMain.getTxtNomeTopic().getText(), qos);
				finestraMain.getTxtAreaTopicsSubscribed().append("["+ sessione +"]"+" Sei sottoscritto al topic: " +
						finestraMain.getTxtNomeTopic().getText()+"\n");
				
			} catch (MqttException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane d=new JOptionPane();
				d.setFont(new java.awt.Font("Tahoma", 0, 12));
				d.showMessageDialog(null, "Errore di Sottoscrizione al topic, Riprova!", "",  
        		JOptionPane.ERROR_MESSAGE);
			}
		}
		
		/* azione sul pulsante Invia */
		if(e.getActionCommand().equals("Invia")){
			
			//converto il messaggio in un messaggio MQTT
			messaggio = new MqttMessage(finestraMain.getTxtMsgInviato().getText().getBytes());
			
			try {
				nuovaConnessione.publish(finestraMain.getTxtNomeTopic().getText(), messaggio);
			} catch (MqttException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane d=new JOptionPane();
				d.setFont(new java.awt.Font("Tahoma", 0, 12));
				d.showMessageDialog(null, "Errore di invio nel messaggio nel topic, Riprova!", "",  
        		JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	/* metodo che testa la connessione ad internet GENERALE del pc
	 * Utilizza il metodo check del model
	 */
	public void metodotest(){
		try {
			if(!connessioneTest.check()) {
				JOptionPane d=new JOptionPane();
			    d.setFont(new java.awt.Font("Tahoma", 0, 12));
			    d.showMessageDialog(null, "No connessione internet", "",  
			    		JOptionPane.ERROR_MESSAGE);
			}
		} catch (HeadlessException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
