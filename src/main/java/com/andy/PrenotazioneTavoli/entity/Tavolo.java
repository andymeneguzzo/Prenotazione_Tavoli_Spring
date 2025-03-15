package com.andy.PrenotazioneTavoli.entity;

import jakarta.persistence.*;

@Entity
public class Tavolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private int posti;
    private String area;

    // Costruttore vuoto (necessario per JPA)
    public Tavolo() {}

    // Costruttore con parametri
    public Tavolo(int numero, int posti, String area) {
        this.numero = numero;
        this.posti = posti;
        this.area = area;
    }

    // Getters & Setters
    public Long getId() {return id;}
    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {return numero;}
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPosti() {return posti;}
    public void setPosti(int posti) {
        this.posti = posti;
    }

    public String getArea() {return area;}
    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Tavolo [id=" + id + ", numero=" + numero + ", posti=" + posti + ", area=" + area + "]";
    }
}
