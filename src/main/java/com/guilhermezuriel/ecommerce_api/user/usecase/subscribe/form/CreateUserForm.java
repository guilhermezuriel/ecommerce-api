package com.guilhermezuriel.ecommerce_api.user.usecase.subscribe.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserForm {
    private  String email;
    private String password;
    private String firstName;
    private String lastName;
}
