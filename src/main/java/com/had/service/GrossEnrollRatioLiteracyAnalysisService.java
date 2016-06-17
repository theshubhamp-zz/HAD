package com.had.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.had.handlers.GrossEnrollRatioLiteracyAnalysisHandler;

/**
 * @author Akshat Shukla
 * @since February 9, 2016
 */
@Path("/grelitanalysis")
public class GrossEnrollRatioLiteracyAnalysisService {
    @GET
    public String sendGrossEnrollRatioLiteracyData()
    {
    	GrossEnrollRatioLiteracyAnalysisHandler handler = new GrossEnrollRatioLiteracyAnalysisHandler();
        return handler.getGrossEnrollRatioLiteracyData();
    }
}