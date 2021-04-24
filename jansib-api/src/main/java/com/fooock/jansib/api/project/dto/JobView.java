package com.fooock.jansib.api.project.dto;

import com.fooock.jansib.api.inventory.dto.InventoryView;
import com.fooock.jansib.api.keystore.dto.KeystoreView;
import com.fooock.jansib.api.repository.dto.RepositoryView;
import lombok.Data;

@Data
public class JobView {
    private String id;
    private String name;
    private String type;
    private String state;
    private String projectId;

    private long created;

    private InventoryView inventory;
    private KeystoreView keystore;
    private RepositoryView repository;
}
