package com.fooock.jansib.api.repository.model;

import com.fooock.jansib.api.Transformable;
import lombok.Data;

import java.util.function.Function;

@Data
public class Repository implements Transformable<Repository> {
    private String id;
    private String name;
    private String url;

    @Override
    public <T> T transform(Function<Repository, T> function) {
        return function.apply(this);
    }
}
