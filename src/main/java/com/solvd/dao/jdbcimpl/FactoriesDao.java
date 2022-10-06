package com.solvd.dao.jdbcimpl;

import com.solvd.dao.connector.ConnectionPool;
import com.solvd.dao.interfaces.IBaseDAO;
import com.solvd.dao.interfaces.IFactoriesDAO;
import com.solvd.dao.models.Factories;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FactoriesDao extends MySqlDao implements IBaseDAO<Factories>, IFactoriesDAO {
    private static final Logger logger = LogManager.getLogger(FactoriesDao.class);

    @Override
    public void insert(Factories f) {
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
    public void delete(int id) {
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
    public void update(Factories f) {
        try {
            Connection conn = ConnectionPool.getInstance().retrieve();
            PreparedStatement statement = null;
            statement = conn.prepareStatement("UPDATE factories SET name = ?, prod_type = ?, pa_month = ?, company_id = ? WHERE id = ?;");
            statement.setString(1, f.getName());
            statement.setString(2, f.getProd_type());
            statement.setInt(3, f.getPa_month());
            statement.setInt(4, f.getCompany_id());
            statement.setInt(5, f.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public List<Factories> getFactoriesByCompanyId(int companyId) {
        return null;
    }
}
