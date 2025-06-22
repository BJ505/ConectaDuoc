package com.conectaduoc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conectaduoc.model.Post;
import com.conectaduoc.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> listPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPost(Long idUsuario) {
        return postRepository.findById(idUsuario);
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> findPostByIdUser(int idUser) {
        return postRepository.findByIdUser(idUser);
    }
}

