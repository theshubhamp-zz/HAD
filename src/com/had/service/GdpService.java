package com.had.service;

import com.had.handlers.GdpHandler;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * @author Shubham S Patil
 * @since January 31, 2016
 */
@Path("/gdp")
public class GdpService {
    @GET
    public String sendGdpData(@DefaultValue("-1") @QueryParam("stateid") Integer stateid) {
        GdpHandler handler = new GdpHandler();
        return handler.getGdpData(stateid);
    }
}
