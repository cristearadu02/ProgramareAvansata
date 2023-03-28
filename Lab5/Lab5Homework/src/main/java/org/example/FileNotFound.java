package org.example;

public class FileNotFound extends Exception{

    public FileNotFound()
    {
        System.out.println("The file you try to open doesn't exists. ");
    }
}
