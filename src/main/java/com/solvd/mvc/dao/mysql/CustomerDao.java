package com.solvd.mvc.dao.mysql;

import com.solvd.mvc.dao.ConnectionPool;
import com.solvd.mvc.dao.IBaseDAO;
import com.solvd.mvc.dao.ICustomerDAO;
import com.solvd.mvc.tables.Customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao extends MySqlDao implements IBaseDAO<Customer>, ICustomerDAO {
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
            Customer customer = new Customer();
            while (result.next()) {
                output += result.getInt("id")
                        + ":" + result.getString("firstname")
                        + ":" + result.getString("lastname")
                        + ":" + result.getString("city")
                        + ":" + result.getInt("phone")
                        + ":" + result.getString("email")
                        + ":" + result.getInt("cs_id");

                customer.setId(result.getInt("id"));
                customer.setFirstname(result.getString("firstname"));
                customer.setLastname(result.getString("lastname"));
                customer.setCity(result.getString("city"));
                customer.setPhone(result.getInt("phone"));
                customer.setEmail(result.getString("email"));
                customer.setCs_id(result.getInt("cs_id"));
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

    @Override
    public Customer getCustomersByCsId(int id) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("SELECT firstname, lastname, cs_id FROM customer WHERE cs_id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            String output = "";
            Customer customer = new Customer();
            while (result.next()) {
                output += result.getString("firstname")
                        + ":" + result.getString("lastname")
                        + ":" + result.getInt("cs_id") + "\n";

                customer.setId(result.getInt("id"));
                customer.setFirstname(result.getString("firstname"));
                customer.setLastname(result.getString("lastname"));
                customer.setCity(result.getString("city"));
                customer.setPhone(result.getInt("phone"));
                customer.setEmail(result.getString("email"));
                customer.setCs_id(result.getInt("cs_id"));
            }
            System.out.println(output);
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
