package com.estefanini.prueba.util;

import java.util.Date;

import com.estefanini.prueba.entity.Estado;
import com.estefanini.prueba.security.jwt.entity.Usuario;
import com.estefanini.prueba.security.jwt.service.UsuarioService;
import com.estefanini.prueba.service.EstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateTipoEstado implements CommandLineRunner {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    EstadoService estadoService;
    @Override
    public void run(String... args) throws Exception {
        /*Usuario usuario=usuarioService.findByUserName("mil.tovar").get();
        Estado tipoEstado=new Estado("Activo", new Date(new Date().getTime()), usuario);
        estadoService.save(tipoEstado);*/
    }
    
}
