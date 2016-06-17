package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.GrossEnrollRatioLiteracyAnalysisDAO;

/**
 * @author Akshat Shukla
 * @since February 9, 2016
 */
public class GrossEnrollRatioLiteracyAnalysisHandler {
	public String getGrossEnrollRatioLiteracyData() {
		GrossEnrollRatioLiteracyAnalysisDAO grossEnrollRatioLiteracyDAO = new GrossEnrollRatioLiteracyAnalysisDAO();
		return new Gson().toJson(grossEnrollRatioLiteracyDAO.getList());
    }

}