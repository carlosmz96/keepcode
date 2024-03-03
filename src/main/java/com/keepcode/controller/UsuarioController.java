package com.keepcode.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.keepcode.models.bean.UsuarioBean;
import com.keepcode.models.dto.UsuarioDTO;
import com.keepcode.models.mapper.UsuarioMapper;
import com.keepcode.service.UsuarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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

    @PostMapping(value = "/registrarUsuario")
    public ResponseEntity<UsuarioBean> registrarUsuario(@RequestBody UsuarioBean usuarioBean) {
        if (Objects.nonNull(usuarioBean)) {
            UsuarioDTO usuarioDTO = UsuarioMapper.INSTANCE.usuarioBeanToUsuarioDTO(usuarioBean);
            usuarioDTO = usuarioService.registrarUsuario(usuarioDTO);

            final UsuarioBean usuarioRespuesta = UsuarioMapper.INSTANCE.usuarioDTOToUsuarioBean(usuarioDTO);
            return ResponseEntity.ok(usuarioRespuesta);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
