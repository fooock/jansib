package com.fooock.jansib.api.keystore.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class SSHKeystore extends Keystore {
    private String username;
    private String password;
    private String privateKey;
    private String passphrase;

    @Override
    public Map<String, Object> typeParams() {
        // Never add to this map password, passphrase or private key.
        // This data is sent directly by the web service.
        return Map.of("username", username);
    }
}
