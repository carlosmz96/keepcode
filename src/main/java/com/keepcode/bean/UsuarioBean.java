package com.keepcode.bean;

import org.bson.types.ObjectId;

import lombok.Data;

/**
 * Bean de usuario
 */
@Data
public class UsuarioBean {

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
