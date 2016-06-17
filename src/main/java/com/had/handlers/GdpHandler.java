package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.GdpDAO;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

/**
 * @author Shubham S Patil
 * @since January 31, 2016
 */

public class GdpHandler {
    public String getGdpData(@DefaultValue("-1") @QueryParam("stateid") Integer stateid) {
        GdpDAO gdpDAO = new GdpDAO(stateid);
        return new Gson().toJson(gdpDAO.getList());
    }
}
