package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.PopulationDAO;
import com.had.data.Population;
import com.had.util.Constants;

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
		PopulationDAO populationDAO = new PopulationDAO();
		return new Gson().toJson(populationDAO.getPopulations());
    }

}
