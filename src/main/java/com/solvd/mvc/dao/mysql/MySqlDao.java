package com.solvd.mvc.dao.mysql;

import com.solvd.pools.connectionpools.connections.DBCP;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class MySqlDao {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

