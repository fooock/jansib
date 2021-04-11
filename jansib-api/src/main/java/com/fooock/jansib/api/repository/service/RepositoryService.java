package com.fooock.jansib.api.repository.service;

import com.fooock.jansib.api.repository.dto.CreateRepositoryRequest;
import com.fooock.jansib.api.repository.model.Repository;

import java.util.List;

public interface RepositoryService {
    Repository create(CreateRepositoryRequest request);
    List<Repository> list();
    Repository getById(String repositoryId);
}
