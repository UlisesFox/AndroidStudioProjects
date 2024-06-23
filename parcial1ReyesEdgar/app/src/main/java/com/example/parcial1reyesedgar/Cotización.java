package com.example.parcial1reyesedgar;

public class Cotización {

    private int folio;
    private String marca;
    private String modelo;
    private int trasmision;
    private int enganche;
    private int mensualidad;
    private int Comisión;

    public Cotización(int folio, String marca, String modelo, int trasmision, int enganche, int mensualidad, int comisión) {
        this.folio = folio;
        this.marca = marca;
        this.modelo = modelo;
        this.trasmision = trasmision;
        this.enganche = enganche;
        this.mensualidad = mensualidad;
        Comisión = comisión;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getTrasmision() {
        return trasmision;
    }

    public void setTrasmision(int trasmision) {
        this.trasmision = trasmision;
    }

    public int getEnganche() {
        return enganche;
    }

    public void setEnganche(int enganche) {
        this.enganche = enganche;
    }

    public int getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(int mensualidad) {
        this.mensualidad = mensualidad;
    }

    public int getComisión() {
        return Comisión;
    }

    public void setComisión(int comisión) {
        Comisión = comisión;
    }
}
