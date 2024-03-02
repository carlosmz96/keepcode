package com.keepcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keepcode.entity.Usuario;

/**
 * Repositorio de usuario
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
