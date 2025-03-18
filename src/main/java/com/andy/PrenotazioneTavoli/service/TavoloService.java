package com.andy.PrenotazioneTavoli.service;

import com.andy.PrenotazioneTavoli.entity.Tavolo;
import com.andy.PrenotazioneTavoli.repository.TavoloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TavoloService {

    private final TavoloRepository tavoloRepository;

    // Inietto repo tramite costruttore
    public TavoloService(TavoloRepository tavoloRepository) {
        this.tavoloRepository = tavoloRepository;
    }

    // CREATE - UPDATE
    public Tavolo salvaTavolo(Tavolo tavolo) {
        return tavoloRepository.save(tavolo);
    }
    // READ - singolo record
    public Tavolo trovaTavoloPerId(Long id) {
        Optional<Tavolo> tavolo = tavoloRepository.findById(id);
        return tavolo.orElse(null); // possiamo gestire eccezione
    }
    // READ - tutti i tavoli
    public List<Tavolo> listaTavoli() {
        return tavoloRepository.findAll();
    }
    // DELETE
    public void eliminaTavolo(Long id) {
        tavoloRepository.deleteById(id);
    }

    public List<Tavolo> tavoliConAlmenoXPosti(int posti) {
        return tavoloRepository.findByPostiGreaterThanEqual(posti);
    }
}
