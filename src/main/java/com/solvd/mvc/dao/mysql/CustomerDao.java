package com.solvd.mvc.dao.mysql;

import com.solvd.mvc.dao.ConnectionPool;
import com.solvd.mvc.dao.IBaseDao;
import com.solvd.mvc.tables.Customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao extends MySqlDao implements IBaseDao<Customer> {
    @Override
    public void create(Customer object) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO customer(firstname,lastname,city,phone,email,cs_id) VALUES (?,?,?,?,?,?)");
            statement.setString(1, object.getFirstname());
            statement.setString(2, object.getLastname());
            statement.setString(3, object.getCity());
            statement.setInt(4, object.getPhone());
            statement.setString(5, object.getEmail());
            statement.setInt(6, object.getCs_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getById(int id) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM customer WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            String output = "";
            while (result.next()) {
                output += result.getInt("id")
                        + ":" + result.getString("firstname")
                        + ":" + result.getString("lastname")
                        + ":" + result.getString("city")
                        + ":" + result.getString("phone")
                        + ":" + result.getString("email")
                        + ":" + result.getString("cs_id");
            }
            System.out.println(output);
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(int id) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM customer WHERE id=?;");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Customer object, String target) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = null;
            switch (target) {
                case "firstname":
                    statement = conn.prepareStatement("UPDATE customer SET firstname = ? WHERE id = ?");
                    statement.setString(1, object.getFirstname());
                    statement.setInt(2, object.getId());
                    statement.executeUpdate();
                    break;
                case "lastname":
                    statement = conn.prepareStatement("UPDATE customer SET lastname = ? WHERE id = ?");
                    statement.setString(1, object.getLastname());
                    statement.setInt(2, object.getId());
                    statement.executeUpdate();
                    break;
                case "city":
                    statement = conn.prepareStatement("UPDATE customer SET city = ? WHERE id = ?");
                    statement.setString(1, object.getCity());
                    statement.setInt(2, object.getId());
                    statement.executeUpdate();
                    break;
                case "phone":
                    statement = conn.prepareStatement("UPDATE customer SET phone = ? WHERE id = ?");
                    statement.setInt(1, object.getPhone());
                    statement.setInt(2, object.getId());
                    statement.executeUpdate();
                    break;
                case "cs_id":
                    statement = conn.prepareStatement("UPDATE customer SET cs_id = ? WHERE id = ?");
                    statement.setInt(1, object.getCs_id());
                    statement.setInt(2, object.getId());
                    statement.executeUpdate();
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
