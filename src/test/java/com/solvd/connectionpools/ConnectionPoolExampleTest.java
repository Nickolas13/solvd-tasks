package com.solvd.connectionpools;

import com.solvd.pools.connectionpools.ConnectionPoolExample;
import com.solvd.pools.connectionpools.IConnectionPool;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionPoolExampleTest {

    @Test
    public void getConnection() throws SQLException {
        IConnectionPool connectionPool = ConnectionPoolExample
                .create("jdbc:mysql://localhost:3306/zoo", "root", "E4b3j5dV8s!$");
        assertTrue(connectionPool.getConnection().isValid(1));
    }

    @Test
    public void getConnection2() throws SQLException {
        IConnectionPool connectionPool = ConnectionPoolExample
                .create("jdbc:mysql://localhost:3306/zoo", "root", "E4b3j5dV8s!$");
        assertTrue(connectionPool.getConnection().isValid(1));
    }

}