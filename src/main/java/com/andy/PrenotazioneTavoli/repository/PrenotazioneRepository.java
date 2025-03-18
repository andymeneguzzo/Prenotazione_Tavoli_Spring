package com.andy.PrenotazioneTavoli.repository;

import com.andy.PrenotazioneTavoli.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository  extends JpaRepository<Prenotazione, Long> {

    // filtra per data
    List<Prenotazione> findByDataPrenotazione(LocalDate date);
}
