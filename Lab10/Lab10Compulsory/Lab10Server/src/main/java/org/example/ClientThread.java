package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {

    private Socket clientSocket;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            String request;
            while ((request = input.readLine()) != null) {
                if (request.equals("stop")) {
                    output.println("Server stopped");
                    break;
                } else {
                    String response = "Server received the request: " + request;
                    System.out.println(response);
                    output.println(response);
                }
            }

            clientSocket.close();
            System.out.println("Client disconnected: " + clientSocket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            System.out.println("Error handling client request: " + e.getMessage());
        }
    }
}
