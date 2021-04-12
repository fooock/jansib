package com.fooock.jansib.api.inventory.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class InventoryDetailView {
    private String id;
    private String name;
    private String description;
    private String type;

    private long created;
}
