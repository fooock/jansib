package com.fooock.jansib.api.inventory;

import com.fooock.jansib.api.inventory.dto.CreateInventoryRequest;
import com.fooock.jansib.api.inventory.dto.InventoryDetailView;
import com.fooock.jansib.api.inventory.dto.InventoryView;
import com.fooock.jansib.api.inventory.service.InventoryService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Collections;
import java.util.List;

@Slf4j
@Path("inventory")
public class InventoryResource {
    @Inject
    private InventoryService service;

    @POST
    public InventoryView create(@Valid CreateInventoryRequest<?> request) {
        return service.create(request).transform(data -> {
            InventoryView view = new InventoryView();
            view.setName(data.getName());
            return view;
        });
    }

    @GET
    public List<InventoryView> list() {
        return Collections.emptyList();
    }

    @GET
    @Path("{inventoryId}")
    public InventoryDetailView getById(@PathParam("inventoryId") String inventoryId) {
        return service.getById(inventoryId).transform(data -> {
            InventoryDetailView detailView = new InventoryDetailView();
            detailView.setName(data.getName());
            return detailView;
        });
    }
}
