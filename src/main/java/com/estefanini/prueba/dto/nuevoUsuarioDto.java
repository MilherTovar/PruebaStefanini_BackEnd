package com.estefanini.prueba.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

public class nuevoUsuarioDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    private Date fechaNacimiento;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    private double identificacion;
    private String tipoIdentificacion;
    private Set<String> roles=new HashSet<>();
    public nuevoUsuarioDto() {
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
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
    public Set<String> getRoles() {
        return roles;
    }
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
