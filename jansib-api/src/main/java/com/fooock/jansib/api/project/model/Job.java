package com.fooock.jansib.api.project.model;

import com.fooock.jansib.api.Transformable;
import com.fooock.jansib.api.inventory.model.Inventory;
import com.fooock.jansib.api.keystore.model.Keystore;
import com.fooock.jansib.api.repository.model.Repository;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.function.Function;

@Data
@Entity
public class Job implements Transformable<Job> {
    @Id
    @GenericGenerator(name = "id_generator", strategy = "com.fooock.jansib.api.RandomIdGenerator")
    @GeneratedValue(generator = "id_generator")
    private String id;
    private String name;
    private String type;

    private JobState state;

    @CreationTimestamp
    private Instant created;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Keystore keystore;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Repository repository;

    @Override
    public <T> T transform(Function<Job, T> function) {
        return function.apply(this);
    }
}
