package com.keepcode.models.bean;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean de usuario
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    /** Rol asociado */
    private RolBean rol;

}
