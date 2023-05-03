package com.francopoffo.myfirstapi.domain.loginUsers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;

public interface loginUserRepository extends JpaRepository<loginUser, BigInteger> {

    UserDetails findByLogin(String login);
}
