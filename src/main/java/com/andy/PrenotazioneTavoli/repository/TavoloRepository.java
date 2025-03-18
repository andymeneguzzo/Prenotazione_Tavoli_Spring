package com.andy.PrenotazioneTavoli.repository;

import com.andy.PrenotazioneTavoli.entity.Tavolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TavoloRepository extends JpaRepository<Tavolo, Long> {

    // Cerca tavoli per posti maggiori o uguali
    List<Tavolo> findByPostiGreaterThanEqual(int posti);
}
