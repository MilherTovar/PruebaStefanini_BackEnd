package com.estefanini.prueba.entity;

import java.util.Date;

import javax.persistence.*;

import com.estefanini.prueba.security.jwt.entity.Usuario;

@Entity
@Table(name="estado",schema = "prueba")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(name="nombre", length = 20, nullable = false)
    private String nombre;
    @Column(name="fecha_creacion",nullable = false)
    private Date fechaCreacion;
    @JoinColumn(name="usuario_creacion",nullable = false)
    @ManyToOne(optional = false,cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Usuario usuarioCreacion;
    @Column(name="fecha_modificacion",nullable = true)
    private Date fechaModificacion;
    @JoinColumn(name="usuario_modificacion",nullable = true)
    @ManyToOne(optional = true,cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Usuario usuarioModificacion;
    public Estado() {
    }
    public Estado(String nombre, Date fechaCreacion, Usuario usuarioCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Usuario getUsuarioCreacion() {
        return usuarioCreacion;
    }
    public void setUsuarioCreacion(Usuario usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
    public Date getFechaModificacion() {
        return fechaModificacion;
    }
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    public Usuario getUsuarioModificacion() {
        return usuarioModificacion;
    }
    public void setUsuarioModificacion(Usuario usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}
