package com.fooock.jansib.api.inventory.jackson;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fooock.jansib.api.inventory.dto.CreateFileInventoryRequest;
import com.fooock.jansib.api.inventory.dto.CreateInventoryRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class CreateInventoryDeserializer extends JsonDeserializer<CreateInventoryRequest<?>> {

    @Override
    public CreateInventoryRequest<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec codec = p.getCodec();
        TreeNode node = codec.readTree(p);

        if (!node.isObject())
            throw new JsonParseException(p, "Expected JSON object");

        TextNode type = (TextNode) node.get("type");
        // File inventory types
        if (type.textValue().equalsIgnoreCase("file")) {
            CreateInventoryRequest<CreateFileInventoryRequest> wrapper = new CreateInventoryRequest<>();
            fillCommonFields(node, wrapper);

            CreateFileInventoryRequest fileInventory = new CreateFileInventoryRequest();
            TextNode path = (TextNode) node.get("path");
            fileInventory.setPath(path.asText());
            wrapper.setData(fileInventory);

            return wrapper;
        }
        throw new InvalidFormatException(p, "No valid type found", null, null);
    }

    private void fillCommonFields(TreeNode node, CreateInventoryRequest<?> wrapper) {
        TextNode name = (TextNode) node.get("name");
        TextNode description = (TextNode) node.get("description");
        TextNode type = (TextNode) node.get("type");

        wrapper.setType(type.asText());
        wrapper.setName(name.asText());
        wrapper.setDescription(description.asText());
    }
}
