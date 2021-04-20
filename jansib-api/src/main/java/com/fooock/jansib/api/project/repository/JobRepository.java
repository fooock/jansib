package com.fooock.jansib.api.project.repository;

import com.fooock.jansib.api.project.model.Job;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.inject.Singleton;

@Singleton
public class JobRepository implements PanacheRepository<Job> {
}
