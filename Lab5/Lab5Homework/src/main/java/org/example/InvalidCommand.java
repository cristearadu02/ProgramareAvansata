package org.example;

public class InvalidCommand extends Exception{
    public InvalidCommand(String msg)
    {
        System.err.println("Invalid call of command" + msg);
    }
}
