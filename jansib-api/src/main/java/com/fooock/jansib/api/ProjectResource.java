package com.fooock.jansib.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("project")
public class ProjectResource {
    @GET
    public String health() {
        return "ok";
    }
}
