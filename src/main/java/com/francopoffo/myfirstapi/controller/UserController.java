package com.francopoffo.myfirstapi.controller;


import com.francopoffo.myfirstapi.domain.users.*;
import com.francopoffo.myfirstapi.domain.users.dto.DetailedUpdatedUserData;
import com.francopoffo.myfirstapi.domain.users.dto.RegisteredUserData;
import com.francopoffo.myfirstapi.domain.users.dto.UpdateUserData;
import com.francopoffo.myfirstapi.domain.users.dto.UserListData;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigInteger;


@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "bearer-key")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisteredUserData data, UriComponentsBuilder uriBuilder){
        var user = new User(data);

        repository.save(user);

        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailedUpdatedUserData(user));
    }

    @GetMapping
    public ResponseEntity<Page<UserListData>> list(Pageable pagination){
        var page =  repository.findAllByActiveTrue(pagination).map(UserListData::new);

        return ResponseEntity.ok(page);
    }


    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateUserData data){
        var user = repository.getReferenceById(data.id());
        user.updateInfo(data);

        return ResponseEntity.ok(new DetailedUpdatedUserData(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable BigInteger id){
        var user = repository.getReferenceById(id);
        user.deleteUser();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable BigInteger id){
        var user = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetailedUpdatedUserData(user));
    }
}
