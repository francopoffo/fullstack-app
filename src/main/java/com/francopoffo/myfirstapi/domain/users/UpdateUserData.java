package com.francopoffo.myfirstapi.domain.users;

import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record UpdateUserData(@NotNull BigInteger id, String name, String email, String telephone, Boolean active) {
}
