package com.had.service;

import com.had.handlers.GdpPciAnalysisHandler;
import com.had.handlers.PciLitAnalysisHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Shubham S Patil
 * @since February 9, 2016
 */
@Path("/gdppcianalysis")
public class GdpPciService {
    @GET
    public String sendAnalysisData()
    {
        GdpPciAnalysisHandler handler = new GdpPciAnalysisHandler();
        return handler.getAnalysisData();
    }
}
