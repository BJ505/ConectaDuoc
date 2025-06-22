package com.conectaduoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectaduoc.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // Métodos personalizados para buscar comentarios por postId o userId
    List<Comment> findByPostId(Integer postId);

    // Método para buscar comentarios por userId
    List<Comment> findByUserId(Integer userId);
}

