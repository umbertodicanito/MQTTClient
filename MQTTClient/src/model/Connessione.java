package model;


import java.sql.Timestamp;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import view.ApplicationHome;

public class Connessione implements MqttCallback{
	private String clientID;
	private String server;
	private String porta;
	private MqttClient sampleClient;
	private int QoS;
	private String topic;
	private String messaggioRicevuto;
	private ApplicationHome finestra;
	
	/* Costruttore di default */
	public Connessione(ApplicationHome  nuovaFinestra) {
		
		clientID = "Nessun clientID";
		server = "Nessun server";
		porta = "Nessuna porta";
		QoS = 0;
		topic = "Nessun topic";
		messaggioRicevuto = "Nessun messaggio";
		finestra = nuovaFinestra;
	}
	
	/* Costruttore */
	public Connessione (String nuovoClientID, String nuovoServer, String nuovaPorta,
			int nuovoQoS, String nuovoTopic, String nuovoMessaggio,ApplicationHome nuovaFinestra){
		clientID = nuovoClientID;
		server = nuovoServer;
		porta = nuovaPorta;
		QoS = nuovoQoS;
		topic = nuovoTopic;
		messaggioRicevuto = nuovoMessaggio;
		finestra = nuovaFinestra;
	}
	
	
	
	/* metodo che permette la connessione MQTT inserendo un client, un server ed una porta */
	public void connect(String clientID, String server, String porta) throws MqttSecurityException, MqttException{
		 MemoryPersistence persistence = new MemoryPersistence();
		 String uri="tcp://"+server+":"+porta;
		 sampleClient = new MqttClient(uri, clientID, persistence);
         MqttConnectOptions connOpts = new MqttConnectOptions();
         connOpts.setCleanSession(true);
         sampleClient.connect(connOpts);
         
         sampleClient.setCallback(this);
         
	}
	

	/* Metodo per la sottoscrizione ad un topic */
	public void subscribe(String topic, int qos) throws MqttException{
		
	    sampleClient.subscribe(topic, qos);

	}
	
	/* Metodo per l'invio di messaggi al topic */
	public void publish(String topic,MqttMessage message) throws MqttPersistenceException, MqttException{
		
		sampleClient.publish(topic, message);
		
	}
	
	/* Metodo per ricevere messaggi da un topic di un broker 
	 * È una funzione callback, chiamata ogni volta che riceve un messaggio da un topic */
	public void messageArrived(String topic, MqttMessage message) throws MqttException {
		
		String time = new Timestamp(System.currentTimeMillis()).toString();
		messaggioRicevuto = ("Time:" +time +
                           " Topic: " + topic +
                           " Message: " + new String(message.getPayload()) +
                           " QoS: " + message.getQos());
		finestra.getTxtAreaMsgRicevuti().append(messaggioRicevuto+"\n");
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
	
	public MqttClient getSampleClient(){
		return sampleClient;
	}
	
	public int getQoS() {
		return QoS;
	}

	public void setQoS(int qoS) {
		QoS = qoS;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getMessaggioRicevuto() {
		return messaggioRicevuto;
	}

	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub
		
	}
}
