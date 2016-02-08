package com.had.handlers;

import com.had.dao.Analysis1DAO;
import com.google.gson.Gson;

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
