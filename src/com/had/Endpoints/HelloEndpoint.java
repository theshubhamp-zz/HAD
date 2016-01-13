package com.had.Endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by Shubham S Patil on 1/13/2016.
 */
@Path("/hello")
public class HelloEndpoint {
    @GET
    public String sayHello()
    {
        return "Hello!";
    }
}
