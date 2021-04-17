package com.fooock.jansib.api.inventory.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class FileInventory extends Inventory {
    private String path;

    @Override
    public Map<String, Object> typeParams() {
        return Map.of("path", path);
    }
}
