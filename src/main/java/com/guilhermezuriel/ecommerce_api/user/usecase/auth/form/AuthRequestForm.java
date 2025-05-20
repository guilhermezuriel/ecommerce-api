package com.guilhermezuriel.ecommerce_api.user.usecase.auth.form;

import jakarta.validation.constraints.Email;

public record AuthRequestForm(
        @Email(message = "Must be a valid email")
        String login,
        String password
) {
}
