package com.fooock.jansib.api.keystore.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateKeystoreRequestTest {
    @Test
    void testDeserializeSuccess() throws JsonProcessingException {
        String json = "{\"name\":\"a\",\"description\":\"b\",\"type\":\"ssh\",\"data\":{\"username\":\"z\",\"password\":\"x\",\"privateKey\":\"c\",\"passphrase\":\"v\"}}";
        ObjectMapper mapper = new ObjectMapper();
        CreateKeystoreRequest<CreateSSHKeystoreRequest> request = mapper.readValue(json, CreateKeystoreRequest.class);
        assertNotNull(request);

        assertEquals("a", request.getName());
        assertEquals("b", request.getDescription());
        assertEquals("ssh", request.getType());

        assertEquals("z", request.getData().getUsername());
        assertEquals("x", request.getData().getPassword());
        assertEquals("c", request.getData().getPrivateKey());
        assertEquals("v", request.getData().getPassphrase());
    }
}