package com.solvd.mvc.dao.mysql;

import com.solvd.mvc.dao.ConnectionPool;
import com.solvd.mvc.dao.IBaseDao;
import com.solvd.mvc.tables.Factories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FactoriesDao extends MySqlDao implements IBaseDao<Factories> {
    @Override
    public void create(Factories f) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO factories(id,name,prod_type,pa_month, company_id) VALUES (?,?,?,?,?)");
            statement.setInt(1, f.getId());
            statement.setString(2, f.getName());
            statement.setString(3, f.getProd_type());
            statement.setInt(4, f.getPa_month());
            statement.setInt(5, f.getCompany_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Factories getById(int id) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM factories WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            String output = "";
            while (result.next()) {
                output += result.getInt("id")
                        + ":" + result.getString("name")
                        + ":" + result.getString("prod_type")
                        + ":" + result.getString("pa_month")
                        + ":" + result.getInt("company_id");
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
            PreparedStatement statement = conn.prepareStatement("DELETE FROM factories WHERE id=?;");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Factories f, String target) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = null;
            switch (target) {
                case "name":
                    statement = conn.prepareStatement("UPDATE factories SET name = ? WHERE id = ?;");
                    statement.setString(1, f.getName());
                    statement.setInt(2, f.getId());
                    statement.executeUpdate();
                    break;
                case "prod_type":
                    statement = conn.prepareStatement("UPDATE factories SET prod_type = ? WHERE id = ?;");
                    statement.setString(1, f.getProd_type());
                    statement.setInt(2, f.getId());
                    statement.executeUpdate();
                    break;
                case "pa_month":
                    statement = conn.prepareStatement("UPDATE factories SET pa_month = ? WHERE id = ?;");
                    statement.setInt(1, f.getPa_month());
                    statement.setInt(2, f.getId());
                    statement.executeUpdate();
                    break;
                case "company_id":
                    statement = conn.prepareStatement("UPDATE factories SET company_id = ? WHERE id = ?;");
                    statement.setInt(1, f.getCompany_id());
                    statement.setInt(2, f.getId());
                    statement.executeUpdate();
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
