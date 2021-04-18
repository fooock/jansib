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
    private String keystoreId;

    public boolean isValidKeystore() {
        return keystoreId != null && !keystoreId.isBlank();
    }
}
