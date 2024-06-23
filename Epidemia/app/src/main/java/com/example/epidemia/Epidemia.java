package com.example.epidemia;

import java.io.Serializable;

public class Epidemia implements Serializable {

    private int Codigo;
    private String Nombre;
    private String Caso;
    private String Dolor;
    private String Primera;
    private String Segunda;
    private String Tercera;
    private String Cuarta;

    public Epidemia(int codigo, String nombre, String caso, String dolor, String primera, String segunda, String tercera, String cuarta) {
        Codigo = codigo;
        Nombre = nombre;
        Caso = caso;
        Dolor = dolor;
        Primera = primera;
        Segunda = segunda;
        Tercera = tercera;
        Cuarta = cuarta;
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

    public String getCaso() {
        return Caso;
    }

    public void setCaso(String caso) {
        Caso = caso;
    }

    public String getDolor() {
        return Dolor;
    }

    public void setDolor(String dolor) {
        Dolor = dolor;
    }

    public String getPrimera() {
        return Primera;
    }

    public void setPrimera(String primera) {
        Primera = primera;
    }

    public String getSegunda() {
        return Segunda;
    }

    public void setSegunda(String segunda) {
        Segunda = segunda;
    }

    public String getTercera() {
        return Tercera;
    }

    public void setTercera(String tercera) {
        Tercera = tercera;
    }

    public String getCuarta() {
        return Cuarta;
    }

    public void setCuarta(String cuarta) {
        Cuarta = cuarta;
    }
}
