package com.fooock.jansib.api.inventory;

import com.fooock.jansib.api.inventory.dto.CreateInventoryRequest;
import com.fooock.jansib.api.inventory.dto.InventoryDetailView;
import com.fooock.jansib.api.inventory.dto.InventoryView;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

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

    @POST
    public InventoryView create(@Valid CreateInventoryRequest<?> request) {
        String id = RandomStringUtils.randomAlphanumeric(7);
        long created = System.currentTimeMillis();
        return new InventoryView(id, request.getName(), request.getDescription(), request.getType(), created);
    }

    @GET
    public List<InventoryView> list() {
        return Collections.emptyList();
    }

    @GET
    @Path("{inventoryId}")
    public InventoryDetailView getById(@PathParam("inventoryId") String inventoryId) {
        long created = System.currentTimeMillis();
        return new InventoryDetailView(inventoryId, "Inventory name", "Inventory description", "file", created);
    }
}
