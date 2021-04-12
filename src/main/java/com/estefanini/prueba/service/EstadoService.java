package com.estefanini.prueba.service;

import java.util.Optional;

import com.estefanini.prueba.entity.Estado;
import com.estefanini.prueba.repository.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstadoService {
    @Autowired
    EstadoRepository estadoRepository;

    public void save(Estado estado){
        estadoRepository.save(estado);
    }

    public Optional<Estado> findByNombre(String nombre){
        return estadoRepository.findByNombre(nombre);
    }
}
