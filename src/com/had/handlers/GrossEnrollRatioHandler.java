package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.GrossEnrollRatioDAO;

/**
 * @author Akshat Shukla
 * @since February 1, 2016
 */
public class GrossEnrollRatioHandler {
	public String getGrossEnrollRatioData() {
		GrossEnrollRatioDAO grossEnrollDAO = new GrossEnrollRatioDAO();
		return new Gson().toJson(grossEnrollDAO.getList());
    }

}
