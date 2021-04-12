package com.estefanini.prueba.repository;

import java.util.Optional;

import com.estefanini.prueba.entity.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstadoRepository extends JpaRepository<Estado,Integer> {
    String consulta1="select"
                    +" *"
                    +" from"
                    +" prueba.estado e" 
                    +" where"
                    +" e.nombre =?1";
    @Query(value=consulta1,nativeQuery = true)
    public Optional<Estado> findByNombre(String nombre);
}
