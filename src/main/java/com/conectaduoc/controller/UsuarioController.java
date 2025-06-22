package com.conectaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conectaduoc.exception.ResourceNotFoundException;
import com.conectaduoc.model.Usuario;
import com.conectaduoc.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@Validated
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listasUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    // Crear un nuevo usuario con validación
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED); // Devolver 201 Created
    }

    // Obtener un usuario por su ID con manejo de excepción
    @GetMapping("/{email}")
    public ResponseEntity<Usuario> obtenerUsuarioPorEmail(@PathVariable String email) {
        Usuario usuario = usuarioService.obtenerUsuarioPorEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con email: " + email));
        return ResponseEntity.ok(usuario);
    }

    // Eliminar un usuario por su email con manejo de excepción
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String email) {
        // Verifica si el usuario existe, si no, lanza la excepción
        usuarioService.obtenerUsuarioPorEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("El usuario con email " + email + " no fue encontrado."));

        // Elimina el usuario si existe
        usuarioService.eliminarUsuario(email);

        return ResponseEntity.noContent().build(); // Devolver 204 No Content
    }

    // Actualizar un usuario existente con manejo de excepción
    @PutMapping("/{email}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable String email, @Valid @RequestBody Usuario detallesUsuario) {
        Usuario usuario = usuarioService.obtenerUsuarioPorEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("El usuario con email " + email + " no fue encontrado."));

        usuario.setEmail(detallesUsuario.getEmail());
        usuario.setPassword(detallesUsuario.getPassword());
        usuario.setRole(detallesUsuario.getRole());
        Usuario usuarioActualizado = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }
}
