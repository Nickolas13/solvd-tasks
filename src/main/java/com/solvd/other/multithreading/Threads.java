package com.solvd.other.multithreading;

public class Threads implements Runnable {

    private int threadId;

    public Threads(int threadId) {
        this.threadId = threadId;
    }


    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(i + " thread id: " + threadId);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
