package com.fooock.jansib.api.keystore.service;

import com.fooock.jansib.api.keystore.dto.CreateKeystoreRequest;
import com.fooock.jansib.api.keystore.model.Keystore;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class DefaultKeystoreService implements KeystoreService {

    @Override
    public Keystore create(CreateKeystoreRequest<?> request) {
        Keystore keystore = new Keystore();
        keystore.setName(request.getName());
        return keystore;
    }

    @Override
    public List<Keystore> list() {
        return Collections.emptyList();
    }

    @Override
    public Keystore getById(String keystoreId) {
        Keystore keystore = new Keystore();
        keystore.setId(keystoreId);
        return keystore;
    }
}
