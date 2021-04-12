package com.estefanini.prueba.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class UsuarioModificarDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    private Date fecha_nacimiento;
    @NotBlank
    private String password;
    private String userName;
    public UsuarioModificarDto() {
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
