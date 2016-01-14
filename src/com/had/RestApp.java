package com.had;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * @author Shubham S Patil
 * @since January 13, 2016
 */
@ApplicationPath("api")
public class RestApp extends ResourceConfig {
        public RestApp() {
            packages(true, "com.had");
        }
}
