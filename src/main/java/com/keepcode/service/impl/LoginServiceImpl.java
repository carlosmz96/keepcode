package com.keepcode.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.keepcode.models.dto.UsuarioDTO;
import com.keepcode.models.entity.AuthResponse;
import com.keepcode.models.entity.LoginRequest;
import com.keepcode.models.entity.Usuario;
import com.keepcode.models.enums.Rol;
import com.keepcode.repository.UsuarioRepository;
import com.keepcode.service.JwtService;
import com.keepcode.service.LoginService;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementación del servicio de login
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(LoginRequest request) {
        log.info("LoginServiceImpl.login() - Inicio");
        this.authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        final UserDetails user = this.usuarioRepository.findByEmail(request.getUsername()).orElseThrow();
        final String token = this.jwtService.getToken(user);
        return AuthResponse.builder().token(token).build();
    }

    @Override
    public AuthResponse register(UsuarioDTO usuarioDto) {
        final Usuario user = Usuario.builder()
                .nombre(usuarioDto.getNombre())
                .apellidos(usuarioDto.getApellidos())
                .email(usuarioDto.getEmail())
                .password(passwordEncoder.encode(usuarioDto.getPassword()))
                .rol(Rol.USER)
                .build();

        if (Objects.nonNull(user)) {
            usuarioRepository.save(user);
        }

        return AuthResponse.builder().token(jwtService.getToken(user)).build();
    }

}
