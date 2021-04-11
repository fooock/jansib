package com.fooock.jansib.api.repository.service;

import com.fooock.jansib.api.repository.dto.CreateRepositoryRequest;
import com.fooock.jansib.api.repository.model.Repository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class DefaultRepositoryService implements RepositoryService {

    @Override
    public Repository create(CreateRepositoryRequest request) {
        Repository repository = new Repository();
        repository.setName(request.getName());
        return repository;
    }

    @Override
    public List<Repository> list() {
        return Collections.emptyList();
    }

    @Override
    public Repository getById(String repositoryId) {
        Repository repository = new Repository();
        repository.setId(repositoryId);
        return repository;
    }
}
