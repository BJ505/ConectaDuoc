package com.conectaduoc.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.conectaduoc.model.AppUser;
import com.conectaduoc.repository.AppUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AppUserRepository usuarioRepository;

    public CustomUserDetailsService(AppUserRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser usuario = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Construir UserDetails desde la entidad Usuario
        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword()) // Contraseña cifrada
                .roles(usuario.getRole()) // Rol debe coincidir con los definidos en tu configuración
                .build();
    }
}