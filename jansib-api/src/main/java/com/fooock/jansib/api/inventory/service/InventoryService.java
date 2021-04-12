package com.fooock.jansib.api.inventory.service;

import com.fooock.jansib.api.inventory.dto.CreateInventoryRequest;
import com.fooock.jansib.api.inventory.model.Inventory;

import java.util.List;

public interface InventoryService {
    Inventory create(CreateInventoryRequest<?> request);

    List<Inventory> list();

    Inventory getById(String inventoryId);
}
