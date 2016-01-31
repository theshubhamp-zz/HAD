package com.had.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.had.handlers.GrossEnrollRatioHandler;

/**
 * @author Akshat Shukla
 * @since February 1, 2016
 */
@Path("/ger")
public class GrossEnrollRatioService {
    @GET
    public String sendGrossEnrollRatioData()
    {
        GrossEnrollRatioHandler handler = new GrossEnrollRatioHandler();
        return handler.getGrossEnrollRatioData();
    }
}