package com.conectaduoc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectaduoc.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);

    void deleteByEmail(String email);

    Optional<AppUser> findByIdUser(Long idUser);

}
