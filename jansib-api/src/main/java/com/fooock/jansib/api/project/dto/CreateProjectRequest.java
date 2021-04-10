package com.fooock.jansib.api.project.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateProjectRequest {
    @NotEmpty(message = "Project name can't be null or empty")
    private String name;
    private String description;
}
