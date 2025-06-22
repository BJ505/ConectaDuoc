package com.conectaduoc.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class PostComment {

    @Id
    private Long idComment;

    @NotNull(message = "El idUser no puede ser nulo")
    private int idUser;

    @NotNull(message = "El idPost no puede ser nulo")
    private int idPost;

    @NotNull(message = "El contenido no puede ser vacío")
    private String content;

    @NotNull(message = "La fecha no puede ser vacía")
    private Date createdDate;

    // Getters y Setters
    public Long getIdComment() {
        return idComment;
    }
    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPost() {
        return idPost;
    }
    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
