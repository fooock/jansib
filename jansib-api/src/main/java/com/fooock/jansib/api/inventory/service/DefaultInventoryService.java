package com.fooock.jansib.api.inventory.service;

import com.fooock.jansib.api.inventory.dto.CreateFileInventoryRequest;
import com.fooock.jansib.api.inventory.dto.CreateInventoryRequest;
import com.fooock.jansib.api.inventory.model.FileInventory;
import com.fooock.jansib.api.inventory.model.Inventory;
import com.fooock.jansib.api.inventory.repository.InventoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.util.List;

@ApplicationScoped
public class DefaultInventoryService implements InventoryService {
    @Inject
    InventoryRepository inventoryRepository;

    @Transactional
    @Override
    public Inventory create(CreateInventoryRequest<?> request) {
        if (request.getData() instanceof CreateFileInventoryRequest) {
            FileInventory inventory = toFileInventory((CreateInventoryRequest<CreateFileInventoryRequest>) request);
            inventoryRepository.persist(inventory);
            return inventory;
        }
        throw new WebApplicationException();
    }

    private FileInventory toFileInventory(CreateInventoryRequest<CreateFileInventoryRequest> request) {
        FileInventory inventory = new FileInventory();
        inventory.setName(request.getName());
        inventory.setType(request.getType());
        inventory.setDescription(request.getDescription());
        inventory.setPath(request.getData().getPath());
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
