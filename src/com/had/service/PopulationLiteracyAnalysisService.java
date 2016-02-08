package com.had.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.had.handlers.PopulationLiteracyAnalysisHandler;

/**
 * @author Akshat Shukla
 * @since February 9, 2016
 */
@Path("/poplitanalysis")
public class PopulationLiteracyAnalysisService {
    @GET
    public String sendPopulationLiteracyData()
    {
    	PopulationLiteracyAnalysisHandler handler = new PopulationLiteracyAnalysisHandler();
        return handler.getPopulationLiteracyData();
    }
}