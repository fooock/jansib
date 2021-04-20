package com.fooock.jansib.api.project.service;

import com.fooock.jansib.api.project.dto.CreateJobRequest;
import com.fooock.jansib.api.project.model.Job;

public interface JobService {
    Job create(CreateJobRequest request);

    Job getById(String projectId, String jobId);
}
