package com.keepcode.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.keepcode.dto.UsuarioDTO;
import com.keepcode.entity.Usuario;
import com.keepcode.mapper.UsuarioMapper;
import com.keepcode.repository.UsuarioRepository;
import com.keepcode.service.UsuarioService;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementación del servicio de usuario
 */
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    /** UsuarioRepository */
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO obtenerUsuarioPorId(Integer id) {
        log.info("UsuarioServiceImpl.obtenerUsuarioPorId() - Inicio");
        final Optional<Usuario> optUsuario = this.usuarioRepository.findById(id);
        if (optUsuario.isPresent()) {
            final Usuario usuario = optUsuario.get();
            log.info("UsuarioServiceImpl.obtenerUsuarioPorId() - Fin");
            return UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario);
        } else {
            log.info("UsuarioServiceImpl.obtenerUsuarioPorId() - El usuario no existe");
            return null;
        }
    }

}
