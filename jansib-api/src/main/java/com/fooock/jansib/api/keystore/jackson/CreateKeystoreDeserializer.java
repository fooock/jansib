package com.fooock.jansib.api.keystore.jackson;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fooock.jansib.api.keystore.dto.CreateKeystoreRequest;
import com.fooock.jansib.api.keystore.dto.CreateSSHKeystoreRequest;

import java.io.IOException;

public class CreateKeystoreDeserializer extends JsonDeserializer<CreateKeystoreRequest<?>> {
    @Override
    public CreateKeystoreRequest<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec codec = p.getCodec();
        TreeNode node = codec.readTree(p);

        if (!node.isObject()) throw new JsonParseException(p, "Expected JSON object");
        TextNode type = (TextNode) node.get("type");

        // Parse SSH keystore type
        if (type.textValue().equalsIgnoreCase("ssh")) {
            CreateKeystoreRequest<CreateSSHKeystoreRequest> wrapper = new CreateKeystoreRequest<>();
            fillCommonFields(node, wrapper);

            JsonNode sshConfig = (JsonNode) node.get("data");
            CreateSSHKeystoreRequest sshKeystoreRequest = codec.treeToValue(sshConfig, CreateSSHKeystoreRequest.class);
            wrapper.setData(sshKeystoreRequest);

            return wrapper;
        }
        // we can return an empty object here because we have our class
        // annotated with validation constraints, and the error will be throw
        // by these rules.
        return new CreateKeystoreRequest<>();
    }

    private void fillCommonFields(TreeNode node, CreateKeystoreRequest<?> wrapper) {
        TextNode name = (TextNode) node.get("name");
        TextNode description = (TextNode) node.get("description");
        TextNode type = (TextNode) node.get("type");

        wrapper.setType(type.asText());
        wrapper.setName(name.asText());
        wrapper.setDescription(description.asText());
    }
}
