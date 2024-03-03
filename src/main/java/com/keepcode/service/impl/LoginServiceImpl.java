package com.keepcode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import com.keepcode.models.entity.AuthResponse;
import com.keepcode.models.entity.LoginRequest;
import com.keepcode.repository.UsuarioRepository;
import com.keepcode.service.JwtService;
import com.keepcode.service.LoginService;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementación del servicio de login
 */
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @Override
    public AuthResponse login(LoginRequest request) {
        log.info("LoginServiceImpl.login() - Inicio");
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = this.usuarioRepository.findByEmail(request.getUsername()).orElseThrow();
        String token = this.jwtService.getToken(user);
        return AuthResponse.builder().token(token).build();
    }

}
