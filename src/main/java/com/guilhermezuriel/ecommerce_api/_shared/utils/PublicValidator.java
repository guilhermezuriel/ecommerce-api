package com.guilhermezuriel.ecommerce_api._shared.utils;

import jakarta.validation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PublicValidator {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();


    public static String validate(Object item, boolean throwException) {
        Set<ConstraintViolation<Object>> violations = validator.validate(item);
        Map<String, String> errors = new HashMap<>();
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Object> violation : violations) {
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
            if (throwException) {
                throw new ConstraintViolationException("Validation failed", violations);
            }
        }
        return errors.values().toString();
    }
}
