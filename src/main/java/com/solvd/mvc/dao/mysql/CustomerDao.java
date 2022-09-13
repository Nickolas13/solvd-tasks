package com.solvd.mvc.dao.mysql;

import com.solvd.mvc.dao.ConnectionPool;
import com.solvd.mvc.dao.IBaseDao;
import com.solvd.mvc.tables.Company;
import com.solvd.mvc.tables.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao extends MySqlDao implements IBaseDao<Customer> {
    @Override
    public void create(Customer object) {

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
                        + ":" + result.getString("email");
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

    }

    @Override
    public void update(Customer object, String target) {

    }
}
