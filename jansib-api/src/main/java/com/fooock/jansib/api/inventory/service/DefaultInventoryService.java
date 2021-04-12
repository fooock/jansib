package com.fooock.jansib.api.inventory.service;

import com.fooock.jansib.api.inventory.dto.CreateInventoryRequest;
import com.fooock.jansib.api.inventory.model.Inventory;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class DefaultInventoryService implements InventoryService {

    @Override
    public Inventory create(CreateInventoryRequest<?> request) {
        Inventory inventory = new Inventory();
        inventory.setName(request.getName());
        return inventory;
    }

    @Override
    public List<Inventory> list() {
        return Collections.emptyList();
    }

    @Override
    public Inventory getById(String inventoryId) {
        Inventory inventory = new Inventory();
        inventory.setId(inventoryId);
        return inventory;
    }
}
