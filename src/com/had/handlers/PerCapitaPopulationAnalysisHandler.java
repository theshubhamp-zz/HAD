package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.PerCapitaPopulationAnalysisDAO;

/**
 * @author Akshat Shukla
 * @since February 9, 2016
 */
public class PerCapitaPopulationAnalysisHandler {
	public String getPerCapitaPopulationData() {
		PerCapitaPopulationAnalysisDAO perCapitaPopulationDAO = new PerCapitaPopulationAnalysisDAO();
		return new Gson().toJson(perCapitaPopulationDAO.getList());
    }

}

