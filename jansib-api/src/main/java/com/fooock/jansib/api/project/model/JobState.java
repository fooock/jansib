package com.fooock.jansib.api.project.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum JobState {
    CREATED("created");

    private final String name;
}
