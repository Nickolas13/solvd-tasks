package com.solvd.dao.jdbcimpl;

import com.solvd.dao.connector.ConnectionPool;
import com.solvd.dao.interfaces.IBaseDAO;
import com.solvd.dao.interfaces.ICustomerDAO;
import com.solvd.dao.models.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao extends MySqlDao implements IBaseDAO<Customer>, ICustomerDAO {
    private static final Logger logger = LogManager.getLogger(CustomerDao.class);

    @Override
    public void insert(Customer customer) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO customer(firstname,lastname,city,phone,email,cs_id) VALUES (?,?,?,?,?,?)");
            statement.setString(1, customer.getFirstname());
            statement.setString(2, customer.getLastname());
            statement.setString(3, customer.getCity());
            statement.setInt(4, customer.getPhone());
            statement.setString(5, customer.getEmail());
            statement.setInt(6, customer.getCs_id());
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
            logger.error(e);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM customer WHERE id=?;");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public void update(Customer object) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = null;
            statement = conn.prepareStatement("UPDATE customer SET firstname = ? WHERE id = ?");
            statement.setString(1, object.getFirstname());
            statement.setInt(2, object.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public Customer getCustomersByCustomerServiceId(int id) {
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
            logger.error(e);
        }
        return null;
    }
}
