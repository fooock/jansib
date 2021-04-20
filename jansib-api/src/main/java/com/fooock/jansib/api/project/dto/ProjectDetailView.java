package com.fooock.jansib.api.project.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class ProjectDetailView {
    private String id;
    private String name;
    private String description;

    private long created;
    private List<JobView> jobs;
}
