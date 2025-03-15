package com.andy.PrenotazioneTavoli.repository;

import com.andy.PrenotazioneTavoli.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByDataPrenotazione(LocalDate dataPrenotazione);
}

// metodi implementati automaticamente da Spring Data JPA