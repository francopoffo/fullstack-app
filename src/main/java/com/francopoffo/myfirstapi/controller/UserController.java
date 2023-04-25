package com.francopoffo.myfirstapi.controller;


import com.francopoffo.myfirstapi.users.RegisteredUserData;
import com.francopoffo.myfirstapi.users.User;
import com.francopoffo.myfirstapi.users.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody RegisteredUserData data){
        repository.save(new User(data));

    }
}
