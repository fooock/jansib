package com.fooock.jansib.api.repository.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateRepositoryRequest {
    @NotEmpty
    private String name;

    @NotEmpty
    private String url;

    @NotEmpty
    private String branch;

    @NotEmpty
    private String keystoreId;
}
