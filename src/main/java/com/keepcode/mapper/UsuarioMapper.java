package com.keepcode.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.keepcode.bean.UsuarioBean;
import com.keepcode.dto.UsuarioDTO;
import com.keepcode.entity.Usuario;

/**
 * Interfaz de mapeo de usuario
 */
@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);
    UsuarioBean usuarioDTOToUsuarioBean(UsuarioDTO usuarioDto);
    UsuarioDTO usuarioBeanToUsuarioDTO(UsuarioBean usuarioBean);
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDto);

}
