package com.conectaduoc.controller;

import com.conectaduoc.model.AppUser;
import com.conectaduoc.service.AppUserService;
import com.conectaduoc.exception.ResourceNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private AppUserService userService;

    @InjectMocks
    private AppUserController controller;

    @Test
    void listUser_debeRetornarLista() {
        AppUser u1 = new AppUser();
        u1.setIdUser(1L); u1.setName("Juan");
        AppUser u2 = new AppUser();
        u2.setIdUser(2L); u2.setName("Pedro");

        when(userService.listarUsuarios()).thenReturn(Arrays.asList(u1, u2));
        ResponseEntity<List<AppUser>> resp = controller.listasUsuarios();

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(2, resp.getBody().size());
    }

    @Test
    void crearUser_debeCrearYRetornar201() {
        AppUser nuevo = new AppUser();
        nuevo.setName("Nuevo!");
        when(userService.guardarUsuario(any(AppUser.class))).thenReturn(nuevo);

        ResponseEntity<AppUser> resp = controller.crearUsuario(nuevo);

        assertEquals(HttpStatus.CREATED, resp.getStatusCode());
        assertEquals(nuevo, resp.getBody());
    }

    @Test
    void obtenerUser_debeRetornarSiExiste() {
        AppUser user = new AppUser();
        user.setIdUser(1L);
        when(userService.obtenerUsuarioPorId(1L)).thenReturn(Optional.of(user));

        ResponseEntity<AppUser> resp = controller.obtenerUsuarioPorId(1L);
        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals(1L, resp.getBody().getIdUser());
    }

    @Test
    void obtenerUser_lanzaExcepcionSiNoExiste() {
        when(userService.obtenerUsuarioPorId(10L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> controller.obtenerUsuarioPorId(10L));
    }

    @Test
    void eliminarUser_debeEliminarSiExiste() {
        AppUser user = new AppUser();
        user.setIdUser(10L);
        when(userService.obtenerUsuarioPorId(10L)).thenReturn(Optional.of(user));
        doNothing().when(userService).eliminarUsuario(10L);

        ResponseEntity<Void> resp = controller.eliminarUsuario(10L);
        assertEquals(HttpStatus.NO_CONTENT, resp.getStatusCode());
    }

    @Test
    void actualizarUser_debeActualizar() {
        AppUser original = new AppUser();
        original.setIdUser(20L); original.setName("Antiguo");

        AppUser editado = new AppUser();
        editado.setName("Editado");

        when(userService.obtenerUsuarioPorId(20L)).thenReturn(Optional.of(original));
        when(userService.guardarUsuario(any(AppUser.class))).thenReturn(editado);

        ResponseEntity<AppUser> resp = controller.actualizarUsuario(20L, editado);

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals("Editado", resp.getBody().getName());
    }
}
