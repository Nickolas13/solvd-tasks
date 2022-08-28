package com.solvd.pools;

import com.solvd.pools.Print;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

public class CompletableStage {
    private static final Logger logger = LogManager.getLogger(CompletableStage.class);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletionStage<Void> stage = CompletableFuture.runAsync(() -> example("one"), executor);
        stage = stage.thenRunAsync(() -> example("two"), executor);
        stage = stage.thenRunAsync(() -> example("three"), executor);
        stage = stage.thenRunAsync(() -> example("four"), executor);
        stage = stage.thenRunAsync(() -> example("five"), executor);
//        ((CompletableFuture) stage).join();
        stage = stage.thenRunAsync(() -> example("six"), executor);
        stage = stage.thenRunAsync(() -> example("seven"), executor);

        //Casting to CompletableFuture
        ((CompletableFuture) stage).join();


        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }
            return "completable future";
        }, executor);

        CompletableFuture<String> callback = future.thenApply(str -> {
            return "result = " + str;
        }).thenApply(result -> result + " Welcome to async java");

        logger.info(callback.get());
    }


    private static void example(String stage) {
        logger.info("running " + stage + " " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
