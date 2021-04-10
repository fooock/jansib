package com.fooock.jansib.api.project.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ProjectDetailView {
    private final String id;
    private final String name;
    private final String description;

    private final long created;
}
