package com.fooock.jansib.api.keystore.model;

import com.fooock.jansib.api.Transformable;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.function.Function;

@Entity
@Data
public class Keystore implements Transformable<Keystore> {
    @Id
    @GenericGenerator(name = "id_generator", strategy = "com.fooock.jansib.api.RandomIdGenerator")
    @GeneratedValue(generator = "id_generator")
    private String id;
    private String name;
    private String type;
    private String description;

    @Override
    public <T> T transform(Function<Keystore, T> function) {
        return function.apply(this);
    }
}
