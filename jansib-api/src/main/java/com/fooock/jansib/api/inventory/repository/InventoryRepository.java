package com.fooock.jansib.api.inventory.repository;

import com.fooock.jansib.api.inventory.model.Inventory;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class InventoryRepository implements PanacheRepository<Inventory> {
    public Optional<Inventory> findById(String inventoryId) {
        return find("id", inventoryId).stream().findFirst();
    }
}
