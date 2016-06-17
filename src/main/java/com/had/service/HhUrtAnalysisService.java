package com.had.service;

import com.had.handlers.HhUrtAnalysisHandler;
import com.had.handlers.PciLitAnalysisHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Shubham S Patil
 * @since February 9, 2016
 */
@Path("/hhurtanalysis")
public class HhUrtAnalysisService {
    @GET
    public String sendAnalysisData()
    {
        HhUrtAnalysisHandler handler = new HhUrtAnalysisHandler();
        return handler.getAnalysisData();
    }
}
