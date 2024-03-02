package com.keepcode.dto;

import lombok.Data;

/**
 * DTO de usuario
 */
@Data
public class UsuarioDTO {

    private Integer id;

    private String nombre;

    private String dni;

    private Integer edad;

}
