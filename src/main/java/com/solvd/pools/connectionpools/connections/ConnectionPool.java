package com.solvd.pools.connectionpools.connections;

import org.apache.commons.dbcp2.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
    private static ConnectionPool instance;


    public static Connection getConnection() throws SQLException, IOException {
        FileInputStream input = new FileInputStream("src/main/resources/properties/mysql.properties");
        Properties prop = new Properties();
        prop.load(input);
        String url = prop.getProperty("jdbc.url");
        String username = prop.getProperty("jdbc.username");
        String password = prop.getProperty("jdbc.password");

        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static ConnectionPool getInstance() {
        return instance == null ? new ConnectionPool() : instance;
    }


}


