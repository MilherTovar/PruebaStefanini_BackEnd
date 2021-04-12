package com.estefanini.prueba.util;

import com.estefanini.prueba.security.enums.RolNombre;
import com.estefanini.prueba.security.jwt.entity.Rol;
import com.estefanini.prueba.security.jwt.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {
    @Autowired
    RolService rolService;
    @Override
    public void run(String... args) throws Exception {
        /*Rol rolAdmin=new Rol(RolNombre.Administrador);
        Rol rolUsuario=new Rol(RolNombre.Usuario);
        rolService.save(rolAdmin);
        rolService.save(rolUsuario);*/
    }
    
}
