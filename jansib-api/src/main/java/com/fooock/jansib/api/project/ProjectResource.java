package com.fooock.jansib.api.project;

import com.fooock.jansib.api.project.dto.CreateProjectRequest;
import com.fooock.jansib.api.project.dto.ProjectDetailView;
import com.fooock.jansib.api.project.dto.ProjectView;
import com.fooock.jansib.api.project.model.Project;
import com.fooock.jansib.api.project.service.ProjectService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@Path("project")
public class ProjectResource {
    @Inject
    ProjectService service;

    @POST
    public ProjectView create(@Valid CreateProjectRequest request) {
        return service.create(request)
            .transform(this::toProjectView);
    }

    private ProjectView toProjectView(Project data) {
        ProjectView view = new ProjectView();
        view.setId(data.getId());
        view.setName(data.getName());
        view.setDescription(data.getDescription());
        view.setCreated(data.getCreated().toEpochMilli());
        return view;
    }

    @GET
    public List<ProjectView> list() {
        return service.list()
            .stream()
            .map(this::toProjectView)
            .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    public ProjectDetailView getById(@PathParam("id") String id) {
        return service.getById(id).transform(data -> {
            ProjectDetailView detailView = new ProjectDetailView();
            detailView.setId(data.getId());
            detailView.setName(data.getName());
            detailView.setDescription(data.getDescription());
            detailView.setCreated(data.getCreated().toEpochMilli());
            return detailView;
        });
    }
}
