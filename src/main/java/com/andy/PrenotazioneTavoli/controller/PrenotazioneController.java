package com.andy.PrenotazioneTavoli.controller;

import com.andy.PrenotazioneTavoli.entity.Prenotazione;
import com.andy.PrenotazioneTavoli.repository.PrenotazioneRepository;
import com.andy.PrenotazioneTavoli.service.PrenotazioneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;

    public PrenotazioneController(PrenotazioneService prenotazioneService) {
        this.prenotazioneService = prenotazioneService;
    }

    @GetMapping
    public List<Prenotazione> getPrenotazioni() {
        return prenotazioneService.listaPrenotazioni();
    }

    @GetMapping("/{id}")
    public Prenotazione getPrenotazione(@PathVariable Long id) {
        return prenotazioneService.trovaPrenotazionePerId(id);
    }

    @PostMapping
    public Prenotazione creaPrenotazione(@RequestBody Prenotazione prenotazione) {
        return prenotazioneService.salvaPrenotazione(prenotazione);
    }

    @PutMapping("/{id}")
    public Prenotazione aggiornaPrenotazione(@PathVariable Long id, @RequestBody Prenotazione prenotazione) {
        Prenotazione esistente = prenotazioneService.trovaPrenotazionePerId(id);

        if(esistente != null) {
            // Aggiorniamo i campi desiderati
            esistente.setTavolo(prenotazione.getTavolo());
            esistente.setUtente(prenotazione.getUtente());
            esistente.setDataPrenotazione(prenotazione.getDataPrenotazione());
            esistente.setOraPrenotazione(prenotazione.getOraPrenotazione());
            esistente.setDurataInOre(prenotazione.getDurataInOre());
            esistente.setNote(prenotazione.getNote());

            return prenotazioneService.salvaPrenotazione(esistente);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminaPrenotazione(@PathVariable Long id) {
        prenotazioneService.eliminaPrenotazione(id);
    }
}
