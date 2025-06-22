package com.conectaduoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectaduoc.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByIdPost(Long idPost);

    List<Score> findByIdUser(Long idUser);

    Score findByIdUserAndIdPost(Long idUser, Long idPost);
}
