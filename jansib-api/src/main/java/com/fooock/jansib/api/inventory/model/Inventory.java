package com.fooock.jansib.api.inventory.model;

import com.fooock.jansib.api.Transformable;
import lombok.Data;

import java.util.function.Function;

@Data
public class Inventory implements Transformable<Inventory> {
    private String id;
    private String name;
    private String type;

    @Override
    public <T> T transform(Function<Inventory, T> function) {
        return function.apply(this);
    }
}
