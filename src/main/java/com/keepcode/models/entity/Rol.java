package com.keepcode.models.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad de rol
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "roles")
public class Rol {

    @Id
    private ObjectId id;

    private String codigo;

    private String descripcion;

}
