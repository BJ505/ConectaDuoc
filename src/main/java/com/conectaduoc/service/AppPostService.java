package com.conectaduoc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conectaduoc.model.AppPost;
import com.conectaduoc.repository.AppPostRepository;

@Service
public class AppPostService {

    @Autowired
    private AppPostRepository postRepository;

    public List<AppPost> listPosts() {
        return postRepository.findAll();
    }

    public Optional<AppPost> getPost(Long idUsuario) {
        return postRepository.findById(idUsuario);
    }

    public AppPost savePost(AppPost post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public List<AppPost> findPostByIdUser(int idUser) {
        return postRepository.findByIdUser(idUser);
    }
}

