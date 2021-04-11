package com.fooock.jansib.api.inventory.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class InventoryDetailView {
    private final String id;
    private final String name;
    private final String description;
    private final String type;

    private final long created;
}
