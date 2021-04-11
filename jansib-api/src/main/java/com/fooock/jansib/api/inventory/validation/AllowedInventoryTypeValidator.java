package com.fooock.jansib.api.inventory.validation;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class AllowedInventoryTypeValidator implements ConstraintValidator<AllowedInventoryType, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return "file".equalsIgnoreCase(value);
    }
}
