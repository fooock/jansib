package com.fooock.jansib.api.inventory.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fooock.jansib.api.inventory.jackson.CreateInventoryDeserializer;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Base class used to create different types of inventories.
 *
 * @param <T> Class data with information related to its type
 * @see CreateFileInventoryRequest
 */
@JsonDeserialize(using = CreateInventoryDeserializer.class)
@Data
public class CreateInventoryRequest<T> {
    @NotEmpty
    private String name;

    @NotEmpty
    private String type;

    private String description;
    private T data;
}
