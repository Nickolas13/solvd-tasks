package com.solvd.mvc.dao.mysql;


import com.solvd.mvc.dao.ConnectionPool;
import com.solvd.mvc.dao.IBaseDAO;

import com.solvd.mvc.tables.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//Data Access Objects
public class CompanyDao extends MySqlDao implements IBaseDAO<Company> {
    @Override
    public Company getById(int id) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM company WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            String output = "";
            while (result.next()) {
                output += result.getInt("id")
                        + ":" + result.getString("name")
                        + ":" + result.getString("location")
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
    public void create(Company com) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO company(name,location,phone,email) VALUES (?,?,?,?)");

            statement.setString(1, com.getName());
            statement.setString(2, com.getLocation());
            statement.setInt(3, com.getPhone());
            statement.setString(4, com.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM company WHERE id=?;");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Company com, String target) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = null;
            switch (target) {
                case "name":
                    statement = conn.prepareStatement("UPDATE company SET name = ? WHERE id = ?;");
                    statement.setString(1, com.getName());
                    statement.setInt(2, com.getId());
                    statement.executeUpdate();
                    break;
                case "location":
                    statement = conn.prepareStatement("UPDATE company SET location = ? WHERE id = ?;");
                    statement.setString(1, com.getLocation());
                    statement.setInt(2, com.getId());
                    statement.executeUpdate();
                    break;
                case "phone":
                    statement = conn.prepareStatement("UPDATE company SET phone = ? WHERE id = ?;");
                    statement.setInt(1, com.getPhone());
                    statement.setInt(2, com.getId());
                    statement.executeUpdate();
                    break;
                case "email":
                    statement = conn.prepareStatement("UPDATE company SET email = ? WHERE id = ?;");
                    statement.setString(1, com.getEmail());
                    statement.setInt(2, com.getId());
                    statement.executeUpdate();
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
