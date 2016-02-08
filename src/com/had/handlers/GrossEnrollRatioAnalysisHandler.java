package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.GrossEnrollRatioAnalysisDAO;

/**
 * @author Akshat Shukla
 * @since February 9, 2016
 */
public class GrossEnrollRatioAnalysisHandler {
	public String getGrossEnrollRatioAnalysisData() {
		GrossEnrollRatioAnalysisDAO grossEnrollRatioAnalysisDAO = new GrossEnrollRatioAnalysisDAO();
		return new Gson().toJson(grossEnrollRatioAnalysisDAO.getList());
    }

}

