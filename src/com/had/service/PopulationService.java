package com.had.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.had.handlers.PopulationHandler;

/**
 * @author Shubham S Patil
 * @since January 13, 2016
 */
@Path("/population")
public class PopulationService {
    @GET
    public String sendPopulationData()
    {
        PopulationHandler handler = new PopulationHandler();
        return handler.getPopulationData();
    }
}
