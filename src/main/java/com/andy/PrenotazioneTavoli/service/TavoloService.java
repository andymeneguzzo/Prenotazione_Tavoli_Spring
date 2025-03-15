package com.andy.PrenotazioneTavoli.service;

import com.andy.PrenotazioneTavoli.entity.Tavolo;
import com.andy.PrenotazioneTavoli.repository.TavoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TavoloService {

    @Autowired
    private TavoloRepository tavoloRepository;

    public Tavolo aggiungiTavolo(Tavolo tavolo) {
        return tavoloRepository.save(tavolo);
    }

    public List<Tavolo> listaTavoli() {
        return tavoloRepository.findAll();
    }

    public Optional<Tavolo> trovaTavoloPerId(Long id) {
        return tavoloRepository.findById(id);
    }

    public void eliminaTavolo(Long id) {
        tavoloRepository.deleteById(id);
    }
}
