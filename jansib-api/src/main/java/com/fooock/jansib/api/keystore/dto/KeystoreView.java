package com.fooock.jansib.api.keystore.dto;

import lombok.Data;

@Data
public class KeystoreView {
    private String id;
    private String name;
    private String description;
    private String type;

    private long created;
}
