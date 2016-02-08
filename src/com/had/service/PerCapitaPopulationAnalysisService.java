package com.had.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.had.handlers.PerCapitaPopulationAnalysisHandler;

/**
 * @author Akshat Shukla
 * @since February 9, 2016
 */
@Path("/pcipopanalysis")
public class PerCapitaPopulationAnalysisService {
    @GET
    public String sendPerCapitaPopulationData()
    {
    	PerCapitaPopulationAnalysisHandler handler = new PerCapitaPopulationAnalysisHandler();
        return handler.getPerCapitaPopulationData();
    }
}