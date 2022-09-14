package com.solvd.pools.connectionpools.two;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, InterruptedException {
        ConnectionPool management = new ConnectionPool();
        ExecutorService service = Executors.newFixedThreadPool(5);
//                .mapToObj(i -> (Runnable) () -> {
//                    check("is running");
//                    management.addAnimal("arina", "eagle", 200, 30, 50);
//                }).forEach(r -> service.submit(r));
//


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
        logger.info(Thread.currentThread().getName() + " - " + msg);
    }
}
