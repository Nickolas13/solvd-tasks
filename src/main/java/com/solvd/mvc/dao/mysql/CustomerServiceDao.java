package com.solvd.mvc.dao.mysql;

import com.solvd.mvc.dao.ConnectionPool;
import com.solvd.mvc.dao.IBaseDAO;
import com.solvd.mvc.dao.ICustomerDAO;
import com.solvd.mvc.tables.CustomerService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceDao extends MySqlDao implements IBaseDAO<CustomerService> {
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
            e.printStackTrace();
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
            while (result.next()) {
                output += result.getInt("id")
                        + ":" + result.getString("location")
                        + ":" + result.getString("work_From")
                        + ":" + result.getString("work_till");
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
            PreparedStatement statement = conn.prepareStatement("DELETE FROM customerservice WHERE id=?;");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }


}
