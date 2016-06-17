package com.had.service;


import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.had.handlers.HouseholdHandler;

/**
 * @author Akshat Shukla
 * @since February 2, 2016
 */
@Path("/hh")
public class HouseholdService {
    @GET
    public String sendHouseholdData(@DefaultValue("0")@QueryParam("urtid") Integer urtid)
    {
        HouseholdHandler handler = new HouseholdHandler();
        return handler.getHouseholdData(urtid);
    }
}