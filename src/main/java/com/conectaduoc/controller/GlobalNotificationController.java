package com.conectaduoc.controller;

import com.conectaduoc.model.GlobalNotification;
import com.conectaduoc.service.GlobalNotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@CrossOrigin(origins = "*")
public class GlobalNotificationController {

    private final GlobalNotificationService service;

    public GlobalNotificationController(GlobalNotificationService service) {
        this.service = service;
    }

    @GetMapping("/vigentes")
    public List<GlobalNotification> obtenerVigentes() {
        return service.obtenerNotificacionesVigentes();
    }

    @GetMapping
    public List<GlobalNotification> obtenerTodas() {
        return service.obtenerTodas();
    }

    @PostMapping
    public GlobalNotification crear(@RequestBody GlobalNotification n) {
        return service.guardar(n);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
