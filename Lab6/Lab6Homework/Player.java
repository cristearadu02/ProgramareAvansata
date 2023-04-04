package Homework;

import java.util.ArrayList;
import java.util.List;
public class Player {
    private String name;
    private List<Line> lines;

    public Player(String name) {
        this.name = name;
        lines = new ArrayList<>();

    }
    public String getName() {
        return name;
    }
    public void addLine(Line toAdd)
    {
        lines.add(toAdd);
    }
    public boolean checkWin()
    {
        if(lines.size()<3)
            return false;
        //check if the player has lines to make a triangle
       for(int i = 0; i<lines.size()-2; i++)
       {
           for(int j = i+1; j<lines.size()-1; j++)
           {
               for(int k = j+1; k<lines.size(); k++)
               {
                   if(lines.get(i).isConnected(lines.get(j)) && lines.get(j).isConnected(lines.get(k)) && lines.get(i).isConnected(lines.get(k)))
                       return true;
               }
           }
       }
        return false;
    }
}

