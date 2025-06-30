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
    private PostScoreRepository postScoreRepository;

    public List<PostScore> listScores() {
        return postScoreRepository.findAll();
    }

    public Optional<PostScore> getScore(Long id) {
        return postScoreRepository.findById(id);
    }

    public PostScore saveScore(PostScore score) {
        return postScoreRepository.save(score);
    }

    public void deleteScore(Long id) {
        postScoreRepository.deleteById(id);
    }

    public List<PostScore> findByIdPost(Long idPost) {
        return postScoreRepository.findByIdPost(idPost);
    }

    public List<PostScore> findByIdUser(Long idUser) {
        return postScoreRepository.findByIdUser(idUser);
    }

    public PostScore findByIdUserAndIdPost(Long idUser, Long idPost) {
        return postScoreRepository.findByIdUserAndIdPost(idUser, idPost);
    }

}
