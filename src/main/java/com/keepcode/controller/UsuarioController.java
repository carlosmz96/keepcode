package com.keepcode.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.keepcode.models.bean.UsuarioBean;
import com.keepcode.models.dto.UsuarioDTO;
import com.keepcode.models.mapper.UsuarioMapper;
import com.keepcode.service.UsuarioService;

/**
 * Controlador de usuario
 */
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    /** UsuarioService */
    @Autowired
    private UsuarioService usuarioService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/usuarioPorId")
    public ResponseEntity<UsuarioBean> obtenerUsuario(@RequestParam(value = "id") Integer id) {
        final UsuarioDTO usuarioDTO = this.usuarioService.obtenerUsuarioPorId(id);
        if (Objects.nonNull(usuarioDTO)) {
            final UsuarioBean usuarioBean = UsuarioMapper.INSTANCE.usuarioDTOToUsuarioBean(usuarioDTO);
            return ResponseEntity.ok().body(usuarioBean);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
