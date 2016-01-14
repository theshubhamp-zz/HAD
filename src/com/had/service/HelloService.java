package com.had.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.had.handlers.HelloHandler;

/**
 * @author Shubham S Patil
 * @since January 13, 2016
 */
@Path("/hello")
public class HelloService {
    @GET
    public String sayHello()
    {
        HelloHandler handler = new HelloHandler();
        return handler.getHelloString();
    }
}
