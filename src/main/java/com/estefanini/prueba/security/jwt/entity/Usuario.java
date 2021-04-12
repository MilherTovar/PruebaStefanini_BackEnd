package com.estefanini.prueba.security.jwt.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.estefanini.prueba.entity.Estado;
import com.estefanini.prueba.entity.TipoIdentificacion;

@Entity
@Table(name = "usuario",schema = "prueba")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(name="nombre",length = 100, nullable = false)
    private String nombre;
    @Column(name="apellido", length = 100, nullable = false)
    private String apellido;
    @Column(name="fecha_nacimiento",nullable=true)
    private Date fecha_nacimiento;
    @Column(name="username", length = 20,nullable = false)
    private String userName;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name="identificacion",nullable = false)
    private double identificacion;
    @JoinColumn(name="codigo_tipo_identificacion",nullable = true)
    @ManyToOne(optional = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private TipoIdentificacion codigo_tipo_identificacion;
    @JoinColumn(name="codigo_estado",nullable = true)
    @ManyToOne(optional = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Estado codigoEstado;
    @ManyToMany
    @JoinTable(schema = "prueba",name="usuario_rol",joinColumns = @JoinColumn(name="codigo"),
    inverseJoinColumns=@JoinColumn(name="rol_id"))
    private Set<Rol> roles=new HashSet<>();
    public Usuario() {
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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public double getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(double identificacion) {
        this.identificacion = identificacion;
    }
    public TipoIdentificacion getCodigo_tipo_identificacion() {
        return codigo_tipo_identificacion;
    }
    public void setCodigo_tipo_identificacion(TipoIdentificacion codigo_tipo_identificacion) {
        this.codigo_tipo_identificacion = codigo_tipo_identificacion;
    }
    public Estado getCodigoEstado() {
        return codigoEstado;
    }
    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }
    public Set<Rol> getRoles() {
        return roles;
    }
    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
    public Usuario(String nombre, String apellido, String userName, String password,
            double identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.userName = userName;
        this.password = password;
        this.identificacion = identificacion;
    }
}
