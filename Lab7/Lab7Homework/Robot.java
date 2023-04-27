package org.example;
import java.util.concurrent.ThreadLocalRandom;
public class Robot implements Runnable{
    private String name;
    private boolean running;
    private int count = 0;
    Exploration explore;

    public Robot(String name) {
        this.name = name;
    }
    //...

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Exploration getExplore() {
        return explore;
    }
    public void setExplore(Exploration explore) {
        this.explore = explore;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }
    public boolean getRunning()
    {
        return running;
    }

    public void run() {

        int row = 0;
        int col = 0;

        while (running) {

            explore.getMap().visit(row, col, this);

            if(row < explore.getMap().getMatrix().length)
                count += explore.getMap().getTokensCount(row, col);

            col++;

            if(col == explore.getMap().getMatrix().length) {
                col = 0;
                row++;
            }

            //make the robot sleep for some time
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(explore.getMap().isFull() == true)
            {
                running = false;
                System.out.println("Robot " + name + " placed " + count + " tokens in the matrix");
                System.out.println("FINISHED!");
            }
        }
    }

}
