package com.keepcode.service;

import org.springframework.stereotype.Service;

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
    
}
