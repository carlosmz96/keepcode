package com.keepcode.models.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.keepcode.models.bean.RolBean;
import com.keepcode.models.dto.RolDTO;
import com.keepcode.models.entity.Rol;

/**
 * Interfaz de mapeo de rol
 */
@Mapper
public interface RolMapper {

    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    RolDTO rolToRolDTO(Rol rol);
    RolBean rolDTOToRolBean(RolDTO rolDto);
    RolDTO rolBeanToRolDTO(RolBean rolBean);
    Rol rolDTOToRol(RolDTO rolDto);

}
