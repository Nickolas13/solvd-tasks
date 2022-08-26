package com.solvd.pools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTask {
    private static final Logger logger = LogManager.getLogger(FutureTask.class);
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
                logger.info((i + 1) + " : " + result);
//                System.out.println("Result " + (i + 1) + ": " + result);

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        example.shutdown();
    }
}
