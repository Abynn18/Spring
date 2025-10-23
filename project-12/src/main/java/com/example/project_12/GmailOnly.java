package com.example.project_12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = GmailValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface GmailOnly {
    String message() default "Email must be a Gmail address";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
