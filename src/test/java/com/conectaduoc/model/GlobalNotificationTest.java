package com.conectaduoc.model;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class GlobalNotificationTest {

    @Test
    void testGettersAndSetters() {
        GlobalNotification n = new GlobalNotification();
        n.setId(10L);
        n.setTitulo("Titulo");
        n.setMensaje("Mensaje importante");   // <-- AGREGA ESTA LÍNEA
        Date now = new Date();
        LocalDate localNow = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        n.setFechaInicio(localNow);
        n.setFechaFin(localNow);

        assertEquals(10L, n.getId());
        assertEquals("Titulo", n.getTitulo());
        assertEquals("Mensaje importante", n.getMensaje());
        assertEquals(localNow, n.getFechaInicio());
        assertEquals(localNow, n.getFechaFin());
    }
}
