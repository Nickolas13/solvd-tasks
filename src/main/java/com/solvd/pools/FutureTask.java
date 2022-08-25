package com.solvd.pools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTask {
    public static void main(String[] args) {
        ExecutorService example = Executors.newFixedThreadPool(5);

        List<Future> futures = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            Future<Integer> future = example.submit(new Print());
            futures.add(future);
        }

        for (int i = 0; i < 7; i++) {
            Future<Integer> future = futures.get(i);
            try {
                //getting future value
                Integer result = future.get();
                System.out.println("Result " + (i + 1) + ": " + result);

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        example.shutdown();
    }
}
