package com.fooock.jansib.api.project.model;

import com.fooock.jansib.api.Transformable;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;

@Entity
@Data
public class Project implements Transformable<Project> {
    @Id
    @GenericGenerator(name = "id_generator", strategy = "com.fooock.jansib.api.RandomIdGenerator")
    @GeneratedValue(generator = "id_generator")
    private String id;
    private String name;
    private String description;

    @CreationTimestamp
    private Instant created;

    @OneToMany(mappedBy = "project")
    private List<Job> jobs;

    @Override
    public <T> T transform(Function<Project, T> function) {
        return function.apply(this);
    }
}
