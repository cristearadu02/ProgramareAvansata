package org.example;

import java.util.ArrayList;
import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;
    //Cell should be a wrapper or alias for List<Token>
    public ExplorationMap(int n) {
        matrix = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Cell();
            }
        }
    }
    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            //the cell is not visited
            if (matrix[row][col].getTokenList().isEmpty() == true)
                 {
                //the robot extract tokens
                List<Token> extracted = new ArrayList<>();
                extracted = robot.getExplore().getMem().extractTokens(matrix.length);
                //and store the tokens in the cell (it becomes visited)
                matrix[row][col].setTokenList(extracted);
                //display a success message
                System.out.println("["+ row + "][" + col + "]"+ "Robot " + robot.getName() + " extracted and stored successfully " + matrix[row][col].getTokenList().size() + " tokens -> " + matrix[row][col].getTokenList());
                return true;
            } //...
        }
        // ...
        return false;
    }

    public int getTokensCount(int row, int col)
    {
        return matrix[row][col].getTokenList().size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean isFull()
    {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j].getTokenList().isEmpty() == true)
                    return false;
            }
        }
        return true;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }
}
