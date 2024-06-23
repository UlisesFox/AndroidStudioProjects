package com.example.appactivity;

public class Motocicleta {
    private int id;
    private String codigo;
    private double costo;
    private boolean estado;

    public Motocicleta(int id, String codigo, double costo, boolean estado) {
        this.id = id;
        this.codigo = codigo;
        this.costo = costo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
