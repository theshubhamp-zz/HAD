package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.HhUrtAnalysisDAO;
import com.had.dao.PciLitAnalysisDAO;

/**
 * @author Shubham S Patil
 * @since February 9, 2016
 */
public class HhUrtAnalysisHandler {
    public String getAnalysisData() {
        HhUrtAnalysisDAO hhUrtAnalysisDAO = new HhUrtAnalysisDAO();
        return new Gson().toJson(hhUrtAnalysisDAO.getList());
    }
}
