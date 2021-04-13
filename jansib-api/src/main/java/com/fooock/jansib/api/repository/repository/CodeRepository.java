package com.fooock.jansib.api.repository.repository;

import com.fooock.jansib.api.repository.model.Repository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CodeRepository implements PanacheRepository<Repository> {
}
