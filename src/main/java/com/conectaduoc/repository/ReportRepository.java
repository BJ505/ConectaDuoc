package com.conectaduoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectaduoc.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
    // Método para encontrar reportes por idUser
    List<Report> findByIdUser(int idUser);
    // Método para encontrar reportes por idPost
    List<Report> findByIdPost(Long idPost);
    // Método para encontrar reportes por idComment
    List<Report> findByIdComment(int idComment);
}
