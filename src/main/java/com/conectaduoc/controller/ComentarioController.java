package com.conectaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.conectaduoc.exception.ResourceNotFoundException;
import com.conectaduoc.model.Comment;
import com.conectaduoc.service.CommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/comment")
@Validated
public class ComentarioController {

    @Autowired
    private CommentService comentarioService;

    // Listar todos los comentarios
    @GetMapping
    public ResponseEntity<List<Comment>> listComment() {
        List<Comment> comentarios = comentarioService.listComment();
        return ResponseEntity.ok(comentarios);
    }

    // Crear un nuevo comentario
    @PostMapping
    public ResponseEntity<Comment> crearComentario(@Valid @RequestBody Comment Comment) {
        Comment nuevoComentario = comentarioService.savComment(Comment);
        return new ResponseEntity<>(nuevoComentario, HttpStatus.CREATED); // Devolver 201 Created
    }

    // Obtener un comentario por su ID con manejo de excepción
    @GetMapping("/{id}")
    public ResponseEntity<Comment> obtenerComentario(@PathVariable Long id) {
        Comment Comment = comentarioService.getComment(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Comment con ID " + id + " no fue encontrado."));
        return ResponseEntity.ok(Comment);
    }

    // Eliminar un comentario por su ID con manejo de excepción
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
        // Verifica si el Comment existe, si no, lanza la excepción
        comentarioService.getComment(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Comment con ID " + id + " no fue encontrado."));

        // Elimina el comentario si existe
        comentarioService.DeleteComment(id);

        return ResponseEntity.noContent().build(); // Devolver 204 No Content
    }

    // Actualizar un comentario existente con manejo de excepción
    @PutMapping("/{id}")
    public ResponseEntity<Comment> actualizarComentario(@PathVariable Long id, @Valid @RequestBody Comment CommentDetails) {
        Comment Comment = comentarioService.getComment(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Comment con ID " + id + " no fue encontrado."));

        Comment.setContent(CommentDetails.getContent());
        Comment.setIdUser(CommentDetails.getIdUser());
        Comment.setIdPost(CommentDetails.getIdPost());
        Comment.setDate(CommentDetails.getDate());
        // Guarda el comentario actualizado
        Comment updatedComment = comentarioService.savComment(Comment);
        return ResponseEntity.ok(updatedComment);
    }
}
