package org.example.exoservlet;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Path("hello")
    @Produces("application/json")
    public String hellojson () {
        return "Hello, json !";
    }

    @GET
    @Path("bloup")
    @Produces(MediaType.APPLICATION_JSON)
    public String json() {
        return "Hello, json !";
    }
}