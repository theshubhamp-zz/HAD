package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.PciLitAnalysisDAO;

/**
 * @author Shubham S Patil
 * @since February 9, 2016
 */
public class PciLitAnalysisHandler {
    public String getAnalysisData() {
        PciLitAnalysisDAO pciLitAnalysisDAO = new PciLitAnalysisDAO();
        return new Gson().toJson(pciLitAnalysisDAO.getList());
    }
}
