package com.keepcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keepcode.models.entity.AuthResponse;
import com.keepcode.models.entity.LoginRequest;
import com.keepcode.service.LoginService;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    /** LoginService */
    @Autowired(required = false)
    private LoginService loginService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(loginService.login(request));
    }

}
