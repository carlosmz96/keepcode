package com.keepcode.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.keepcode.entity.Usuario;

/**
 * Repositorio de usuario
 */
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {

}
