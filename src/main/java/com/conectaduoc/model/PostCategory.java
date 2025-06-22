package com.conectaduoc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class PostCategory {
    
    @Id
    private Long idCategory;

    @NotNull(message = "El nombre no puede estar vacío")
    private String name;

    @NotNull(message = "La descripción no puede estar vacía")
    private String description;

    @NotNull(message = "El estado no puede estar vacío")
    private int status;

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
