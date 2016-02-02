package com.had.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.had.handlers.HouseholdHandler;

/**
 * @author Akshat Shukla
 * @since February 2, 2016
 */
@Path("/hh")
public class HouseholdService {
    @GET
    public String sendHouseholdData()
    {
        HouseholdHandler handler = new HouseholdHandler();
        return handler.getHouseholdData();
    }
}