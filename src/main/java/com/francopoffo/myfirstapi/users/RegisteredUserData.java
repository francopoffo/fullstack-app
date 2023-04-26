package com.francopoffo.myfirstapi.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record RegisteredUserData(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telephone
) {
}
