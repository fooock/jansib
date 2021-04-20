package com.fooock.jansib.api.project.dto;

import lombok.Data;

@Data
public class JobView {
    private String id;
    private String name;
    private String type;
    private String state;

    private long created;
}
