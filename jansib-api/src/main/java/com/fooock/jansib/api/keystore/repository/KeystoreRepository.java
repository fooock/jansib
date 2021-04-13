package com.fooock.jansib.api.keystore.repository;

import com.fooock.jansib.api.keystore.model.Keystore;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class KeystoreRepository implements PanacheRepository<Keystore> {
    public Optional<Keystore> findById(String id) {
        return find("id", id).stream().findFirst();
    }
}
