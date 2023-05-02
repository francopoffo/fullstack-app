package com.francopoffo.myfirstapi.domain.users;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import java.math.BigInteger;


public interface UserRepository extends JpaRepository<User, BigInteger> {
    Page<User> findAllByActiveTrue(Pageable pagination);
}
