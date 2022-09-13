package com.solvd.mvc.dao.mysql;


import com.solvd.mvc.dao.IBaseDao;

import com.solvd.mvc.tables.Company;
import com.solvd.pools.connectionpools.connections.ConnectionPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//Data Access Objects
public class CompanyDao extends MySqlDao implements IBaseDao<Company> {
    @Override
    public Company getById(int id) {
        try {
            Connection conn = ConnectionPool.getConnection();
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void create(Company com) {
        try {
            Connection conn = ConnectionPool.getConnection();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO company(id,name,location,phone,email) VALUES (?,?,?,?,?)");
            statement.setInt(1, com.getId());
            statement.setString(2, com.getName());
            statement.setString(3, com.getLocation());
            statement.setString(4, com.getPhone());
            statement.setString(5, com.getEmail());
            statement.executeUpdate();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void update(Company com) {

    }


}
