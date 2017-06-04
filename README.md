#MQTTClient

_Progetto di calcolatori elettronici e reti di calcolatori. U. Di Canito, E.Palmisano._

L'applicazione realizzata è un semplice client MQTT che permette:

  - Connessione ad un broker

  - Sottoscrizione ai topic

  - Visualizzare i messaggi ricevuti sui topic

  - Inviare messaggi ai topic
  
L'applicazione realizzata è scritta in Java utilizzando le librerie Paho.

**Struttura del progetto **

Il progetto è sviluppato seguendo il design pattern MVC.
Il model dell'applicazione è rappresentato dalla connessione mentre un controller gestisce tutti gli eventi della view.
Il progetto quindi è così strutturato:
![Immagine del progetto](https://ibb.co/iDKhDF)
