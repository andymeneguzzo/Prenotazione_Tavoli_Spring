package com.andy.PrenotazioneTavoli.service;

import com.andy.PrenotazioneTavoli.entity.Utente;
import com.andy.PrenotazioneTavoli.repository.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public Utente salvaUtente(Utente utente) {
        // Possiamo gestire controlli su email duplicata
        return utenteRepository.save(utente);
    }

    public Utente trovaUtentePerId(Long id) {
        return utenteRepository.findById(id).orElse(null);
    }

    public List<Utente> listaUtenti() {
        return utenteRepository.findAll();
    }

    public void eliminaUtente(Long id) {
        utenteRepository.deleteById(id);
    }

    public Utente trovaDaEmail(String email) {
        return utenteRepository.findByEmail(email).orElse(null);
    }
}
