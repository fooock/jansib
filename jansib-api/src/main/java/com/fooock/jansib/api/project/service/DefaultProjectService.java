package com.fooock.jansib.api.project.service;

import com.fooock.jansib.api.project.dto.CreateProjectRequest;
import com.fooock.jansib.api.project.model.Project;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class DefaultProjectService implements ProjectService {
    @Override
    public Project create(CreateProjectRequest request) {
        Project project = new Project();
        project.setName(request.getName());
        return project;
    }

    @Override
    public List<Project> list() {
        return Collections.emptyList();
    }

    @Override
    public Project getById(String projectId) {
        Project project = new Project();
        project.setId(projectId);
        return project;
    }
}
