package com.solvd.other.multithreading;

public class MultiThread {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Threads example = new Threads(i);
            Thread threadObj = new Thread(example);
            threadObj.start();
            threadObj.isAlive();
        }

    }
}
