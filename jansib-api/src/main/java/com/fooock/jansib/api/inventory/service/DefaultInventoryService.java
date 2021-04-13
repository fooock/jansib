package com.fooock.jansib.api.inventory.service;

import com.fooock.jansib.api.inventory.dto.CreateInventoryRequest;
import com.fooock.jansib.api.inventory.model.Inventory;
import com.fooock.jansib.api.inventory.repository.InventoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class DefaultInventoryService implements InventoryService {
    @Inject
    InventoryRepository inventoryRepository;

    @Transactional
    @Override
    public Inventory create(CreateInventoryRequest<?> request) {
        Inventory inventory = new Inventory();
        inventory.setName(request.getName());
        inventory.setType(request.getType());
        inventory.setDescription(request.getDescription());
        inventoryRepository.persist(inventory);
        return inventory;
    }

    @Override
    public List<Inventory> list() {
        return inventoryRepository.listAll();
    }

    @Override
    public Inventory getById(String inventoryId) {
        return inventoryRepository.find("id", inventoryId).firstResult();
    }
}
