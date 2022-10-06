package com.solvd.dao.jdbcimpl;

import com.solvd.dao.connector.ConnectionPool;
import com.solvd.dao.interfaces.IBaseDAO;
import com.solvd.dao.interfaces.IEmployeesDAO;
import com.solvd.dao.models.Employees;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesDao extends MySqlDao implements IBaseDAO<Employees>, IEmployeesDAO {
    private static final Logger logger = LogManager.getLogger(EmployeesDao.class);

    @Override
    public void insert(Employees emp) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO employees(firstname,lastname,email,company_id,factories_id,cs_id) VALUES (?,?,?,?,?,?)");
            statement.setString(1, emp.getFirstname());
            statement.setString(2, emp.getLastname());
            statement.setString(3, emp.getEmail());
            statement.setInt(4, emp.getCompany_id());
            statement.setInt(5, emp.getFactories_id());
            statement.setInt(6, emp.getCs_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public Employees getById(int id) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM employees WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            String output = "";
            Employees employee = new Employees();
            while (result.next()) {
                output += result.getInt("id")
                        + ":" + result.getString("firstname")
                        + ":" + result.getString("lastname")
                        + ":" + result.getString("email")
                        + ":" + result.getInt("company_id")
                        + ":" + result.getInt("factories_id")
                        + ":" + result.getInt("cs_id");

                employee.setId(result.getInt("id"));
                employee.setFirstname(result.getString("firstname"));
                employee.setLastname(result.getString("lastname"));
                employee.setEmail(result.getString("email"));
                employee.setCompany_id(result.getInt("company_id"));
                employee.setFactories_id(result.getInt("factories_id"));
                employee.setCs_id(result.getInt("cs_id"));

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
            PreparedStatement statement = conn.prepareStatement("DELETE FROM employees WHERE id=?;");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public void update(Employees em) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = null;
            statement = conn.prepareStatement("UPDATE employees SET firstname = ? WHERE id = ?;");
            statement.setString(1, em.getFirstname());
            statement.setInt(2, em.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public Employees getEmployeesByCompanyId(int company_id) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM employees WHERE company_id = ?");
            statement.setInt(1, company_id);
            ResultSet result = statement.executeQuery();
            String output = "";
            Employees employee = new Employees();
            while (result.next()) {
                output += result.getString("firstname")
                        + ":" + result.getString("lastname")
                        + ":" + result.getInt("company_id");

                employee.setId(result.getInt("id"));
                employee.setFirstname(result.getString("firstname"));
                employee.setLastname(result.getString("lastname"));
                employee.setEmail(result.getString("email"));
                employee.setCompany_id(result.getInt("company_id"));
                employee.setFactories_id(result.getInt("factories_id"));
                employee.setCs_id(result.getInt("cs_id"));
            }
            System.out.println(output);
            return employee;
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public Employees getEmployeesByFactoryId(int id) {
        return null;
    }

    @Override
    public Employees getEmployeesByCustomerServiceId(int id) {
        return null;
    }
}
