package com.fooock.jansib.api.keystore.dto;

import lombok.Data;

import java.util.Map;

@Data
public class KeystoreDetailView {
    private String id;
    private String name;
    private String description;
    private String type;

    private long created;
    private Map<String, Object> data;
}
