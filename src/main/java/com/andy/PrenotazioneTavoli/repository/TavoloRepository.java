package com.andy.PrenotazioneTavoli.repository;

import com.andy.PrenotazioneTavoli.entity.Tavolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TavoloRepository extends JpaRepository<Tavolo, Long> {
    // Aggiungi metodi CRUD specifici
}

// metodi implementati automaticamente da Spring Data JPA