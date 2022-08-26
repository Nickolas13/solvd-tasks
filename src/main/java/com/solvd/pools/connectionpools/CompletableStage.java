package com.solvd.pools.connectionpools;

import com.solvd.pools.Print;

import java.util.concurrent.*;

public class CompletableStage {
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
        ((CompletableFuture) stage).join();
    }

    private static void example(String stage) {
        System.out.println("running " + stage + " " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
