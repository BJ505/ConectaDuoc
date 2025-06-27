package com.conectaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.conectaduoc.exception.ResourceNotFoundException;
import com.conectaduoc.model.Score;
import com.conectaduoc.service.Score;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/score")
@Validated
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/list")
    public List<Score> listScores() {
        return scoreService.listScores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Score> getScore(@PathVariable Long id) {
        Score score = scoreService.getScore(id)
                .orElseThrow(() -> new ResourceNotFoundException("Score not found with id: " + id));
        return ResponseEntity.ok(score);
    }

    @PostMapping("/save")
    public ResponseEntity<Score> saveScore(@Valid @RequestBody Score score) {
        Score savedScore = scoreService.saveScore(score);
        return new ResponseEntity<>(savedScore, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable Long id) {
        scoreService.deleteScore(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/post/{idPost}")
    public List<Score> findByIdPost(@PathVariable Long idPost) {
        return scoreService.findByIdPost(idPost);
    }

    @GetMapping("/user/{idUser}")
    public List<Score> findByIdUser(@PathVariable Long idUser) {
        return scoreService.findByIdUser(idUser);
    }

    @GetMapping("/user/{idUser}/post/{idPost}")
    public ResponseEntity<Score> findByIdUserAndIdPost(@PathVariable Long idUser, @PathVariable Long idPost) {
        Score score = scoreService.findByIdUserAndIdPost(idUser, idPost);
        if (score == null) {
            throw new ResourceNotFoundException("Score not found for user: " + idUser + " and post: " + idPost);
        }
        return ResponseEntity.ok(score);
    }

}