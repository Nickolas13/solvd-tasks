package com.solvd.pools;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Completable {

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
        System.out.println(callback.get());
    }


}
