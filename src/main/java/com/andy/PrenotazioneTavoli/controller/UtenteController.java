package com.andy.PrenotazioneTavoli.controller;

import com.andy.PrenotazioneTavoli.entity.Utente;
import com.andy.PrenotazioneTavoli.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public List<Utente> getAllUtenti() {
        return utenteService.listaUtenti();
    }

    @PostMapping("/registrazione")
    public Utente registraUtente(@RequestBody Utente utente) {
        return utenteService.creaUtente(utente);
    }

    @DeleteMapping("/{id}")
    public void deleteUtente(@PathVariable Long id) {
        utenteService.eliminaUtente(id);
    }
}
