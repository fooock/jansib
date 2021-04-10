package com.fooock.jansib.api.project.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ProjectView {
    private final String id;
    private final String name;
    private final String description;
}
