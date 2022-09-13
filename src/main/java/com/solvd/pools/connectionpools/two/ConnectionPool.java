package com.solvd.pools.connectionpools.two;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;


public class ConnectionPool {
    private static ConnectionPool instance;
    private static BasicDataSource dataSource;


    public ConnectionPool() {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/zoo");
        dataSource.setUsername("root");
        dataSource.setPassword("nika1148");
        dataSource.setMaxIdle(5);
    }

    public ConnectionPool(String url, String userName, String password) {
        dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
    }

    public static ConnectionPool getInstance() {
        return instance == null ? new ConnectionPool() : instance;
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

    public String getAnimals() {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM animals");
            ResultSet result = statement.executeQuery();
            String output = "";
            while (result.next()) {
                output += "\n------------------------------"
                        + "\nAnimal ID: " + result.getInt("AnimalId")
                        + "\nname: " + result.getString("name")
                        + "\nanimal type: " + result.getString("type")
                        + "\nfood Cost: " + result.getInt("foodCost")
                        + "\nweight: " + result.getInt("weight")
                        + "\nage: " + result.getInt("age");
            }
            return output;
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    public void addAnimal(String name, String type, int foodCost, int weight, int age) {
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO animals(name,type,foodCost,weight,age) VALUES (?,?,?,?,?)");
            statement.setString(1, name);
            statement.setString(2, type);
            statement.setInt(3, foodCost);
            statement.setInt(4, weight);
            statement.setInt(5, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void closeSource() throws SQLException {
        dataSource.close();
        instance = null;
    }
}
