package com.fooock.jansib.api.keystore.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fooock.jansib.api.keystore.jackson.CreateKeystoreDeserializer;
import com.fooock.jansib.api.keystore.validation.AllowedKeystoreType;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@JsonDeserialize(using = CreateKeystoreDeserializer.class)
@Data
public class CreateKeystoreRequest<T> {
    @NotEmpty
    private String name;
    private String description;

    @NotEmpty
    @AllowedKeystoreType
    private String type;
    private T data;
}
