package com.keepcode.service;

import org.springframework.stereotype.Service;

import com.keepcode.models.dto.UsuarioDTO;
import com.keepcode.models.entity.AuthResponse;
import com.keepcode.models.entity.LoginRequest;

/**
 * Servicio de login
 */
@Service
public interface LoginService {

    /**
     * Login de usuario
     * @param request Llamada
     * @return Respuesta
     */
    public AuthResponse login(LoginRequest request);

    /**
     * Registro de usuario
     * @param usuarioDto DTO de usuario
     * @return Respuesta
     */
    public AuthResponse register(UsuarioDTO usuarioDto);
    
}
