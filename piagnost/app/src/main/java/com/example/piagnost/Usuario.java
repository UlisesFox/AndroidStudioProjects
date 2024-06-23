package com.example.piagnost;

public class Usuario {
    private String usuario;
    private String contra;
    private boolean registrado;

    public Usuario() {
        this.usuario = "none";
        this.contra = "none";
        this.registrado = false;
    }

    public Usuario(String usuario, String contra, boolean registrado) {
        this.usuario = usuario;
        this.contra = contra;
        this.registrado = registrado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }
}