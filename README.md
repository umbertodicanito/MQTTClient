# MQTTClient

_Project of Electronic Computer and Computer networks course. Developers: U. Di Canito, E.Palmisano.


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

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.




