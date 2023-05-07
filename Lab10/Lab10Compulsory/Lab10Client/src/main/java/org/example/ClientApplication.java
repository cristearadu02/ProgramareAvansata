package org.example;

import java.io.IOException;

public class ClientApplication {

    public static void main(String[] args) {
        String serverAddress = "localhost"; // Specify the server address
        int serverPort = 6970; // Specify the server port number

        try {
            GameClient gameClient = new GameClient(serverAddress, serverPort);
            gameClient.start();
        } catch (IOException e) {
            System.out.println("Error connecting to the server: " + e.getMessage());
        }
    }
}



