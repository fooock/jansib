package com.fooock.jansib.api.project.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fooock.jansib.api.project.validation.AllowedJobType;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateJobRequest {
    @JsonIgnore
    private String projectId;

    @NotEmpty(message = "Job name can't be empty")
    private String name;

    @NotEmpty(message = "Job type can't be empty")
    @AllowedJobType
    private String type;

    @NotEmpty(message = "Job inventory can't be empty")
    private String inventoryId;

    @NotEmpty(message = "Job keystore can't be empty")
    private String keystoreId;

    @NotEmpty(message = "Job repository can't be empty")
    private String repositoryId;
}
