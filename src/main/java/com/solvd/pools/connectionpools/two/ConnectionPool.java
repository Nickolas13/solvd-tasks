package com.solvd.pools.connectionpools.two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger(ConnectionPool.class);

    public static void main(String[] args) throws SQLException, InterruptedException {
        AnimalManagement management = new AnimalManagement();
        ExecutorService service = Executors.newFixedThreadPool(5);

//        IntStream.rangeClosed(1, 7)
//                .mapToObj(i -> (Runnable) () -> {
//                    check("is running");
//                    management.addAnimal("arina", "eagle", 200, 30, 50);
//                }).forEach(r -> service.submit(r));


        for (int i = 1; i <= 7; i++) {
            service.submit(() -> {
                check("running");
                management.addAnimal("bob", "penguin", 200, 30, 50);
            });
        }

//        logger.info(management.getAnimals());

        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);
        management.closeSource();
    }

    private static void check(String msg) {
        System.out.println(Thread.currentThread().getName() + " - " + msg);
    }
}
