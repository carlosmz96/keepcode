package com.keepcode.models.dto;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de usuario
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    /** Rol asociado */
    private RolDTO rol;

}
