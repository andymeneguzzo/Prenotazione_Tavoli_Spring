package com.andy.PrenotazioneTavoli.service;

import com.andy.PrenotazioneTavoli.entity.Prenotazione;
import com.andy.PrenotazioneTavoli.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione creaPrenotazione(Prenotazione prenotazione) {
        if(tavoloDisponibile(prenotazione)) {
            return prenotazioneRepository.save(prenotazione);
        } else {
            throw new RuntimeException("Tavolo non disponibile per questa data e ora!");
        }
    }

    public List<Prenotazione> trovaPrenotazioniPerData(LocalDate data) {
        return prenotazioneRepository.findByDataPrenotazione(data);
    }

    public List<Prenotazione> listaPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public void eliminaPrenotazione(Long id) {
        prenotazioneRepository.deleteById(id);
    }

    private boolean tavoloDisponibile(Prenotazione nuovaPrenotazione) {
        List<Prenotazione> prenotazioniStessaData = prenotazioneRepository
                .findByDataPrenotazione(nuovaPrenotazione.getDataPrenotazione());

        LocalTime inizioNuova = nuovaPrenotazione.getOraPrenotazione();
        LocalTime fineNuova = inizioNuova.plusHours(nuovaPrenotazione.getDurataInOre());

        return prenotazioniStessaData.stream()
                .filter(p -> p.getTavolo().getId().equals(nuovaPrenotazione.getTavolo().getId()))
                .noneMatch(p -> {
                    LocalTime inizioEsistente = p.getOraPrenotazione();
                    LocalTime fineEsistente = inizioEsistente.plusHours(p.getDurataInOre());
                    return inizioNuova.isBefore(fineEsistente) && fineNuova.isAfter(inizioEsistente);
                });
    }
}
