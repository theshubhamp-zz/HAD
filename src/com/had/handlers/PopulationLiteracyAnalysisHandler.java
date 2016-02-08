package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.PopulationLiteracyAnalysisDAO;

/**
 * @author Akshat Shukla
 * @since February 9, 2016
 */
public class PopulationLiteracyAnalysisHandler {
	public String getPopulationLiteracyData() {
		PopulationLiteracyAnalysisDAO populationLiteracyDAO = new PopulationLiteracyAnalysisDAO();
		return new Gson().toJson(populationLiteracyDAO.getList());
    }

}

