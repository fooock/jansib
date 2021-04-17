package com.fooock.jansib.api.inventory;

import com.fooock.jansib.api.inventory.dto.CreateInventoryRequest;
import com.fooock.jansib.api.inventory.dto.InventoryDetailView;
import com.fooock.jansib.api.inventory.dto.InventoryView;
import com.fooock.jansib.api.inventory.model.Inventory;
import com.fooock.jansib.api.inventory.service.InventoryService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@Path("inventory")
public class InventoryResource {
    @Inject
    InventoryService service;

    @POST
    public InventoryView create(@Valid CreateInventoryRequest<?> request) {
        return service.create(request)
            .transform(this::toInventoryView);
    }

    private InventoryView toInventoryView(Inventory inventory) {
        InventoryView view = new InventoryView();
        view.setName(inventory.getName());
        view.setDescription(inventory.getDescription());
        view.setId(inventory.getId());
        view.setCreated(inventory.getCreated().toEpochMilli());
        view.setType(inventory.getType());
        view.setData(inventory.typeParams());
        return view;
    }

    @GET
    public List<InventoryView> list() {
        return service.list()
            .stream()
            .map(this::toInventoryView)
            .collect(Collectors.toList());
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
