package com.francopoffo.myfirstapi.controller;


import com.francopoffo.myfirstapi.users.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid RegisteredUserData data){
        repository.save(new User(data));

    }

    @GetMapping
    public Page<UserListData> list(Pageable pagination){
        return repository.findAllByActiveTrue(pagination).map(UserListData::new);
    }


    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateUserData data){
        var medico = repository.getReferenceById(data.id());
        medico.updateInfo(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable BigInteger id){
        var medico = repository.getReferenceById(id);
        medico.deleteUser();
    }
}
