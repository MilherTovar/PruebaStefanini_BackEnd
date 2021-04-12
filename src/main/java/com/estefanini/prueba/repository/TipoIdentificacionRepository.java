package com.estefanini.prueba.repository;

import java.util.Optional;

import com.estefanini.prueba.entity.TipoIdentificacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion,Integer> {
    String consulta1="select"
                    +" *"
                    +" from"
                    +" prueba.tipo_identificacion ti"
                    +" where"
                    +" ti.nombre =?1";
    
    @Query(value = consulta1,nativeQuery = true)
    public Optional<TipoIdentificacion>findByTipoIdentificacion(String tipo);
}
