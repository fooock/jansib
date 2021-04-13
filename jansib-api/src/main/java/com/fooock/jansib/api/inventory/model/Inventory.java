package com.fooock.jansib.api.inventory.model;

import com.fooock.jansib.api.Transformable;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.function.Function;

@Entity
@Data
public class Inventory implements Transformable<Inventory> {
    @Id
    @GenericGenerator(name = "id_generator", strategy = "com.fooock.jansib.api.RandomIdGenerator")
    @GeneratedValue(generator = "id_generator")
    private String id;
    private String name;
    private String type;
    private String description;

    @CreationTimestamp
    private Instant created;

    @Override
    public <T> T transform(Function<Inventory, T> function) {
        return function.apply(this);
    }
}
