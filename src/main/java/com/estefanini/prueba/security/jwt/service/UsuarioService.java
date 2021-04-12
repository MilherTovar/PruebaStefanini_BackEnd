package com.estefanini.prueba.security.jwt.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.estefanini.prueba.dto.UsuarioLogueo;
import com.estefanini.prueba.dto.UsuarioModificarDto;
import com.estefanini.prueba.dto.nuevoUsuarioDto;
import com.estefanini.prueba.entity.TipoIdentificacion;
import com.estefanini.prueba.security.enums.RolNombre;
import com.estefanini.prueba.security.jwt.JwtProvider;
import com.estefanini.prueba.security.jwt.dto.JwtDto;
import com.estefanini.prueba.security.jwt.entity.Rol;
import com.estefanini.prueba.security.jwt.entity.Usuario;
import com.estefanini.prueba.security.jwt.repository.UsuarioRepository;
import com.estefanini.prueba.service.EstadoService;
import com.estefanini.prueba.service.TipoIdentificacionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
    public final static Logger logger=LoggerFactory.getLogger(UsuarioService.class);
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RolService rolService;
    @Autowired
    TipoIdentificacionService tipoIdentificacionService;
    @Autowired
    EstadoService estadoService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    public Optional<Usuario>findByUserName(String username){
        return usuarioRepository.findByUserName(username);
    }

    public String save(nuevoUsuarioDto nuevoUsuario){
        String retorno;
        try{
            Optional<Usuario> usuarioValidarOptional=usuarioRepository.ExistUserName(nuevoUsuario.getUserName());
            if(usuarioValidarOptional.isPresent()==false)
            {
                Usuario usuario=new Usuario(nuevoUsuario.getNombre(),nuevoUsuario.getApellido(),nuevoUsuario.getUserName(),
                                    passwordEncoder.encode(nuevoUsuario.getPassword()),nuevoUsuario.getIdentificacion());
                Set<Rol> roles=new HashSet<>();
                roles.add(rolService.findByRolNombre(RolNombre.Usuario).get());
                if(nuevoUsuario.getRoles().contains("Administrador"))
                    roles.add(rolService.findByRolNombre(RolNombre.Administrador).get());
                usuario.setRoles(roles);
                TipoIdentificacion tipoIdentificacion=tipoIdentificacionService.findByTipoIdentificacion(nuevoUsuario.getTipoIdentificacion()).get();
                usuario.setCodigo_tipo_identificacion(tipoIdentificacion);
                usuario.setCodigoEstado(estadoService.findByNombre("Activo").get());
                usuarioRepository.save(usuario);
                retorno="OK";
            }
            else
            {
                retorno="Usuario ya creado";
            }
        }
        catch(Exception e){
            retorno=e.toString();
        }
        return retorno;
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public JwtDto logeo(UsuarioLogueo usuario){
        JwtDto retorno=new JwtDto();
        try{
            Authentication authentication=
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getUserName(), usuario.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt=jwtProvider.generateToken(authentication);
            UserDetails userDetails=(UserDetails) authentication.getPrincipal();
            retorno.setUserName(userDetails.getUsername());
            retorno.setToken(jwt);
            retorno.setAuthorities(userDetails.getAuthorities());
        }
        catch(Exception e){
            retorno.setUserName(e.toString());
            retorno.setToken("Error");
        }
        return retorno;
    }

    public UsuarioModificarDto update(UsuarioModificarDto usuario){
        UsuarioModificarDto retorno=new UsuarioModificarDto();
        try{
            Optional<Usuario>usuarioValidarOpcional=usuarioRepository.ExistUserName(usuario.getUserName());
            if(usuarioValidarOpcional.isPresent()==true){
                Usuario usuarioActualizar=usuarioRepository.getById(usuarioValidarOpcional.get().getCodigo());
                usuarioActualizar.setNombre(usuario.getNombre());
                usuarioActualizar.setApellido(usuario.getApellido());
                usuarioActualizar.setFecha_nacimiento(usuario.getFecha_nacimiento());
                usuarioActualizar.setPassword(passwordEncoder.encode(usuario.getPassword()));
                usuarioRepository.save(usuarioActualizar);
                retorno.setNombre(usuarioActualizar.getNombre());
                retorno.setApellido(usuario.getApellido());
                retorno.setFecha_nacimiento(usuario.getFecha_nacimiento());
                retorno.setPassword(passwordEncoder.encode(usuario.getPassword()));
            }
            else{
                retorno.setUserName("Usuario no encontrado");
                retorno.setNombre("Error");
            }
        }
        catch(Exception e){
            retorno.setUserName(e.toString());
            retorno.setNombre("Error");
        }
        return retorno;
    }
}
