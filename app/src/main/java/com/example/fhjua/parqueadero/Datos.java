package com.example.fhjua.parqueadero;

public class Datos {
    private int imagen;
    private String fechaHora;
    private String numeroIngreso;

    public Datos(int imagen, String fechaHora, String numeroIngreso) {
        this.imagen = imagen;
        this.fechaHora = fechaHora;
        this.numeroIngreso = numeroIngreso;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNumeroIngreso() {
        return numeroIngreso;
    }

    public void setNumeroIngreso(String numeroIngreso) {
        this.numeroIngreso = numeroIngreso;
    }
}
