package com.fooock.jansib.api.keystore;

import com.fooock.jansib.api.keystore.dto.CreateKeystoreRequest;
import com.fooock.jansib.api.keystore.dto.KeystoreDetailView;
import com.fooock.jansib.api.keystore.dto.KeystoreView;
import com.fooock.jansib.api.keystore.service.KeystoreService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@Path("keystore")
public class KeystoreResource {
    @Inject
    KeystoreService service;

    @POST
    public KeystoreView create(@Valid CreateKeystoreRequest<?> request) {
        return service.create(request).transform(data -> {
            KeystoreView view = new KeystoreView();
            view.setName(data.getName());
            return view;
        });
    }

    @GET
    public List<KeystoreView> list() {
        return service.list().stream()
            .map(data -> {
                KeystoreView view = new KeystoreView();
                view.setName(data.getName());
                return view;
            })
            .collect(Collectors.toList());
    }

    @GET
    @Path("{keystoreId}")
    public KeystoreDetailView getById(@PathParam("keystoreId") String keystoreId) {
        return service.getById(keystoreId).transform(data -> {
            KeystoreDetailView view = new KeystoreDetailView();
            view.setName(data.getName());
            return view;
        });
    }
}
