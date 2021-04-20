package com.fooock.jansib.api.project.service;

import com.fooock.jansib.api.project.dto.CreateJobRequest;
import com.fooock.jansib.api.project.model.Job;
import com.fooock.jansib.api.project.model.JobState;
import com.fooock.jansib.api.project.model.Project;
import com.fooock.jansib.api.project.repository.JobRepository;
import com.fooock.jansib.api.project.repository.ProjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.util.Optional;

@ApplicationScoped
public class DefaultJobService implements JobService {
    @Inject
    JobRepository jobRepository;

    @Inject
    ProjectRepository projectRepository;

    @Transactional
    @Override
    public Job create(CreateJobRequest request) {
        // check if project exists
        Optional<Project> optionalProject = projectRepository.findById(request.getProjectId());
        if (optionalProject.isEmpty())
            throw new WebApplicationException();

        Job job = new Job();
        job.setProject(optionalProject.get());
        job.setName(request.getName());
        job.setType(request.getType());
        job.setState(JobState.CREATED);
        jobRepository.persist(job);
        return job;
    }

    @Override
    public Job getById(String projectId, String jobId) {
        return jobRepository.find("id", jobId).firstResult();
    }
}
