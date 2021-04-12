package com.fooock.jansib.api.keystore.model;

import com.fooock.jansib.api.Transformable;
import lombok.Data;

import java.util.function.Function;

@Data
public class Keystore implements Transformable<Keystore> {
    private String id;
    private String name;
    private String type;

    @Override
    public <T> T transform(Function<Keystore, T> function) {
        return function.apply(this);
    }
}
