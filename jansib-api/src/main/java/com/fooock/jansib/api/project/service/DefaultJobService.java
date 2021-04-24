package com.fooock.jansib.api.project.service;

import com.fooock.jansib.api.inventory.model.Inventory;
import com.fooock.jansib.api.inventory.repository.InventoryRepository;
import com.fooock.jansib.api.keystore.model.Keystore;
import com.fooock.jansib.api.keystore.repository.KeystoreRepository;
import com.fooock.jansib.api.project.dto.CreateJobRequest;
import com.fooock.jansib.api.project.model.Job;
import com.fooock.jansib.api.project.model.JobState;
import com.fooock.jansib.api.project.model.Project;
import com.fooock.jansib.api.project.repository.JobRepository;
import com.fooock.jansib.api.project.repository.ProjectRepository;
import com.fooock.jansib.api.repository.model.Repository;
import com.fooock.jansib.api.repository.repository.CodeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Optional;

@ApplicationScoped
public class DefaultJobService implements JobService {
    @Inject
    JobRepository jobRepository;

    @Inject
    ProjectRepository projectRepository;

    @Inject
    InventoryRepository inventoryRepository;

    @Inject
    CodeRepository codeRepository;

    @Inject
    KeystoreRepository keystoreRepository;

    @Transactional
    @Override
    public Job create(CreateJobRequest request) {
        // check project
        Optional<Project> project = projectRepository.findById(request.getProjectId());
        if (project.isEmpty())
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());

        // check inventory
        Optional<Inventory> inventory = inventoryRepository.findById(request.getInventoryId());
        if (inventory.isEmpty())
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());

        // check repository
        Optional<Repository> repository = codeRepository.findById(request.getRepositoryId());
        if (repository.isEmpty())
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());

        // check keystore
        Optional<Keystore> keystore = keystoreRepository.findById(request.getKeystoreId());
        if (keystore.isEmpty())
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());

        Job job = new Job();
        job.setKeystore(keystore.get());
        job.setProject(project.get());
        job.setInventory(inventory.get());
        job.setRepository(repository.get());
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
