package model;

public class SottoscrizioneTopic extends Connessione {
	
	private int QoS;
	private String topic;
	private String messaggio;
	
	/* Costruttore di default */
	public SottoscrizioneTopic(){
		super();
		QoS = 0;
		topic = "nessun topic";
		messaggio = "nessun messaggio";

	}
	
	/* Costruttore */
	public SottoscrizioneTopic (String nuovoClientID, String nuovoServer, String nuovaPorta, int nuovoQoS, String nuovoTopic, String nuovoMessaggio){
		super(nuovoClientID, nuovoServer, nuovaPorta);
		QoS = nuovoQoS;
		topic = nuovoTopic;
		messaggio = nuovoMessaggio;
	}
	
	
	public void subscribe(){
		
	}
	
	/* Metodi GET/SET */
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

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
}
