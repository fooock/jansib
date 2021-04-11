package com.fooock.jansib.api.keystore;

import com.fooock.jansib.api.keystore.dto.CreateKeystoreRequest;
import com.fooock.jansib.api.keystore.dto.KeystoreDetailView;
import com.fooock.jansib.api.keystore.dto.KeystoreView;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Collections;
import java.util.List;

@Path("keystore")
public class KeystoreResource {

    @POST
    public KeystoreView create(@Valid CreateKeystoreRequest<?> request) {
        return new KeystoreView();
    }

    @GET
    public List<KeystoreView> list() {
        return Collections.emptyList();
    }

    @GET
    @Path("{keystoreId}")
    public KeystoreDetailView getById(@PathParam("keystoreId") String keystoreId) {
        return new KeystoreDetailView();
    }
}
