package com.fooock.jansib.api.repository.service;

import com.fooock.jansib.api.keystore.model.Keystore;
import com.fooock.jansib.api.keystore.repository.KeystoreRepository;
import com.fooock.jansib.api.repository.dto.CreateRepositoryRequest;
import com.fooock.jansib.api.repository.model.Repository;
import com.fooock.jansib.api.repository.repository.CodeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DefaultRepositoryService implements RepositoryService {
    @Inject
    CodeRepository codeRepository;

    @Inject
    KeystoreRepository keystoreRepository;

    @Transactional
    @Override
    public Repository create(CreateRepositoryRequest request) {
        Repository repository = toRepositoryModel(request);
        // Check keystore ID if specified in the request
        if (request.getKeystoreId() != null) {
            Optional<Keystore> optionalKeystore = keystoreRepository.findById(request.getKeystoreId());

            // If keystore is set but not found, then we throw a 404 error
            if (optionalKeystore.isEmpty()) {
                String msg = String.format("Keystore %s not found", request.getKeystoreId());
                throw new WebApplicationException(msg, Response.Status.NOT_FOUND);
            }
            repository.setKeystore(optionalKeystore.get());
        }
        codeRepository.persist(repository);
        return repository;
    }

    private Repository toRepositoryModel(CreateRepositoryRequest request) {
        Repository repository = new Repository();
        repository.setName(request.getName());
        repository.setBranch(request.getBranch());
        repository.setUrl(request.getUrl());
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
