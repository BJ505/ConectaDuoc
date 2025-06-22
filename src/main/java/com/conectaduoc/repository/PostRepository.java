package com.conectaduoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectaduoc.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Método para encontrar posts por idUser
    List<Post> findByIdUser(int idUser);
}

