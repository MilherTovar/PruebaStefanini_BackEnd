package com.estefanini.prueba.service;

import java.util.Optional;

import com.estefanini.prueba.entity.TipoIdentificacion;
import com.estefanini.prueba.repository.TipoIdentificacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoIdentificacionService {
    @Autowired
    TipoIdentificacionRepository tipoIdentificacionRepository;

    public Optional<TipoIdentificacion>findByTipoIdentificacion(String tipo){
        return tipoIdentificacionRepository.findByTipoIdentificacion(tipo);
    }

    public void save(TipoIdentificacion tipoIdentificacion){
        tipoIdentificacionRepository.save(tipoIdentificacion);
    }
}
