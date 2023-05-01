package com.francopoffo.myfirstapi.users;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String name;
    private String email;
    private String telephone;
    private Boolean active;


    public User(RegisteredUserData data){
        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.active = true;
    }

    public void updateInfo(UpdateUserData data) {
        if(data.name() != null){
            this.name = data.name();
        }
        if(data.email() != null){
            this.email = data.email();
        }
        if(data.telephone() != null){
            this.telephone = data.telephone();
        }
        if(data.active() != null){
            this.active = data.active();
        }
    }

    public void deleteUser() {
        this.active = false;
    }
}
