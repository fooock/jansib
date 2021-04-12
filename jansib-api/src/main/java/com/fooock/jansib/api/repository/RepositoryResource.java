package com.fooock.jansib.api.repository;

import com.fooock.jansib.api.repository.dto.CreateRepositoryRequest;
import com.fooock.jansib.api.repository.dto.RepositoryDetailView;
import com.fooock.jansib.api.repository.dto.RepositoryView;
import com.fooock.jansib.api.repository.service.RepositoryService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@Path("repository")
public class RepositoryResource {
    @Inject
    RepositoryService service;

    @POST
    public RepositoryView create(@Valid CreateRepositoryRequest request) {
        return service.create(request).transform(data -> {
            RepositoryView view = new RepositoryView();
            view.setName(data.getName());
            return view;
        });
    }

    @GET
    public List<RepositoryView> list() {
        return service.list().stream()
            .map(repository -> {
                RepositoryView view = new RepositoryView();
                view.setName(repository.getName());
                return view;
            })
            .collect(Collectors.toList());
    }

    @GET
    @Path("{repositoryId}")
    public RepositoryDetailView getById(@PathParam("repositoryId") String repositoryId) {
        return service.getById(repositoryId).transform(data -> {
            RepositoryDetailView detailView = new RepositoryDetailView();
            detailView.setId(data.getId());
            detailView.setName(data.getName());
            return detailView;
        });
    }
}
