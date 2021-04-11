package com.fooock.jansib.api.project.model;

import com.fooock.jansib.api.Transformable;
import lombok.Data;

import java.util.function.Function;

@Data
public class Project implements Transformable<Project> {
    private String id;
    private String name;

    @Override
    public <T> T transform(Function<Project, T> function) {
        return function.apply(this);
    }
}
