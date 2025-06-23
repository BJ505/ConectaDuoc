package com.conectaduoc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class AppUser {
    @Id
    private String email;

    @NotNull(message = "El nombre no puede estar vacío")
    @Size(min = 5, max = 100, message = "El nombre de usuario debe tener entre 5 y 100 caracteres")
    private String name;

    @NotNull(message = "el rol no puede estar vacío")
    private String role;

    @NotNull(message = "la sede no puede estar vacío")
    private String center;

    @NotNull(message = "las politicas no puede estar vacío")
    private Integer policies;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public Integer getPolicies() {
        return policies;
    }

    public void setPolicies(Integer policies) {
        this.policies = policies;
    }
}
