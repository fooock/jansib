package com.fooock.jansib.api.project.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AllowedJobTypeValidator implements ConstraintValidator<AllowedJobType, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) return false;
        if ("run".equalsIgnoreCase(value)) return true;
        return "check".equalsIgnoreCase(value);
    }
}
