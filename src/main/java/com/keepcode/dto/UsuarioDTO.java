package com.keepcode.dto;

import org.bson.types.ObjectId;

import lombok.Data;

/**
 * DTO de usuario
 */
@Data
public class UsuarioDTO {

    /** ObjectId */
    private ObjectId id;

    /** Nombre */
    private String nombre;

    /** Apellidos */
    private String apellidos;

    /** Email */
    private String email;

    /** Contraseña */
    private String password;

}
