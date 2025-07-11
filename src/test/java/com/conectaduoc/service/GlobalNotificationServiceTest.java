package com.conectaduoc.service;

import com.conectaduoc.model.GlobalNotification;
import com.conectaduoc.repository.GlobalNotificationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GlobalNotificationServiceTest {

    @Mock
    private GlobalNotificationRepository repository;

    @InjectMocks
    private GlobalNotificationService service;

    @Test
    void obtenerNotificacionesVigentes() {
        List<GlobalNotification> notifications = new ArrayList<>();
        GlobalNotification notification1 = new GlobalNotification();
        notification1.setId(1L);
        notification1.setMensaje("Notificación 1");
        notification1.setFechaInicio(LocalDate.of(2023, 10, 1));
        notification1.setFechaFin(LocalDate.of(2023, 10, 31));
        notifications.add(notification1);

        GlobalNotification notification2 = new GlobalNotification();
        notification2.setId(2L);
        notification2.setMensaje("Notificación 2");
        notification2.setFechaInicio(LocalDate.of(2023, 10, 15));
        notification2.setFechaFin(LocalDate.of(2023, 11, 15));
        notifications.add(notification2);

        when(repository.findByFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(
                LocalDate.now(), LocalDate.now())).thenReturn(notifications);

        List<GlobalNotification> result = service.obtenerNotificacionesVigentes();
        assertEquals(2, result.size());
    }

    @Test
    void obtenerTodas() {
        List<GlobalNotification> notifications = new ArrayList<>();
        GlobalNotification notification1 = new GlobalNotification();
        notification1.setId(1L);
        notification1.setMensaje("Notificación 1");
        notifications.add(notification1);

        GlobalNotification notification2 = new GlobalNotification();
        notification2.setId(2L);
        notification2.setMensaje("Notificación 2");
        notifications.add(notification2);

        when(repository.findAll()).thenReturn(notifications);

        List<GlobalNotification> result = service.obtenerTodas();
        assertEquals(2, result.size());
    }

    @Test
    void guardar() {
        GlobalNotification notification = new GlobalNotification();
        notification.setId(1L);
        notification.setMensaje("Notificación de prueba");

        when(repository.save(notification)).thenReturn(notification);

        GlobalNotification result = service.guardar(notification);
        assertEquals("Notificación de prueba", result.getMensaje());
        verify(repository, times(1)).save(notification);
    }

    @Test
    void eliminar() {
        Long notificationId = 1L;

        doNothing().when(repository).deleteById(notificationId);

        service.eliminar(notificationId);
        verify(repository, times(1)).deleteById(notificationId);
    }
}
