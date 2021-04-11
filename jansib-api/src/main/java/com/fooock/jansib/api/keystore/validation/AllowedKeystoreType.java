package com.fooock.jansib.api.keystore.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AllowedKeystoreTypeValidator.class})
public @interface AllowedKeystoreType {
    String message() default "Invalid keystore type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
