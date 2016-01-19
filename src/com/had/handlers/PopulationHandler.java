package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.PopulationDAO;

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
