package com.had.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;


import com.had.handlers.Analysis1Handler;

/**
 * @author Akshat Shukla
 * @since February 8, 2016
 */
@Path("/litpopanalysis")
public class Analysis1Service {
    @GET
    public String sendAnalysis1Data()
    {
        Analysis1Handler handler = new Analysis1Handler();
        return handler.getAnalysis1Data();
    }
}
