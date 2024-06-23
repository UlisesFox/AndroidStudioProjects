package com.example.piagnost;

public class ArmasDuras {

    private int Codigo;
    private String Nombre;
    private String tipo;
    private String rareza;
    private String encantado;
    private String bendecido;
    private String maldito;
    private String roto;
    private String reliquia;

    public ArmasDuras(int codigo, String nombre, String tipo, String rareza, String encantado, String bendecido, String maldito, String roto, String reliquia) {
        Codigo = codigo;
        Nombre = nombre;
        this.tipo = tipo;
        this.rareza = rareza;
        this.encantado = encantado;
        this.bendecido = bendecido;
        this.maldito = maldito;
        this.roto = roto;
        this.reliquia = reliquia;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRareza() {
        return rareza;
    }

    public void setRareza(String rareza) {
        this.rareza = rareza;
    }

    public String getEncantado() {
        return encantado;
    }

    public void setEncantado(String encantado) {
        this.encantado = encantado;
    }

    public String getBendecido() {
        return bendecido;
    }

    public void setBendecido(String bendecido) {
        this.bendecido = bendecido;
    }

    public String getMaldito() {
        return maldito;
    }

    public void setMaldito(String maldito) {
        this.maldito = maldito;
    }

    public String getRoto() {
        return roto;
    }

    public void setRoto(String roto) {
        this.roto = roto;
    }

    public String getReliquia() {
        return reliquia;
    }

    public void setReliquia(String reliquia) {
        this.reliquia = reliquia;
    }
}
