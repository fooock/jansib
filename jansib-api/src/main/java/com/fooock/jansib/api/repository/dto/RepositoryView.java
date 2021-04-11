package com.fooock.jansib.api.repository.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class RepositoryView {
    private final String id;
    private final String name;
    private final String url;
    private final String branch;

    private final long created;
}
