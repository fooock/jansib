package com.fooock.jansib.api.keystore.service;

import com.fooock.jansib.api.keystore.dto.CreateKeystoreRequest;
import com.fooock.jansib.api.keystore.model.Keystore;

import java.util.List;

public interface KeystoreService {
    Keystore create(CreateKeystoreRequest<?> request);

    List<Keystore> list();

    Keystore getById(String keystoreId);
}
