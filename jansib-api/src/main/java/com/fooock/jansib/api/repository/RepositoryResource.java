package com.fooock.jansib.api.repository;

import com.fooock.jansib.api.repository.dto.CreateRepositoryRequest;
import com.fooock.jansib.api.repository.dto.RepositoryDetailView;
import com.fooock.jansib.api.repository.dto.RepositoryView;
import org.apache.commons.lang3.RandomStringUtils;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Collections;
import java.util.List;

@Path("repository")
public class RepositoryResource {

    @POST
    public RepositoryView create(@Valid CreateRepositoryRequest request) {
        String id = RandomStringUtils.randomAlphanumeric(7);
        long created = System.currentTimeMillis();
        return new RepositoryView(id, request.getName(), request.getUrl(), request.getBranch(), created);
    }

    @GET
    public List<RepositoryView> list() {
        return Collections.emptyList();
    }

    @GET
    @Path("{repositoryId}")
    public RepositoryDetailView getById(@PathParam("repositoryId") String repositoryId) {
        return new RepositoryDetailView(repositoryId);
    }
}
