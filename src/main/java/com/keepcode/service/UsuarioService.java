package com.keepcode.service;

import org.springframework.stereotype.Service;

import com.keepcode.models.dto.UsuarioDTO;

/**
 * Servicio de usuario
 */
@Service
public interface UsuarioService {

    /**
     * Obtención de usuario por id
     * @param id Identificador de usuario
     * @return UsuarioDTO
     */
    public UsuarioDTO obtenerUsuarioPorId(Integer id);

}
