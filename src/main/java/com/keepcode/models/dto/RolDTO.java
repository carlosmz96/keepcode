package com.keepcode.models.dto;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de rol
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolDTO {

    /** ObjectId */
    private ObjectId id;

    /** Código */
    private String codigo;

    /** Descripción */
    private String descripcion;

}
