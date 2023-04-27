package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SharedMemory {
    private final List<Token> tokens; //declare a collection of tokens;
    public SharedMemory(int n) {
        //add all tokens to the collection and shuffle them;
        tokens = new ArrayList<>();
        for(int i = 0; i<n*n*n; i++)
            tokens.add(new Token(i+1));
        Collections.shuffle(tokens);
    }
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty() == true) {
                break;
            }
            if(i<tokens.size()) {
                extracted.add(tokens.get(i));
                tokens.remove(i);
            }
        }
        return extracted;
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
