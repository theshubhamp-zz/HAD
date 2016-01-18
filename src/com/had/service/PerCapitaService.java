package com.had.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.had.handlers.PerCapitaHandler;

/**
 * @author Akshat Shukla
 * @since January 19, 2016
 */
@Path("/pci")
public class PerCapitaService {
    @GET
    public String sendPerCapitaData()
    {
        PerCapitaHandler handler = new PerCapitaHandler();
        return handler.getPerCapitaData();
    }
}