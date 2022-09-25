package com.solvd.mvc.dao.mysql;


import com.solvd.animal.animalclasses.Main;
import com.solvd.mvc.dao.ConnectionPool;
import com.solvd.mvc.dao.IBaseDAO;

import com.solvd.mvc.dao.ICompanyDAO;
import com.solvd.mvc.tables.Company;
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
    public void create(Company com) {
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
    public void remove(int id) throws SQLException {

        Connection conn = ConnectionPool.getInstance().retrieve();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM company WHERE id=?;");
        statement.setInt(1, id);
        statement.executeUpdate();


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
                    statement.setString(1, com.getPhone());
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
