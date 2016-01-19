package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.PerCapitaDAO;

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
