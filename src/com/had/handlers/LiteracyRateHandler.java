package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.LiteracyRateDAO;

/**
 * @author Shubham S Patil
 * @since January 29, 2016
 */
public class LiteracyRateHandler {
    public String getLiteracyData() {
        LiteracyRateDAO literacyRateDAO = new LiteracyRateDAO();
        return new Gson().toJson(literacyRateDAO.getList());
    }
}
