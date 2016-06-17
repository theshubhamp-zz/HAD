package com.had.service;

import com.had.handlers.StateHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Shubham S Patil
 * @since February 3, 2016
 */
@Path("/states")
public class StateService {
    @GET
    public static String getStateData() {
        StateHandler stateHandler = new StateHandler();
        return stateHandler.getStateData();
    }
}
