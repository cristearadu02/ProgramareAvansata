package org.example;

import java.io.IOException;

public class ServerApplication {

    public static void main(String[] args) {
        int port = 6970; // Specify the desired port number

        try {
            GameServer gameServer = new GameServer(port);
            gameServer.start();
        } catch (IOException e) {
            System.out.println("Error starting the server: " + e.getMessage());
        }
    }
}




