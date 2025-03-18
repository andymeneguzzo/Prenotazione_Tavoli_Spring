package com.andy.PrenotazioneTavoli.service;

import com.andy.PrenotazioneTavoli.entity.Prenotazione;
import com.andy.PrenotazioneTavoli.repository.PrenotazioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public Prenotazione salvaPrenotazione(Prenotazione prenotazione) {
        // Qui potresti mettere logiche di controllo: ad esempio
        // se il tavolo è già occupato in quella data/ora, lancia eccezione, ecc.
        return prenotazioneRepository.save(prenotazione);
    }

    public Prenotazione trovaPrenotazione(Long id) {
        Optional<Prenotazione> prenotazione = prenotazioneRepository.findById(id);
        return prenotazione.orElse(null); // gestiamo eccezione
    }

    public List<Prenotazione> listaPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public void eliminaPrenotazione(Long id) {
        prenotazioneRepository.deleteById(id);
    }
}
