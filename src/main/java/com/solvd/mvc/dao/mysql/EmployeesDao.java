package com.solvd.mvc.dao.mysql;

import com.solvd.mvc.dao.ConnectionPool;
import com.solvd.mvc.dao.IBaseDAO;
import com.solvd.mvc.dao.IEmployeesDAO;
import com.solvd.mvc.tables.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesDao extends MySqlDao implements IBaseDAO<Employees>, IEmployeesDAO {
    @Override
    public void create(Employees emp) {
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(int id) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM employees WHERE id=?;");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employees em, String target) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = null;
            switch (target) {
                case "firstname":
                    statement = conn.prepareStatement("UPDATE employees SET firstname = ? WHERE id = ?;");
                    statement.setString(1, em.getFirstname());
                    statement.setInt(2, em.getId());
                    statement.executeUpdate();
                    break;
                case "lastname":
                    statement = conn.prepareStatement("UPDATE employees SET lastname = ? WHERE id = ?;");
                    statement.setString(1, em.getLastname());
                    statement.setInt(2, em.getId());
                    statement.executeUpdate();
                    break;
                case "email":
                    statement = conn.prepareStatement("UPDATE employees SET email = ? WHERE id = ?;");
                    statement.setString(1, em.getEmail());
                    statement.setInt(2, em.getId());
                    statement.executeUpdate();
                    break;
                case "company_id":
                    statement = conn.prepareStatement("UPDATE employees SET company_id = ? WHERE id = ?;");
                    statement.setInt(1, em.getCompany_id());
                    statement.setInt(2, em.getId());
                    statement.executeUpdate();
                    break;
                case "factories_id":
                    statement = conn.prepareStatement("UPDATE employees SET factories_id = ? WHERE id = ?;");
                    statement.setInt(1, em.getFactories_id());
                    statement.setInt(2, em.getId());
                    statement.executeUpdate();
                    break;
                case "cs_id":
                    statement = conn.prepareStatement("UPDATE employees SET cs_id = ? WHERE id = ?;");
                    statement.setInt(1, em.getCs_id());
                    statement.setInt(2, em.getId());
                    statement.executeUpdate();
                    break;

            }

        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return null;
    }
}
