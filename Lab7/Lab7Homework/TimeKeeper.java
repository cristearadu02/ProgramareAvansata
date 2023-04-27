package org.example;

public class TimeKeeper extends Thread {
    private final long timeLimit;
    private long startTime;
    private boolean stop;

    public TimeKeeper(long timeLimit) {
        this.timeLimit = timeLimit;
        this.startTime = System.currentTimeMillis();
        this.stop = false;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (!stop) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println("Elapsed Time: " + elapsedTime / 1000 + " seconds");

            if (elapsedTime >= timeLimit) {
                System.out.println("Time limit of " + timeLimit / 1000 + " seconds has been reached. Stopping exploration...");
                stop = true;
            }

            try {
                Thread.sleep(1000); // update every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

