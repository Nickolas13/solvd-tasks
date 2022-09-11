package com.solvd.mvc.dao.mysql;

import com.solvd.mvc.dao.IBaseDAO;

import com.solvd.mvc.tables.Company;
import com.solvd.pools.connectionpools.connections.DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//Data Access Objects
public class CompanyDao extends MySqlDao implements IBaseDAO {
    @Override
    public Company getById(int id) throws SQLException {
        Connection conn = DBCP.getConnection();
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
    }

    @Override
    public void create(Company com) throws SQLException {
        Connection conn = DBCP.getConnection();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO company(id,name,location,phone,email) VALUES (?,?,?,?,?)");
        statement.setInt(1, com.getId());
        statement.setString(2, com.getName());
        statement.setString(3, com.getLocation());
        statement.setString(4, com.getPhone());
        statement.setString(5, com.getEmail());
        statement.executeUpdate();
    }

    @Override
    public void remove(int id) {


    }

    @Override
    public void update(Company com) {

    }


}
