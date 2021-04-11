package com.fooock.jansib.api.keystore.dto;

import lombok.Data;

@Data
public class CreateSSHKeystoreRequest {
    private String username;
    private String password;
    private String privateKey;
    private String passphrase;
}
