package com.keepcode.entity;

import lombok.Data;

/**
 * Entidad de usuario
 */
@Data
public class Usuario {

    private Integer id;

    private String nombre;

    private String dni;

    private Integer edad;

}
