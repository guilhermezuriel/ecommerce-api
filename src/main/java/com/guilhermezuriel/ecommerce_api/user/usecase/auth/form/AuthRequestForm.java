package com.guilhermezuriel.ecommerce_api.user.usecase.auth.form;

public record AuthRequestForm(
        String login,
        String password
) {
}
