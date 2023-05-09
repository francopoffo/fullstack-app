package com.francopoffo.myfirstapi.controller;

import com.francopoffo.myfirstapi.domain.loginUsers.dto.AuthData;
import com.francopoffo.myfirstapi.domain.loginUsers.loginUser;
import com.francopoffo.myfirstapi.infra.security.JWTTokenData;
import com.francopoffo.myfirstapi.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity loggingIn(@RequestBody @Valid AuthData data){
        var authToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = manager.authenticate(authToken);

        var jwtToken = tokenService.generateToken((loginUser) authentication.getPrincipal());

        return ResponseEntity.ok(new JWTTokenData(jwtToken));
    }


}
