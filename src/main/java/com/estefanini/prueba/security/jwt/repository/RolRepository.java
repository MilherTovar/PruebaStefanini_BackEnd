package com.estefanini.prueba.security.jwt.repository;

import java.util.Optional;

import com.estefanini.prueba.security.enums.RolNombre;
import com.estefanini.prueba.security.jwt.entity.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol,Integer>{
    Optional<Rol>findByRolNombre(RolNombre rolNombre);    
}
