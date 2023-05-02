package com.francopoffo.myfirstapi.domain.users;

import java.math.BigInteger;

public record DetailedUpdatedUserData(BigInteger id, String name, String email, String telephone) {

    public DetailedUpdatedUserData(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getTelephone());
    }
}
