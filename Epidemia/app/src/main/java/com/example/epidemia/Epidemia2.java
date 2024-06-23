package com.example.epidemia;

import java.io.Serializable;

public class Epidemia2 implements Serializable {

    private String dato;

    public Epidemia2(String dato) {
        this.dato = dato;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
}