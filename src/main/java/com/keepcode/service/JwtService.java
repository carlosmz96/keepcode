package com.keepcode.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Servicio de JWT
 */
@Service
public interface JwtService {

    /**
     * Obtención de token
     * @param userDetails Usuario
     * @return Cadena token
     */
    public String getToken(UserDetails userDetails);

    /**
     * Obtención de username (email) mediante el token
     * @param token Token
     * @return Username (email)
     */
    public String getUsernameFromToken(String token);

    /**
     * Comprueba si el token es válido
     * @param token Token
     * @param userDetails Detalles de usuario
     * @return TRUE/FALSE
     */
    public boolean isTokenValid(String token, UserDetails userDetails);

}
