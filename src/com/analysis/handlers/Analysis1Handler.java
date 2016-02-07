package com.analysis.handlers;

import com.google.gson.Gson;
import com.analysis.dao.Analysis1DAO;

/**
 * @author Akshat Shukla
 * @since February 8, 2016
 */
public class Analysis1Handler {
	public String getAnalysis1Data() {
		Analysis1DAO analysisDAO = new Analysis1DAO();
		return new Gson().toJson(analysisDAO.getList());
    }

}
