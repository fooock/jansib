package com.fooock.jansib.api.repository.service;

import com.fooock.jansib.api.repository.dto.CreateRepositoryRequest;
import com.fooock.jansib.api.repository.model.Repository;
import com.fooock.jansib.api.repository.repository.CodeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DefaultRepositoryService implements RepositoryService {
    @Inject
    CodeRepository codeRepository;

    @Transactional
    @Override
    public Repository create(CreateRepositoryRequest request) {
        // TODO: Check here if keystore exists
        Repository repository = new Repository();
        repository.setName(request.getName());
        repository.setBranch(request.getBranch());
        repository.setUrl(request.getUrl());
        codeRepository.persist(repository);
        return repository;
    }

    @Override
    public List<Repository> list() {
        return codeRepository.listAll();
    }

    @Override
    public Repository getById(String repositoryId) {
        return codeRepository.find("id", repositoryId).firstResult();
    }
}
