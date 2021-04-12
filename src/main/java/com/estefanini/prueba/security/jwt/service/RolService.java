package com.estefanini.prueba.security.jwt.service;

import java.util.Optional;

import com.estefanini.prueba.security.enums.RolNombre;
import com.estefanini.prueba.security.jwt.entity.Rol;
import com.estefanini.prueba.security.jwt.repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public Optional<Rol>findByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save (Rol rol){
        rolRepository.save(rol);
    }
}
