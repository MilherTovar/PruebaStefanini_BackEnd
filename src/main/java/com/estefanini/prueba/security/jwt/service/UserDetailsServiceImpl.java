package com.estefanini.prueba.security.jwt.service;

import com.estefanini.prueba.security.jwt.entity.Usuario;
import com.estefanini.prueba.security.jwt.entity.UsuarioPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario=usuarioService.findByUserName(username).get();
        return UsuarioPrincipal.build(usuario);
    }
    
}
