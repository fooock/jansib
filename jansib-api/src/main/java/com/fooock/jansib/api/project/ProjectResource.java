package com.fooock.jansib.api.project;

import com.fooock.jansib.api.project.dto.CreateProjectRequest;
import com.fooock.jansib.api.project.dto.ProjectDetailView;
import com.fooock.jansib.api.project.dto.ProjectView;
import org.apache.commons.lang3.RandomStringUtils;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Collections;
import java.util.List;

@Path("project")
public class ProjectResource {

    @POST
    public ProjectView create(@Valid CreateProjectRequest request) {
        String id = RandomStringUtils.randomAlphanumeric(7);
        long created = System.currentTimeMillis();
        return new ProjectView(id, request.getName(), request.getDescription(), created);
    }

    @GET
    public List<ProjectView> list() {
        return Collections.emptyList();
    }

    @GET
    @Path("{id}")
    public ProjectDetailView getById(@PathParam("id") String id) {
        long created = System.currentTimeMillis();
        return new ProjectDetailView(id, "Project name", "My project description", created);
    }
}
