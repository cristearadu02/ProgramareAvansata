package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/lab8";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;
    private Database() {
        if (connection != null) {
            throw new IllegalStateException("Already initialized.");
        }

    }
    public static Connection getConnection() {
        //TODO
        if (connection == null) {
            createConnection();
        }
        return connection;
    }
    private static void createConnection() {
        try {
            //TODO
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void closeConnection() {
        //TODO
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
         }
}