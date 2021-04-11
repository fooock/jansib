package com.fooock.jansib.api.project.service;

import com.fooock.jansib.api.project.dto.CreateProjectRequest;
import com.fooock.jansib.api.project.model.Project;

import java.util.List;

public interface ProjectService {
    Project create(CreateProjectRequest request);
    List<Project> list();
    Project getById(String projectId);
}
