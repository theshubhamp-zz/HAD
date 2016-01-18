package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.PerCapitaDAO;
import com.had.data.PerCapita;
import com.had.util.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Akshat Shukla
 * @since January 19, 2016
 */
public class PerCapitaHandler {
	public PerCapitaHandler() {
	}

	public String getPerCapitaData() {
		PerCapitaDAO percapitaDAO = new PerCapitaDAO();
		return new Gson().toJson(percapitaDAO.getPerCapita());
    }

}
