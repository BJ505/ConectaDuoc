package com.conectaduoc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectaduoc.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    Optional<AppUser> findByEmailAndPassword(String email, String password);

    Optional<AppUser> findByEmail(String email);

    void deleteByEmail(String email);
}
