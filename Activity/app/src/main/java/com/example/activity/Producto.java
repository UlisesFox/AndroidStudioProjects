package com.example.activity;

import java.io.Serializable;

public class Producto implements Serializable {

    private int codigo;
    private String descripcion;
    private String color;
    private float costo;

    public Producto(int codigo, String descripcion, String color, float costo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.color = color;
        this.costo = costo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
