package com.conectaduoc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conectaduoc.model.Score;
import com.conectaduoc.repository.ScoreRepository;

@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> listScores() {
        return scoreRepository.findAll();
    }

    public Optional<Score> getScore(Long id) {
        return scoreRepository.findById(id);
    }

    public Score saveScore(Score score) {
        return scoreRepository.save(score);
    }

    public void deleteScore(Long id) {
        scoreRepository.deleteById(id);
    }

    public List<Score> findByIdPost(Long idPost) {
        return scoreRepository.findByIdPost(idPost);
    }

    public List<Score> findByIdUser(Long idUser) {
        return scoreRepository.findByIdUser(idUser);
    }

    public Score findByIdUserAndIdPost(Long idUser, Long idPost) {
        return scoreRepository.findByIdUserAndIdPost(idUser, idPost);
    }
}
