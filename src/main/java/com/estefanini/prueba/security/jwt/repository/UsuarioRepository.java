package com.estefanini.prueba.security.jwt.repository;

import java.util.Optional;

import com.estefanini.prueba.security.jwt.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario>findByUserName(String username);

    String consulta1="select"
                    +" *"
                    +" from"
                    +" prueba.usuario u "
                    +" where"
                    +" u.username =?1";
    @Query(value=consulta1,nativeQuery = true)
    public Optional<Usuario>ExistUserName(String userName);
}
