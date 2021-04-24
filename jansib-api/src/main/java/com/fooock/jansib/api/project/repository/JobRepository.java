package com.fooock.jansib.api.project.repository;

import com.fooock.jansib.api.project.model.Job;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class JobRepository implements PanacheRepository<Job> {
    public Optional<Job> findById(String projectId, String jobId) {
        return find("id = :jobId and project_id = :projectId",
            Parameters.with("jobId", jobId)
                .and("projectId", projectId))
            .stream().findFirst();
    }
}
