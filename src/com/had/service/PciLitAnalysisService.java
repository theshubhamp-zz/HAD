package com.had.service;

import com.had.handlers.PciLitAnalysisHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Shubham S Patil
 * @since February 9, 2016
 */
@Path("/pcilitanalysis")
public class PciLitAnalysisService {
    @GET
    public String sendAnalysisData()
    {
        PciLitAnalysisHandler handler = new PciLitAnalysisHandler();
        return handler.getAnalysisData();
    }
}
