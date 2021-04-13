package com.fooock.jansib.api.repository.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class RepositoryView {
    private String id;
    private String name;
    private String url;
    private String branch;
    private String keystoreId;

    private long created;
}
