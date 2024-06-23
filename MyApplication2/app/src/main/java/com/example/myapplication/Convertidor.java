package com.example.myapplication;

public class Convertidor {
    private double metros;
    private double resultado;
    private String tipo;
    private double Pies;
    private double Pulgadas;
    private double Yardas;

    public Convertidor(double metros, double resultado, String tipo) {
        this.metros = metros;
        this.resultado = resultado;
        this.tipo = tipo;
    }

    public Convertidor() {
        this.metros = 0;
        this.resultado = 0;
        this.tipo = "pies";
    }

    public double getMetros() {
        return metros;
    }

    public void setMetros(double metros) {
        this.metros = metros;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPies() {
        return Pies;
    }

    public void setPies(double pies) {
        Pies = pies;
    }

    public double getPulgadas() {
        return Pulgadas;
    }

    public void setPulgadas(double pulgadas) {
        Pulgadas = pulgadas;
    }

    public double getYardas() {
        return Yardas;
    }

    public void setYardas(double yardas) {
        Yardas = yardas;
    }
}
