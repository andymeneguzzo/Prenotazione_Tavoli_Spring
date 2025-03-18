package com.andy.PrenotazioneTavoli.controller;

import com.andy.PrenotazioneTavoli.entity.Tavolo;
import com.andy.PrenotazioneTavoli.service.TavoloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/tavoli")
public class TavoloController {

    private final TavoloService tavoloService;

    public TavoloController(TavoloService tavoloService) {
        this.tavoloService = tavoloService;
    }

    // GET -> /api/tavoli
    @GetMapping
    public List<Tavolo> getAllTavoli() {
        return tavoloService.listaTavoli();
    }

    // GET -> /api/tavoli/{id}
    @GetMapping("/{id}")
    public Tavolo getTavoloById(@PathVariable Long id) {
        return tavoloService.trovaTavoloPerId(id);
    }

    // POST -> /api/tavoli
    @PostMapping
    public Tavolo creaTavolo(@RequestBody Tavolo tavolo) {
        return tavoloService.salvaTavolo(tavolo);
    }

    // PUT -> /api/tavolo/{id}
    @PutMapping("/{id}")
    public Tavolo aggiornaTavolo(@PathVariable Long id, @RequestBody Tavolo tavolo) {
        // Prima recuperiamo quello esistente
        Tavolo esistente = tavoloService.trovaTavoloPerId(id);

        if(esistente != null) {
            esistente.setNumero(tavolo.getNumero());
            esistente.setPosti(tavolo.getPosti());

            return tavoloService.salvaTavolo(esistente);
        }
        return null; // oppure gestisci eccezione
    }

    // DELETE -> /api/tavolo/{id}
    @DeleteMapping("/{id}")
    public void eliminaTavolo(@PathVariable Long id) {
        tavoloService.eliminaTavolo(id);
    }
}
