package com.andy.PrenotazioneTavoli.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tavolo_id")
    private Tavolo tavolo;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    private LocalDate dataPrenotazione;
    private LocalTime oraPrenotazione;

    private int durataInOre;

    private String note;

    public Prenotazione() {}

    public Prenotazione(Tavolo tavolo, Utente utente, LocalDate dataPrenotazione, LocalTime oraPrenotazione, int durataInOre, String note) {
        this.tavolo = tavolo;
        this.utente = utente;
        this.dataPrenotazione = dataPrenotazione;
        this.oraPrenotazione = oraPrenotazione;
        this.durataInOre = durataInOre;
        this.note = note;
    }

    // Getter & Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Tavolo getTavolo() {
        return tavolo;
    }
    public void setTavolo(Tavolo tavolo) {
        this.tavolo = tavolo;
    }

    public Utente getUtente() {
        return utente;
    }
    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }
    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public LocalTime getOraPrenotazione() {
        return oraPrenotazione;
    }
    public void setOraPrenotazione(LocalTime oraPrenotazione) {
        this.oraPrenotazione = oraPrenotazione;
    }

    public int getDurataInOre() {
        return durataInOre;
    }
    public void setDurataInOre(int durataInOre) {
        this.durataInOre = durataInOre;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
}
