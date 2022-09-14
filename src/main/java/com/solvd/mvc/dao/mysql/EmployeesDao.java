package com.solvd.mvc.dao.mysql;

import com.solvd.mvc.dao.ConnectionPool;
import com.solvd.mvc.dao.IBaseDao;
import com.solvd.mvc.tables.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeesDao extends MySqlDao implements IBaseDao<Employees> {
    @Override
    public void create(Employees object) {

    }

    @Override
    public Employees getById(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

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
}
