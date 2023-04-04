package org.example;

public class Token {
    private final int number;

//constructor
    Token(int n)
    {
        number = n;
    }

//getters
    public int getNumber() {
        return number;
    }

//toString
    @Override
    public String toString() {
        return "Token{" +
                "number=" + number +
                '}';
    }

}
