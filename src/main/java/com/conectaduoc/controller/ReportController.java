package com.conectaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conectaduoc.exception.ResourceNotFoundException;
import com.conectaduoc.model.Report;
import com.conectaduoc.service.ReportService;

@RestController
@RequestMapping("/report")
@Validated
public class ReportController {
    
    @Autowired
    private ReportService reportService;

    //Listar todos los reportes
    @GetMapping
    public ResponseEntity<List<Report>> listReports() {
        List<Report> reports = reportService.listReports();
        return ResponseEntity.ok(reports);
    }

    // Obtener un reporte por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Report> getReport(Long id) {
        Report report = reportService.getReport(id)
                .orElseThrow(() -> new ResourceNotFoundException("El reporte con ID " + id + " no fue encontrado."));
        return ResponseEntity.ok(report);
    }

    // Eliminar un reporte por su ID
    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReport(Long id) {
        // Verifica si el reporte existe, si no, lanza la excepción
        reportService.getReport(id)
                .orElseThrow(() -> new ResourceNotFoundException("El reporte con ID " + id + " no fue encontrado."));

        // Elimina el reporte si existe
        reportService.deleteReport(id);

        return ResponseEntity.noContent().build(); // Devolver 204 No Content
    }

    // Listar reportes por idPost
    @GetMapping("/post/{idPost}")
    public ResponseEntity<List<Report>> findByIdPost(Long idPost) {
        List<Report> reports = reportService.findByIdPost(idPost);
        if (reports.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron reportes para el post con ID " + idPost);
        }
        return ResponseEntity.ok(reports);
    }

}
