package com.andy.PrenotazioneTavoli.service;

import com.andy.PrenotazioneTavoli.entity.Utente;
import com.andy.PrenotazioneTavoli.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente registraUtente(Utente utente) {
        Optional<Utente> esistente = utenteRepository.findByEmail(utente.getEmail());
        if (esistente.isPresent()) {
            throw new RuntimeException("L'email " + utente.getEmail() + " è già registrata!");
        }
        return utenteRepository.save(utente);
    }

    public Optional<Utente> trovaUtentePerEmail(String email) {
        return utenteRepository.findByEmail(email);
    }

    public List<Utente> listaUtenti() {
        return utenteRepository.findAll();
    }

    public void eliminaUtente(Long id) {
        utenteRepository.deleteById(id);
    }


    private PasswordEncoder passwordEncoder;
    public Utente creaUtente(Utente utente) {
        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        return utenteRepository.save(utente);
    }
}
