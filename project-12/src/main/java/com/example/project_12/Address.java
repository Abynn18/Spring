package com.example.project_12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = Addressvalidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Address {
    String message() default "Address must contain 'India'";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
