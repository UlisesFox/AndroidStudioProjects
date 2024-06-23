package com.example.disfraces;

import java.io.Serializable;

public class Disfraz implements Serializable {

    private String nombre;
    private String domicilio;
    private String producto;
    private String talla;
    private int telefono;

    public Disfraz() {
        this.nombre = "none";
        this.domicilio = "none";
        this.producto = "none";
        this.talla = "none";
        this.telefono = 0;
    }

    public Disfraz(String nombre, String domicilio, String producto, String talla, int telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.producto = producto;
        this.talla = talla;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
