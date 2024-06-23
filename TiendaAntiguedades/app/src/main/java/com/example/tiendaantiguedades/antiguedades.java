package com.example.tiendaantiguedades;

public class antiguedades {

    private String nombre;
    private int telefono;
    private String mail;
    private String antiguedad;

    public antiguedades(String nombre, int telefono, String mail, String antiguedad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }
}
