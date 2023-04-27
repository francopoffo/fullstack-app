package com.francopoffo.myfirstapi.users;

import java.math.BigInteger;

public record UserListData(BigInteger id, String name) {

    public UserListData(User user){
        this(user.getId(), user.getName());
    }
}
