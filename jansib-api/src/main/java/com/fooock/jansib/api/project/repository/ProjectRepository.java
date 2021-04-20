package com.fooock.jansib.api.project.repository;

import com.fooock.jansib.api.project.model.Project;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class ProjectRepository implements PanacheRepository<Project> {
    public Optional<Project> findById(String projectId) {
        return find("id", projectId).stream().findFirst();
    }
}
