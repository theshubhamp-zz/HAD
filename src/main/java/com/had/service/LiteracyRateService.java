package com.had.service;

import com.had.handlers.LiteracyRateHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Shubham S Patil
 * @since January 29, 2016
 */


@Path("/literacy")
public class LiteracyRateService {
    @GET
    public String sendLiteracyData()
    {
        LiteracyRateHandler handler = new LiteracyRateHandler();
        return handler.getLiteracyData();
    }
}
