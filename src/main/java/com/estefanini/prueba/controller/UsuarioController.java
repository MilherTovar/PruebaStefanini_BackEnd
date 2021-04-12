package com.estefanini.prueba.controller;

import javax.validation.Valid;

import com.estefanini.prueba.dto.Mensaje;
import com.estefanini.prueba.dto.UsuarioLogueo;
import com.estefanini.prueba.dto.UsuarioModificarDto;
import com.estefanini.prueba.dto.nuevoUsuarioDto;
import com.estefanini.prueba.security.jwt.dto.JwtDto;
import com.estefanini.prueba.security.jwt.service.UsuarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/user")
public class UsuarioController {
    public final static Logger logger=LoggerFactory.getLogger(UsuarioController.class);
    @Autowired
    UsuarioService usuarioService;
    @PostMapping
    public ResponseEntity<?>nuevoUsuario(@Valid @RequestBody nuevoUsuarioDto nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Errores en el Json"),HttpStatus.BAD_REQUEST);
        String resp=usuarioService.save(nuevoUsuario);
        if(resp!="OK")
            return new ResponseEntity(new Mensaje(resp),HttpStatus.BAD_REQUEST);
        return new ResponseEntity(new Mensaje("Usuario Creado exitosamente"),HttpStatus.OK);
    }
    @GetMapping("/logueo")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody UsuarioLogueo usuarioLogueo, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal diligenciados"),HttpStatus.BAD_REQUEST);
        JwtDto resp=usuarioService.logeo(usuarioLogueo);
        if(resp.getToken()=="Error")
            return new ResponseEntity(new Mensaje(resp.getUserName()),HttpStatus.BAD_REQUEST);
        return new ResponseEntity(resp,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UsuarioModificarDto>update(@Valid @RequestBody UsuarioModificarDto usuarioModificar,BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal diligenciados"),HttpStatus.BAD_REQUEST);
        UsuarioModificarDto resp=usuarioService.update(usuarioModificar);
        if(resp.getNombre()!="Error"){
            return new ResponseEntity(resp,HttpStatus.OK);
        }else
        {
            return new ResponseEntity(new Mensaje(resp.getUserName()),HttpStatus.BAD_REQUEST);
        }
    }
}
