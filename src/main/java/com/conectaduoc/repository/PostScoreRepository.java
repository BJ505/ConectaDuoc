package com.conectaduoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectaduoc.model.PostScore;

public interface PostScoreRepository extends JpaRepository<PostScore, Long> {
    List<PostScore> findByIdPost(Long idPost);

    List<PostScore> findByIdUser(Long idUser);

    PostScore findByIdUserAndIdPost(Long idUser, Long idPost);
}
