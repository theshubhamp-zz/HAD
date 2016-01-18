package com.had.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.had.data.Population;
import com.had.util.Constants;

/**
 * @author Shubham S Patil
 * @since January 13, 2016
 */
public class PopulationDAO {
    private static String STATE_COLUMN_NAME = "STATE_NAME";
    private static String POP_2001_COLUMN_NAME = "POP_2001";
    private static String POP_2011_COLUMN_NAME = "POP_2011";
    private static String LOAD_ALL_POPULATION_QUERY = "SELECT " + STATE_COLUMN_NAME + "," + POP_2001_COLUMN_NAME
            + "," + POP_2011_COLUMN_NAME + " FROM POPULATION";
    List<Population> populations;
	public PopulationDAO() {
        populations = new ArrayList<>();
        try
        {
            Class.forName(Constants.JDBC_DRIVER);
            try (Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
                 Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(LOAD_ALL_POPULATION_QUERY)) {
                while (rs.next()) {
                    addPopulation(
                            new Population(rs.getString(STATE_COLUMN_NAME), rs.getInt(POP_2001_COLUMN_NAME), rs.getInt(POP_2011_COLUMN_NAME)));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
    public void addPopulation(Population obj)
    {
        populations.add(obj);
    }
    public List<Population> getPopulations() {
        return populations;
    }
}
