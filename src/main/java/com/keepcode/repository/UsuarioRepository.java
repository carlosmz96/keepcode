package com.keepcode.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.keepcode.models.entity.Usuario;

/**
 * Repositorio de usuario
 */
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

}
