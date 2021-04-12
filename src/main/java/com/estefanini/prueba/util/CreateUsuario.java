package com.estefanini.prueba.util;

import com.estefanini.prueba.security.jwt.entity.Usuario;
import com.estefanini.prueba.security.jwt.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateUsuario implements CommandLineRunner {
    @Autowired
    UsuarioService usuarioService;
    @Override
    public void run(String... args) throws Exception {
        /*Usuario usuario=new Usuario("Milher","Tovar","mil.tovar","Camila1447",
        16188167);
        usuarioService.save(usuario);*/
    }
    
}
