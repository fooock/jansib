package com.fooock.jansib.api.inventory.repository;

import com.fooock.jansib.api.inventory.model.Inventory;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InventoryRepository implements PanacheRepository<Inventory> {
}
