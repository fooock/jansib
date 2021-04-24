package com.fooock.jansib.api.keystore.service;

import com.fooock.jansib.api.keystore.dto.CreateKeystoreRequest;
import com.fooock.jansib.api.keystore.dto.CreateSSHKeystoreRequest;
import com.fooock.jansib.api.keystore.model.Keystore;
import com.fooock.jansib.api.keystore.model.SSHKeystore;
import com.fooock.jansib.api.keystore.repository.KeystoreRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DefaultKeystoreService implements KeystoreService {
    @Inject
    KeystoreRepository keystoreRepository;

    @Transactional
    @Override
    public Keystore create(CreateKeystoreRequest<?> request) {
        if (request.getData() instanceof CreateSSHKeystoreRequest) {
            SSHKeystore keystore = toSSHKeystore((CreateKeystoreRequest<CreateSSHKeystoreRequest>) request);
            keystoreRepository.persist(keystore);
            return keystore;
        }
        throw new WebApplicationException();
    }

    private SSHKeystore toSSHKeystore(CreateKeystoreRequest<CreateSSHKeystoreRequest> request) {
        SSHKeystore keystore = new SSHKeystore();
        keystore.setName(request.getName());
        keystore.setDescription(request.getDescription());
        keystore.setType(request.getType());
        keystore.setUsername(request.getData().getUsername());
        keystore.setPassword(request.getData().getPassword());
        keystore.setPrivateKey(request.getData().getPrivateKey());
        keystore.setPassphrase(request.getData().getPassphrase());
        return keystore;
    }

    @Override
    public List<Keystore> list() {
        return keystoreRepository.listAll();
    }

    @Override
    public Keystore getById(String keystoreId) {
        Optional<Keystore> keystore = keystoreRepository.findById(keystoreId);
        if (keystore.isEmpty())
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());
        return keystore.get();
    }
}
