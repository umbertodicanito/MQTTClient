package model;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/* Costruzione del socket per testare la connessione del pc*/
public class CheckConnection {

    public static boolean check() throws IOException {
        String site = "www.google.it";
        try (Socket socket = new Socket()) {
            InetSocketAddress addr = new InetSocketAddress(site, 80);
            socket.connect(addr, 3000);
            return socket.isConnected();
        }
    }

}