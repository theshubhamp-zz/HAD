package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.PopulationDAO;

/**
 * @author Shubham S Patil
 * @since January 13, 2016
 */
public class PopulationHandler {
	public String getPopulationData(Integer stateid) {
		PopulationDAO populationDAO = new PopulationDAO(stateid);
		return new Gson().toJson(populationDAO.getList());
    }

}
