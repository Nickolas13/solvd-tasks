package com.solvd.mvc.dao.mysql;

import com.solvd.mvc.dao.ConnectionPool;
import com.solvd.mvc.dao.IBaseDAO;
import com.solvd.mvc.tables.Factories;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FactoriesDao extends MySqlDao implements IBaseDAO<Factories> {
    private static final Logger logger = LogManager.getLogger(FactoriesDao.class);

    @Override
    public void create(Factories f) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO factories(name,prod_type,pa_month, company_id) VALUES (?,?,?,?)");
            statement.setString(1, f.getName());
            statement.setString(2, f.getProd_type());
            statement.setInt(3, f.getPa_month());
            statement.setInt(4, f.getCompany_id());
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
            Factories factory = new Factories();
            while (result.next()) {
                output += result.getInt("id")
                        + ":" + result.getString("name")
                        + ":" + result.getString("prod_type")
                        + ":" + result.getInt("pa_month")
                        + ":" + result.getInt("company_id");

                factory.setId(result.getInt("id"));
                factory.setName(result.getString("name"));
                factory.setProd_type(result.getString("prod_type"));
                factory.setPa_month(result.getInt("pa_month"));
                factory.setCompany_id(result.getInt("company_id"));

            }
            System.out.println(output);
            return factory;
        } catch (SQLException e) {
            logger.error(e);
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
            logger.error(e);
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
            logger.error(e);
        }
    }
}
