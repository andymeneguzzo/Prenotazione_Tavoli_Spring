package com.andy.PrenotazioneTavoli.controller;

import com.andy.PrenotazioneTavoli.entity.Utente;
import com.andy.PrenotazioneTavoli.service.UtenteService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/utenti")
public class UtenteController {

    private final UtenteService utenteService;

    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping
    public List<Utente> getUtenti() {
        return utenteService.listaUtenti();
    }

    @GetMapping("/{id}")
    public Utente getUtente(@PathVariable Long id) {
        return utenteService.trovaUtentePerId(id);
    }

    @PostMapping
    public Utente creaUtente(@RequestBody Utente utente) {
        return utenteService.salvaUtente(utente);
    }

    @PutMapping("/{id}")
    public Utente aggiornaUtente(@PathVariable Long id, @RequestBody Utente utente) {
        Utente esistente = utenteService.trovaUtentePerId(id);

        if(esistente != null) {
            esistente.setNome((utente.getNome()));
            esistente.setEmail(utente.getEmail());
            esistente.setPassword(utente.getPassword());
            esistente.setRuolo(utente.getRuolo());

            return utenteService.salvaUtente(esistente);
        }
        return null; // gestire eccezione
    }

    @DeleteMapping("/{id}")
    public void eliminaUtente(@PathVariable Long id) {
        utenteService.eliminaUtente(id);
    }
}
