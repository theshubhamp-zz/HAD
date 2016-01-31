package com.had.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import com.had.handlers.PerCapitaHandler;

/**
 * @author Akshat Shukla
 * @since January 19, 2016
 */
@Path("/pci")
public class PerCapitaService {
    @GET
    public String sendPerCapitaData(@DefaultValue("-1") @QueryParam("stateid") Integer stateid)
    {
        PerCapitaHandler handler = new PerCapitaHandler();
        return handler.getPerCapitaData();
    }
}