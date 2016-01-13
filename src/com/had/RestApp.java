package com.had;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Shubham S Patil on 1/13/2016.
 */
@ApplicationPath("restpoint")
public class RestApp extends ResourceConfig {
        public RestApp() {
            packages(true, "com.had");
        }
}
