package com.had.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.had.handlers.GrossEnrollRatioAnalysisHandler;

/**
 * @author Akshat Shukla
 * @since February 9, 2016
 */
@Path("/greanalysis")
public class GrossEnrollRatioAnalysisService {
    @GET
    public String sendGrossEnrollRatioAnalysisData()
    {
    	GrossEnrollRatioAnalysisHandler handler = new GrossEnrollRatioAnalysisHandler();
        return handler.getGrossEnrollRatioAnalysisData();
    }
}