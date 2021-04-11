package com.fooock.jansib.api.inventory.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AllowedInventoryTypeValidator.class})
public @interface AllowedInventoryType {
    String message() default "Invalid inventory type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
