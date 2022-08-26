package com.solvd.pools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Completable {
    private static final Logger logger = LogManager.getLogger(Completable.class);
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Executor executor = Executors.newFixedThreadPool(5);
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
//        System.out.println(callback.get());
    }


}
