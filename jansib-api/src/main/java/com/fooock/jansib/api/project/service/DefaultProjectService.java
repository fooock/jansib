package com.fooock.jansib.api.project.service;

import com.fooock.jansib.api.project.dto.CreateProjectRequest;
import com.fooock.jansib.api.project.model.Project;
import com.fooock.jansib.api.project.repository.ProjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DefaultProjectService implements ProjectService {
    @Inject
    ProjectRepository projectRepository;

    @Transactional
    @Override
    public Project create(CreateProjectRequest request) {
        Project project = new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        projectRepository.persist(project);
        return project;
    }

    @Override
    public List<Project> list() {
        return projectRepository.listAll();
    }

    @Override
    public Project getById(String projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        if (project.isEmpty())
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());
        return project.get();
    }
}
