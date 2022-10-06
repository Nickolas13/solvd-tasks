package com.solvd.dao.jdbcimpl;


import com.solvd.dao.connector.ConnectionPool;
import com.solvd.dao.interfaces.IBaseDAO;

import com.solvd.dao.interfaces.ICompanyDAO;
import com.solvd.dao.models.Company;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//Data Access Objects
public class CompanyDao extends MySqlDao implements IBaseDAO<Company>, ICompanyDAO {
    private static final Logger logger = LogManager.getLogger(CompanyDao.class);

    @Override
    public Company getById(int id) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM company WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            String output = "";
            Company company = new Company();
            while (result.next()) {
                output += result.getInt("id")
                        + ":" + result.getString("name")
                        + ":" + result.getString("location")
                        + ":" + result.getString("phone")
                        + ":" + result.getString("email");

                company.setId(result.getInt("id"));
                company.setName(result.getString("name"));
                company.setLocation(result.getString("location"));
                company.setPhone(result.getString("phone"));
                company.setEmail(result.getString("email"));
            }
            System.out.println(output);
            return company;
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public void insert(Company com) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO company(name,location,phone,email) VALUES (?,?,?,?)");
            statement.setString(1, com.getName());
            statement.setString(2, com.getLocation());
            statement.setString(3, com.getPhone());
            statement.setString(4, com.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM company WHERE id=?;");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.info(e);
        }

    }

    @Override
    public void update(Company com) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = null;
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }
    }


    @Override
    public Company getCompaniesByLocation(String location) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM company WHERE location = ?");
            statement.setString(1, location);
            ResultSet result = statement.executeQuery();
            String output = "";
            Company company = new Company();
            while (result.next()) {
                output += result.getString("name")
                        + ":" + result.getString("location")
                        + ":" + result.getString("phone")
                        + ":" + result.getString("email");

                company.setId(result.getInt("id"));
                company.setName(result.getString("name"));
                company.setLocation(result.getString("location"));
                company.setPhone(result.getString("phone"));
                company.setEmail(result.getString("email"));
            }
            System.out.println(output);
            return company;
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }
}
