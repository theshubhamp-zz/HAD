package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.GdpPciAnalysisDAO;
import com.had.dao.PciLitAnalysisDAO;

/**
 * @author Shubham S Patil
 * @since February 9, 2016
 */
public class GdpPciAnalysisHandler {
    public String getAnalysisData() {
        GdpPciAnalysisDAO gdpPciAnalysisDAO = new GdpPciAnalysisDAO();
        return new Gson().toJson(gdpPciAnalysisDAO.getList());
    }
}
