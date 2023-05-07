package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public GameClient(String serverAddress, int serverPort) throws IOException {
        socket = new Socket(serverAddress, serverPort);
        System.out.println("Connected to server: " + socket.getInetAddress().getHostAddress());

        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(socket.getOutputStream(), true);
    }

    public void start() {
        try {
            String command;
            while (true) {
                System.out.print("Enter a command (or 'exit' to quit): ");
                command = reader.readLine();

                if (command.equals("exit")) {
                    break;
                }

                writer.println(command);
                String response = readResponse();

                System.out.println("Server response: " + response);
            }

            socket.close();
            System.out.println("Disconnected from server.");
        } catch (IOException e) {
            System.out.println("Error communicating with the server: " + e.getMessage());
        }
    }

    private String readResponse() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return input.readLine();
    }
}
