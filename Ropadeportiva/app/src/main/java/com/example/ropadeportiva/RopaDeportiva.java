package com.example.ropadeportiva;

public class RopaDeportiva {

    private int código;
    private String marca;
    private String modelo;
    private int costo;
    private String talla;
    private String negro;
    private String blanco;
    private String azul;
    private String rojo;
    private String naranja;

    public RopaDeportiva(int código, String marca, String modelo, int costo, String talla, String negro, String blanco, String azul, String rojo, String naranja) {
        this.código = código;
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
        this.talla = talla;
        this.negro = negro;
        this.blanco = blanco;
        this.azul = azul;
        this.rojo = rojo;
        this.naranja = naranja;
    }

    public int getCódigo() {
        return código;
    }

    public void setCódigo(int código) {
        this.código = código;
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

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getNegro() {
        return negro;
    }

    public void setNegro(String negro) {
        this.negro = negro;
    }

    public String getBlanco() {
        return blanco;
    }

    public void setBlanco(String blanco) {
        this.blanco = blanco;
    }

    public String getAzul() {
        return azul;
    }

    public void setAzul(String azul) {
        this.azul = azul;
    }

    public String getRojo() {
        return rojo;
    }

    public void setRojo(String rojo) {
        this.rojo = rojo;
    }

    public String getNaranja() {
        return naranja;
    }

    public void setNaranja(String naranja) {
        this.naranja = naranja;
    }
}
