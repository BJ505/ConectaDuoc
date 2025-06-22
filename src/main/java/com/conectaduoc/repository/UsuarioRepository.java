package com.conectaduoc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectaduoc.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByEmailAndPassword(String email, String password);

    Optional<Usuario> findByEmail(String email);

    void deleteByEmail(String email);
}
