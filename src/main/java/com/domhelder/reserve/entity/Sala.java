package com.domhelder.reserve.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity

public class Sala {
    public Sala() {}

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nomeSala;

    private int predio;

    private int andar;

    private int image;

    @Column(nullable = false)
    private boolean isAvailable = true;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

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

    public UUID getId() {return id;}
}
