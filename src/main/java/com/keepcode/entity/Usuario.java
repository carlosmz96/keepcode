package com.keepcode.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * Entidad de usuario
 */
@Data
@Document(collection = "usuarios")
public class Usuario {

    @Id
    private ObjectId id;

    private String nombre;

    private String apellidos;

    private String email;

    private String password;

}
