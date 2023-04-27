package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Token> tokenList;

    Cell()
    {
        tokenList = new ArrayList<>();
    }
    Cell(List<Token> toAdd)
    {
        tokenList = new ArrayList<>(toAdd);
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }
}
