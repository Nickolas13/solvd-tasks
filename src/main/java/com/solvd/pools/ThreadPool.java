package com.solvd.pools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool implements Runnable {
    private String name;

    public ThreadPool(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Runnable one = new ThreadPool("task 1");
        Runnable two = new ThreadPool("task 2");
        Runnable three = new ThreadPool("task 3");
        Runnable four = new ThreadPool("task 4");
        Runnable five = new ThreadPool("task 5");
        Runnable six = new ThreadPool("task 6");
        Runnable seven = new ThreadPool("task 7");

        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.execute(one);
        pool.execute(two);
        pool.execute(three);
        pool.execute(four);
        pool.execute(five);
        pool.execute(six);
        pool.execute(seven);

        pool.shutdown();

    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Date d = new Date();
                SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
                if (i == 0) {
                    System.out.println("Init time for task name: " + name + " = " + format.format(d));

                } else {
                    System.out.println("Execution time for task name: " + name + " = " + format.format(d));

                }
                Thread.sleep(1000);

            }
            System.out.println(name + "finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
