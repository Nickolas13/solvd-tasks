package com.solvd.pools.connectionpools.connections;

import org.apache.commons.dbcp2.*;

import java.sql.Connection;
import java.sql.SQLException;

public class DBCP {
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("root");
        dataSource.setPassword("nika1148");
        dataSource.setMaxIdle(10);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


}

//conn = dataSource.getConnection();
//        statement = conn.createStatement();
//        resultSet = statement.executeQuery("Select * from animals");
//        while (resultSet.next()) {
//        System.out.println("Animal ID: " + resultSet.getInt("AnimalId"));
//        System.out.println("name: " + resultSet.getString("name"));
//        System.out.println("animal type: " + resultSet.getString("animalType"));
//        System.out.println("food Cost: " + resultSet.getInt("foodCost"));
//        System.out.println("weight: " + resultSet.getInt("weight"));
//        System.out.println("age: " + resultSet.getInt("age"));
//        System.out.println("----------------------------------");
//        }
//        } finally {
//        resultSet.close();
//        statement.close();
//        conn.close();
//        }
//        }