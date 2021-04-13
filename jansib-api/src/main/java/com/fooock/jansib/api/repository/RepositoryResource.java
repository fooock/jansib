package com.fooock.jansib.api.repository;

import com.fooock.jansib.api.repository.dto.CreateRepositoryRequest;
import com.fooock.jansib.api.repository.dto.RepositoryDetailView;
import com.fooock.jansib.api.repository.dto.RepositoryView;
import com.fooock.jansib.api.repository.model.Repository;
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
        return service.create(request)
            .transform(this::toRepositoryView);
    }

    private RepositoryView toRepositoryView(Repository repository) {
        RepositoryView view = new RepositoryView();
        view.setName(repository.getName());
        view.setBranch(repository.getBranch());
        view.setUrl(repository.getUrl());
        view.setId(repository.getId());
        view.setCreated(repository.getCreated().toEpochMilli());

        if (repository.getKeystore() != null)
            view.setKeystoreId(repository.getKeystore().getId());
        return view;
    }

    @GET
    public List<RepositoryView> list() {
        return service.list().stream()
            .map(this::toRepositoryView)
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
