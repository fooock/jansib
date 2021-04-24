package com.fooock.jansib.api.repository.repository;

import com.fooock.jansib.api.repository.model.Repository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class CodeRepository implements PanacheRepository<Repository> {
    public Optional<Repository> findById(String repositoryId) {
        return find("id", repositoryId).stream().findFirst();
    }
}
