package com.keepcode.models.bean;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bean de rol
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolBean {

    /** ObjectId */
    private ObjectId id;

    /** Código */
    private String codigo;

    /** Descripción */
    private String descripcion;

}
