package model;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Connessione {
	private String clientID;
	private String server;
	private String porta;
	
	/* Costruttore di default */
	public Connessione() {
		
		clientID = "Nessun clientID";
		server = "Nessun server";
		porta = "Nessuna porta";
	}
	
	/* Costruttore */
	public Connessione (String nuovoClientID, String nuovoServer, String nuovaPorta){
		clientID = nuovoClientID;
		server = nuovoServer;
		porta = nuovaPorta;
	}
	
	
	
	/* metodo che permette la connessione MQTT inserendo un client, un server ed una porta */
	public void connect(String clientID, String server, String porta) throws MqttSecurityException, MqttException{
		 MemoryPersistence persistence = new MemoryPersistence();
		 String uri="tcp://"+server+":"+porta;
		 MqttClient sampleClient = new MqttClient(uri, clientID, persistence);
         MqttConnectOptions connOpts = new MqttConnectOptions();
         connOpts.setCleanSession(true);
         sampleClient.connect(connOpts);
         
	}
	
	
	
	/* Metodi GET/SET per accedere agli attributi di Connessione */
	public String getClientID() {
		return clientID;
	}

	public void setClientID (String clientID) {
		this.clientID = clientID;
	}

	public String getServer() {
		return server;
	}

	public void setServer (String server) {
		this.server = server;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta (String porta) {
		this.porta = porta;
	}
	
	
}
