package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.PopulationDAO;
import com.had.data.Constants;
import com.had.data.Population;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Shubham S Patil
 * @since January 13, 2016
 */
public class PopulationHandler {
	public PopulationHandler() {
	}

	public String getPopulationData() {
		Connection connection;
		Statement statement;
        PopulationDAO populationDAO = new PopulationDAO();
		try
		{
			Class.forName(Constants.JDBC_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL,Constants.USER,Constants.PASS);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM population");
            while (rs.next())
            {
                populationDAO.addPopulation(new Population(rs.getString("STATE"),rs.getInt("POP_2001"),rs.getInt("POP_2011")));
            }
            rs.close();
            statement.close();
            connection.close();
            return new Gson().toJson(populationDAO.getPopulations());
		}
		catch (Exception e)
		{
            e.printStackTrace();
			return new Gson().toJson("Unhandled Exception");
		}
    }

}
