package com.keepcode.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepcode.models.dto.UsuarioDTO;
import com.keepcode.models.entity.Usuario;
import com.keepcode.models.mapper.UsuarioMapper;
import com.keepcode.repository.UsuarioRepository;
import com.keepcode.service.UsuarioService;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementación del servicio de usuario
 */
@Slf4j
@Service
public class UsuarioServiceImpl implements UsuarioService {

    /** UsuarioRepository */
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO obtenerUsuarioPorId(Integer id) {
        log.info("UsuarioServiceImpl.obtenerUsuarioPorId() - Inicio");
        if (Objects.nonNull(id)) {
            final Optional<Usuario> optUsuario = this.usuarioRepository.findById(id);
            if (optUsuario.isPresent()) {
                final Usuario usuario = optUsuario.get();
                log.info("UsuarioServiceImpl.obtenerUsuarioPorId() - Fin");
                return UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario);
            } else {
                log.info("UsuarioServiceImpl.obtenerUsuarioPorId() - El usuario no existe");
                return null;
            }
        } else {
            log.info("UsuarioServiceImpl.obtenerUsuarioPorId() - El id viene nulo");
            return null;
        }
    }

}
