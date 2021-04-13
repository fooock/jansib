package com.fooock.jansib.api.keystore.service;

import com.fooock.jansib.api.keystore.dto.CreateKeystoreRequest;
import com.fooock.jansib.api.keystore.model.Keystore;
import com.fooock.jansib.api.keystore.repository.KeystoreRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class DefaultKeystoreService implements KeystoreService {
    @Inject
    KeystoreRepository keystoreRepository;

    @Override
    public Keystore create(CreateKeystoreRequest<?> request) {
        Keystore keystore = new Keystore();
        keystore.setName(request.getName());
        keystore.setDescription(request.getDescription());
        keystore.setType(request.getType());
        keystoreRepository.persist(keystore);
        return keystore;
    }

    @Override
    public List<Keystore> list() {
        return keystoreRepository.listAll();
    }

    @Override
    public Keystore getById(String keystoreId) {
        return keystoreRepository.find("id", keystoreId).firstResult();
    }
}
