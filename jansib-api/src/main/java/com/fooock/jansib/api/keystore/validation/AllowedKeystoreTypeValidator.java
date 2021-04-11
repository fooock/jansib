package com.fooock.jansib.api.keystore.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AllowedKeystoreTypeValidator implements ConstraintValidator<AllowedKeystoreType, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return "ssh".equalsIgnoreCase(value);
    }
}
