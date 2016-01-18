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
	private static String STATE_COLUMN_NAME = "STATE";
	private static String POP_2001_COLUMN_NAME = "POP_2001";
	private static String POP_2011_COLUMN_NAME = "POP_2011";
	private static String LOAD_ALL_POPULATION_QUERY = "SELECT " + STATE_COLUMN_NAME + " " + POP_2001_COLUMN_NAME
			+ " " + POP_2011_COLUMN_NAME + " FROM POPULATION";
	public PopulationHandler() {
	}

	public String getPopulationData() {
		PopulationDAO populationDAO = new PopulationDAO();
		try
		{
			Class.forName(Constants.JDBC_DRIVER);
			try (Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
					Statement statement = connection.createStatement();
					ResultSet rs = statement.executeQuery(LOAD_ALL_POPULATION_QUERY);) {
				while (rs.next()) {
					populationDAO.addPopulation(
							new Population(rs.getString(STATE_COLUMN_NAME), rs.getInt(POP_2001_COLUMN_NAME), rs.getInt(POP_2011_COLUMN_NAME)));
				}
			}
            return new Gson().toJson(populationDAO.getPopulations());
		}
		catch (Exception e)
		{
            e.printStackTrace();
			return new Gson().toJson("Unhandled Exception");
		}
    }

}
