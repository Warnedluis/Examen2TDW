package com.upiiz.examen2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.upiiz.examen2.entities.UsuarioEntity;

import com.upiiz.examen2.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    @Autowired
    UsuarioRepository usuarioRepository;

    UsuarioServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioEntity RegistrarUsuario(UsuarioEntity usuario)
    {
        usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UsuarioEntity usuario = usuarioRepository.findByEmail(email);

        return User.builder()
            .username(usuario.getEmail())
            .password(usuario.getContrasenia())
            .roles("USER")
            .build();

    }
    
}
