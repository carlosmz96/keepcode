package com.keepcode.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.keepcode.bean.UsuarioBean;
import com.keepcode.dto.UsuarioDTO;
import com.keepcode.mapper.UsuarioMapper;
import com.keepcode.service.UsuarioService;

/**
 * Controlador de usuario
 */
@RestController(value = "/api/usuario")
public class UsuarioController {

    /** UsuarioService */
    @Autowired
    private UsuarioService usuarioService;

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
