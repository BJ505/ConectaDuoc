package com.conectaduoc.service;

import com.conectaduoc.model.GlobalNotification;
import com.conectaduoc.repository.GlobalNotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GlobalNotificationService {

    private final GlobalNotificationRepository repository;

    public GlobalNotificationService(GlobalNotificationRepository repository) {
        this.repository = repository;
    }

    public List<GlobalNotification> obtenerNotificacionesVigentes() {
        LocalDate hoy = LocalDate.now();
        return repository.findByFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(hoy, hoy);
    }

    public List<GlobalNotification> obtenerTodas() {
        return repository.findAll();
    }

    public GlobalNotification guardar(GlobalNotification n) {
        return repository.save(n);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
