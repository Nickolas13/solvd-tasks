package com.solvd.pools.connectionpools.one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        IConnectionPool connectionPool = ConnectionPoolExample
                .create("jdbc:mysql://localhost:3306/zoo", "root", "E4b3j5dV8s!$");
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i <= 7; i++) {
            service.submit(() -> {
                check("running");
                connectionPool.getConnection();
            });

        }
        service.shutdown();
    }

    private static void check(String msg) {
        logger.info(Thread.currentThread().getName() + " - " + msg);
    }
}
