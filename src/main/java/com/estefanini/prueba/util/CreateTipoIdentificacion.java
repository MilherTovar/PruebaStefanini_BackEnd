package com.estefanini.prueba.util;

import java.util.Date;

import com.estefanini.prueba.entity.TipoIdentificacion;
import com.estefanini.prueba.security.jwt.entity.Usuario;
import com.estefanini.prueba.security.jwt.service.UsuarioService;
import com.estefanini.prueba.service.TipoIdentificacionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class CreateTipoIdentificacion implements CommandLineRunner {
    public final static Logger logger=LoggerFactory.getLogger(CreateTipoIdentificacion.class);
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    TipoIdentificacionService tipoIdentificacionService;
    @Override
    public void run(String... args) throws Exception {
        /*Usuario usuario=usuarioService.findByUserName("mil.tovar").get();
        logger.info(String.valueOf(usuario.getCodigo()));
        TipoIdentificacion tipoIdentificacion=new TipoIdentificacion("CC", new Date(new Date().getTime()), usuario);
        logger.info(tipoIdentificacion.toString());
        tipoIdentificacionService.save(tipoIdentificacion);*/
    }
    
}
