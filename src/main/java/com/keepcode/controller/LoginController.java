package com.keepcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.keepcode.models.bean.UsuarioBean;
import com.keepcode.models.dto.UsuarioDTO;
import com.keepcode.models.entity.AuthResponse;
import com.keepcode.models.entity.LoginRequest;
import com.keepcode.models.mapper.UsuarioMapper;
import com.keepcode.service.LoginService;

/**
 * Controlador de autenticación
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", exposedHeaders = { "content-range" }, methods = { RequestMethod.GET, RequestMethod.POST,
    RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.PATCH })
public class LoginController {

    /** LoginService */
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(loginService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody UsuarioBean usuarioBean) {
        final UsuarioDTO usuarioDto = UsuarioMapper.INSTANCE.usuarioBeanToUsuarioDTO(usuarioBean);
        return ResponseEntity.ok(loginService.register(usuarioDto));
    }

}
