package com.conectaduoc.controller;

import com.conectaduoc.model.GlobalNotification;
import com.conectaduoc.service.GlobalNotificationService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GlobalNotificationControllerTest {

    @Mock
    private GlobalNotificationService service;

    @InjectMocks
    private GlobalNotificationController controller;

    @Test
    void obtenerVigentes_debeRetornarLista() {
        GlobalNotification n1 = new GlobalNotification();
        n1.setId(1L);
        when(service.obtenerNotificacionesVigentes()).thenReturn(Collections.singletonList(n1));

        List<GlobalNotification> result = controller.obtenerVigentes();

        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getId());
    }

    @Test
    void obtenerTodas_debeRetornarTodasLasNotificaciones() {
        GlobalNotification n1 = new GlobalNotification(); n1.setId(2L);
        GlobalNotification n2 = new GlobalNotification(); n2.setId(3L);
        when(service.obtenerTodas()).thenReturn(Arrays.asList(n1, n2));

        List<GlobalNotification> result = controller.obtenerTodas();

        assertEquals(2, result.size());
    }

    @Test
    void crear_debeGuardarYRetornarLaNotificacion() {
        GlobalNotification input = new GlobalNotification();
        input.setMensaje("Hola mundo");
        GlobalNotification guardada = new GlobalNotification();
        guardada.setId(10L);

        when(service.guardar(input)).thenReturn(guardada);

        GlobalNotification result = controller.crear(input);

        assertEquals(10L, result.getId());
    }

    @Test
    void eliminar_debeLlamarAlServicio() {
        doNothing().when(service).eliminar(77L);
        controller.eliminar(77L);
        verify(service, times(1)).eliminar(77L);
    }
}
