package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exploration {

    private final SharedMemory mem = new SharedMemory(5);
    private final ExplorationMap map = new ExplorationMap(5);
    private final List<Robot> robots = new ArrayList<>();

    public void start() {
        TimeKeeper timeKeeper = new TimeKeeper(5000); // 5 second time limit
        timeKeeper.start();

        for (Robot robot : robots) {
            //start a new Thread representing the robot;
            robot.setRunning(true);
            robot.setExplore(this);
            new Thread(robot).start();
        }
    }

    public void startRobot(Robot robotToStart) {
        for(Robot robot : robots)
        {
            if(robot.getName().equals(robotToStart.getName()))
            {
                robot.setRunning(true);
                robot.setExplore(this);
                new Thread(robot).start();
            }
        }
    }

    public void pause()
    {
        for(Robot robot : robots)
        {
            robot.setRunning(false);
        }
    }

    public void pauseRobot(Robot robotToPause, int seconds) {
        for(Robot robot : robots)
        {
            if(robot.getName().equals(robotToPause.getName()))
            {
                robot.setRunning(false);
                try {
                    Thread.sleep(seconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                robot.setRunning(true);
                robot.setExplore(this);
                new Thread(robot).start();
            }
        }
    }

    public void pauseRobot(Robot robotToPause)
    {
        for(Robot robot : robots)
        {
            if(robot.getName().equals(robotToPause.getName()))
            {
                robot.setRunning(false);
            }
        }
    }
    public static void main(String args[]) {

        var explore = new Exploration();

        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));

        //explore.start();

        Scanner sc = new Scanner(System.in); //System.in is a standard input stream

        while(true) {

            System.out.print("Enter a command: ");
            String command = sc.nextLine();  //reads string
            System.out.print("You have entered: " + command);
            String[] commandParts = command.split(" ");

            if(commandParts[0].equals("start_all")) {
                explore.start();
            }
            else if(commandParts[0].equals("start")) {
                explore.startRobot(new Robot(commandParts[1]));
            }
            else if(commandParts[0].equals("pause_all")) {
                explore.pause();
            }
            else if(commandParts[0].equals("pause")) {
                if(commandParts.length == 2)
                {
                    explore.pauseRobot(new Robot(commandParts[1]));
                }
                else if(commandParts.length == 3)
                {
                    explore.pauseRobot(new Robot(commandParts[1]), Integer.parseInt(commandParts[2]));
                }
            }
            else if(commandParts[0].equals("exit")) {
                break;
            }
        }
    }

    public void addRobot(Robot toAdd)
    {
        robots.add(toAdd);
    }
    public ExplorationMap getMap() {
        return map;
    }
    public SharedMemory getMem() {
        return mem;
    }
}

