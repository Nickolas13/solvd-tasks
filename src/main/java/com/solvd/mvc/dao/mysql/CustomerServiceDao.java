package com.solvd.mvc.dao.mysql;

import com.solvd.mvc.dao.ConnectionPool;
import com.solvd.mvc.dao.IBaseDAO;
import com.solvd.mvc.dao.ICustomerDAO;
import com.solvd.mvc.tables.Customer;
import com.solvd.mvc.tables.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceDao extends MySqlDao implements IBaseDAO<CustomerService> {
    private static final Logger logger = LogManager.getLogger(CustomerServiceDao.class);

    @Override
    public void create(CustomerService object) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO customerservice(location,work_from,work_till) VALUES (?,?,?)");
            statement.setString(1, object.getLocation());
            statement.setString(2, object.getWork_from());
            statement.setString(3, object.getWork_till());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public CustomerService getById(int id) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM customerservice WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            String output = "";
            CustomerService service = new CustomerService();
            while (result.next()) {
                output += result.getInt("id")
                        + ":" + result.getString("location")
                        + ":" + result.getString("work_From")
                        + ":" + result.getString("work_till");

                service.setId(result.getInt("id"));
                service.setLocation(result.getString("location"));
                service.setWork_from(result.getString("work_From"));
                service.setWork_till(result.getString("work_till"));
            }
            System.out.println(output);
            return service;
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public void remove(int id) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM customerservice WHERE id=?;");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public void update(CustomerService cs, String target) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = null;
            switch (target) {
                case "location":
                    statement = conn.prepareStatement("UPDATE customerservice SET location = ? WHERE id = ?;");
                    statement.setString(1, cs.getLocation());
                    statement.setInt(2, cs.getId());
                    statement.executeUpdate();
                    break;
                case "work_from":
                    statement = conn.prepareStatement("UPDATE customerservice SET work_from = ? WHERE id = ?;");
                    statement.setString(1, cs.getWork_from());
                    statement.setInt(2, cs.getId());
                    statement.executeUpdate();
                    break;
                case "work_till":
                    statement = conn.prepareStatement("UPDATE customerservice SET work_till = ? WHERE id = ?;");
                    statement.setString(1, cs.getWork_till());
                    statement.setInt(2, cs.getId());
                    statement.executeUpdate();
                    break;

            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }


}
