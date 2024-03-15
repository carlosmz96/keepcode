package com.keepcode.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
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
    public UsuarioDTO obtenerUsuarioPorEmail(String email) {
        log.info("UsuarioServiceImpl.obtenerUsuarioPorEmail() - Inicio");
        if (Objects.nonNull(email) && StringUtils.isNotBlank(email)) {
            final Optional<Usuario> optUsuario = this.usuarioRepository.findByEmail(email);
            if (optUsuario.isPresent()) {
                final Usuario usuario = optUsuario.get();
                log.info("UsuarioServiceImpl.obtenerUsuarioPorEmail() - Fin");
                return UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario);
            } else {
                log.info("UsuarioServiceImpl.obtenerUsuarioPorEmail() - El usuario no existe");
                return null;
            }
        } else {
            log.info("UsuarioServiceImpl.obtenerUsuarioPorEmail() - El email viene nulo o vacío");
            return null;
        }
    }

}
