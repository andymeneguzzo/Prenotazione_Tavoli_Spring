package com.andy.PrenotazioneTavoli.entity;

import jakarta.persistence.*;

@Entity
public class Tavolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    private int posti;

    private String sala;

    public Tavolo() {}

    public Tavolo(int numero, int posti, String sala) {
        this.numero = numero;
        this.posti = posti;
        this.sala = sala;
    }

    // Getter & Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPosti() {
        return posti;
    }
    public void setPosti(int posti) {
        this.posti = posti;
    }

    public String getSala() {
        return sala;
    }
    public void setSala(String sala) {
        this.sala = sala;
    }
}
