package com.fooock.jansib.api.repository.model;

import com.fooock.jansib.api.Transformable;
import com.fooock.jansib.api.keystore.model.Keystore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.Instant;
import java.util.function.Function;

@Entity
@Data
public class Repository implements Transformable<Repository> {
    @Id
    @GenericGenerator(name = "id_generator", strategy = "com.fooock.jansib.api.RandomIdGenerator")
    @GeneratedValue(generator = "id_generator")
    private String id;
    private String name;
    private String url;
    private String branch;

    @ManyToOne
    private Keystore keystore;

    @CreationTimestamp
    private Instant created;

    @Override
    public <T> T transform(Function<Repository, T> function) {
        return function.apply(this);
    }
}
