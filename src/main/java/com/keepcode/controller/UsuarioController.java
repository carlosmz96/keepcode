package com.keepcode.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@CrossOrigin(origins = "*", exposedHeaders = { "content-range" }, methods = { RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.PATCH })
public class UsuarioController {

    /** UsuarioService */
    @Autowired
    private UsuarioService usuarioService;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(value = "/usuarioPorEmail")
    public ResponseEntity<UsuarioBean> obtenerUsuario(@RequestParam(value = "email") String email) {
        final UsuarioDTO usuarioDTO = this.usuarioService.obtenerUsuarioPorEmail(email);
        if (Objects.nonNull(usuarioDTO)) {
            final UsuarioBean usuarioBean = UsuarioMapper.INSTANCE.usuarioDTOToUsuarioBean(usuarioDTO);
            return ResponseEntity.ok().body(usuarioBean);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
