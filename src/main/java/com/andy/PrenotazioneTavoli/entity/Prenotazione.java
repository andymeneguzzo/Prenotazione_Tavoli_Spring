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
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "tavolo_id")
    private Tavolo tavolo;

    private LocalDate dataPrenotazione;
    private LocalTime oraPrenotazione;
    private int durataInOre;
    private int numeroPersone;
    private String note;

    // Costruttore vuoto per JPA
    public Prenotazione() {}

    public Prenotazione(Utente utente, Tavolo tavolo, LocalDate dataPrenotazione,
                        LocalTime oraPrenotazione, int durataInOre, int numeroPersone, String note) {
        this.utente = utente;
        this.tavolo = tavolo;
        this.dataPrenotazione = dataPrenotazione;
        this.oraPrenotazione = oraPrenotazione;
        this.durataInOre = durataInOre;
        this.numeroPersone = numeroPersone;
        this.note = note;
    }

    // Getter e Setter
    public Long getId() {return id;}
    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {this.utente = utente;}
    public Tavolo getTavolo() {
        return tavolo;
    }

    public void setTavolo(Tavolo tavolo) {this.tavolo = tavolo;}
    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(LocalDate dataPrenotazione) {this.dataPrenotazione = dataPrenotazione;}
    public LocalTime getOraPrenotazione() {
        return oraPrenotazione;
    }

    public void setOraPrenotazione(LocalTime oraPrenotazione) {this.oraPrenotazione = oraPrenotazione;}
    public int getDurataInOre() {
        return durataInOre;
    }

    public void setDurataInOre(int durataInOre) {this.durataInOre = durataInOre;}
    public int getNumeroPersone() {
        return numeroPersone;
    }

    public void setNumeroPersone(int numeroPersone) {this.numeroPersone = numeroPersone;}
    public String getNote() {
        return note;
    }

    public void setNote(String note) {this.note = note;}

    @Override
    public String toString() {
        return "Prenotazione [id=" + id + ", utente=" + utente.getNome() + ", tavolo=" + tavolo.getNumero()
                + ", dataPrenotazione=" + dataPrenotazione + ", oraPrenotazione=" + oraPrenotazione
                + ", durataInOre=" + durataInOre + ", numeroPersone=" + numeroPersone + ", note=" + note + "]";
    }
}
