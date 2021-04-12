package com.estefanini.prueba.entity;

import java.util.Date;

import javax.persistence.*;

import com.estefanini.prueba.security.jwt.entity.Usuario;

@Entity
@Table(name="tipo_identificacion", schema = "prueba")
public class TipoIdentificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(name="nombre", length = 20,nullable = false)
    private String nombre;
    @Column(name="fecha_creacion", nullable = false)
    private Date fecha_creacion;
    @JoinColumn(name="usuario_creacion",nullable = false)
    @ManyToOne(optional = false,cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Usuario usuario_creacion;
    @Column(name="fecha_modificacion", nullable=true)
    private Date fecha_modificacion;
    @JoinColumn(name="usuario_modificacion",nullable = true)
    @ManyToOne(optional = true,cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Usuario usuario_modificacion;
    public TipoIdentificacion(String nombre,Date fecha_creacion, Usuario usuario_creacion) {
        this.nombre = nombre;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion=fecha_creacion;
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
    public Date getFecha_creacion() {
        return fecha_creacion;
    }
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    public Usuario getUsuario_creacion() {
        return usuario_creacion;
    }
    public void setUsuario_creacion(Usuario usuario_creacion) {
        this.usuario_creacion = usuario_creacion;
    }
    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }
    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
    public Usuario getUsuario_modificacion() {
        return usuario_modificacion;
    }
    public void setUsuario_modificacion(Usuario usuario_modificacion) {
        this.usuario_modificacion = usuario_modificacion;
    }
    public TipoIdentificacion() {
    }
}
