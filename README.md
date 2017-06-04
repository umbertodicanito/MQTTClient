# MQTTClient

_Project of Electronic Computer and Computer network course. Developers: U. Di Canito, E.Palmisano. email:info@lowboys.it_


Application implemented is a simple MQTT client that allows:

  - Broker Connection
  - Topic Subscribe
  - View messages received from topic
  - Send messages to topic

Application is written in Java using Paho library  

# Project Structure

The project is developed following the MVC design pattern.
Application's model is represented by connection and a controller manage each view events.
The project is structured with following method:

![](https://s7.postimg.org/lytyhkn2z/cattura1.png)

Class Project are 5.
In the model there is a class that manages connection and CheckConnection class.
Check Connection instance an object that verify internet connection thanks to a socket.
In Connection there are methods to connect to a broker,subscribe topic,send and receive messages.

In the controller there is a class ControllerMainPage that manages view events.

In the view there is a class that builds a JFrame.

Main class contains only main method that initializes controller.




