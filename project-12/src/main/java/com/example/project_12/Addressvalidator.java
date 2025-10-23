package com.example.project_12;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class Addressvalidator implements ConstraintValidator<Address, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext cvc) {
        if (s == null) return false;
        return s.toLowerCase().contains("india");
    }
}
