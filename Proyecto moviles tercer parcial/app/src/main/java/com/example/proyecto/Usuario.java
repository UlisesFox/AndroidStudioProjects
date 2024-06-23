package com.example.proyecto;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;

    public Usuario() {
        nombre = "";
        apellido = "";
        email = "";
        contrasena = "";
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
