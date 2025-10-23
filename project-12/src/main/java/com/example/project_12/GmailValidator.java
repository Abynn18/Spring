package com.example.project_12;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GmailValidator implements ConstraintValidator<GmailOnly, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext cvc) {
        if (s == null) return false;
        s = s.toLowerCase();
        return s.endsWith("@gmail.com");
    }
}
