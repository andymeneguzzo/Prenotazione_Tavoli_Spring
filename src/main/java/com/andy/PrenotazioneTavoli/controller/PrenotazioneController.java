package com.andy.PrenotazioneTavoli.controller;

import com.andy.PrenotazioneTavoli.entity.Prenotazione;
import com.andy.PrenotazioneTavoli.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneService.listaPrenotazioni();
    }

    @PostMapping
    public Prenotazione createPrenotazione(@RequestBody Prenotazione prenotazione) {
        return prenotazioneService.creaPrenotazione(prenotazione);
    }

    @GetMapping("/data/{dataPrenotazione}")
    public List<Prenotazione> prenotazioniPerData(@PathVariable String dataPrenotazione) {
        LocalDate data = LocalDate.parse(dataPrenotazione);
        return prenotazioneService.trovaPrenotazioniPerData(data);
    }

    @DeleteMapping("/{id}")
    public void deletePrenotazione(@PathVariable Long id) {
        prenotazioneService.eliminaPrenotazione(id);
    }
}
