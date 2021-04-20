package com.fooock.jansib.api.project.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AllowedJobTypeValidator.class})
public @interface AllowedJobType {
    String message() default "Invalid job type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
