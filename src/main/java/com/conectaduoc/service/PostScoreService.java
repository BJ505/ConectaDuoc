package com.conectaduoc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conectaduoc.model.PostScore;
import com.conectaduoc.repository.PostScoreRepository;

@Service
public class PostScoreService {
    
    @Autowired
    private PostScoreRepository PostScoreRepository;

    public List<PostScore> listScores() {
        return PostScoreRepository.findAll();
    }

    public Optional<PostScore> getScore(Long id) {
        return PostScoreRepository.findById(id);
    }

    public PostScore saveScore(PostScore score) {
        return PostScoreRepository.save(score);
    }

    public void deleteScore(Long id) {
        PostScoreRepository.deleteById(id);
    }

    public List<PostScore> findByIdPost(Long idPost) {
        return PostScoreRepository.findByIdPost(idPost);
    }

    public List<PostScore> findByIdUser(Long idUser) {
        return PostScoreRepository.findByIdUser(idUser);
    }

    public PostScore findByIdUserAndIdPost(Long idUser, Long idPost) {
        return PostScoreRepository.findByIdUserAndIdPost(idUser, idPost);
    }

    
}
