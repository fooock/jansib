package com.fooock.jansib.api.inventory.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateInventoryRequestTest {
    @Test
    public void testDeserializationFileInventory() throws JsonProcessingException {
        String json = "{\"name\":\"Hello\",\"description\":\"My description\",\"type\":\"file\",\"path\":\"inventory.ini\"}";
        ObjectMapper mapper = new ObjectMapper();
        CreateInventoryRequest<CreateFileInventoryRequest> request = mapper.readValue(json, CreateInventoryRequest.class);

        assertEquals("inventory.ini", request.getData().getPath());
        assertEquals("Hello", request.getName());
        assertEquals("My description", request.getDescription());
        assertEquals("file", request.getType());
    }

    @Test
    public void testDeserializationFileInventoryTypeNotRecognized() throws JsonProcessingException {
        String json = "{\"name\":\"Hello\",\"description\":\"My description\",\"type\":\"static\",\"path\":\"inventory.ini\"}";
        ObjectMapper mapper = new ObjectMapper();
        CreateInventoryRequest<?> request = mapper.readValue(json, CreateInventoryRequest.class);
        assertNotNull(request);
        assertNull(request.getName());
        assertNull(request.getDescription());
        assertNull(request.getType());
        assertNull(request.getData());
    }
}
