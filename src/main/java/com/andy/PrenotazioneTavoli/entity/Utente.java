package com.andy.PrenotazioneTavoli.entity;

import jakarta.persistence.*;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;
    private String password;
    private String ruolo;

    // Costruttore vuoto per JPA
    public Utente() {}

    public Utente(String nome, String email, String password, String ruolo) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.ruolo = ruolo;
    }

    // Getters e Setters
    public Long getId() {return id;}
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {return password;}
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRuolo() {return ruolo;}
    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public String toString() {
        return "Utente [id=" + id + ", nome=" + nome + ", email=" + email + ", ruolo=" + ruolo + "]";
    }
}
