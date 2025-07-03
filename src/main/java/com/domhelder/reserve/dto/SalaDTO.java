package com.domhelder.reserve.dto;


import jakarta.annotation.Nullable;

public class SalaDTO {
    private String nomeSala;
    private int predio;
    private int andar;
    private int image;

    @Nullable
    private Boolean isAvailable;

    public Boolean isAvailable() { return isAvailable; }

    public void setAvailable(Boolean available) { isAvailable = available; }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public int getPredio() {
        return predio;
    }

    public void setPredio(int predio) {
        this.predio = predio;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }
}
