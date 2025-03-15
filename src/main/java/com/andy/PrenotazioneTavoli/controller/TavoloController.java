package com.andy.PrenotazioneTavoli.controller;

import com.andy.PrenotazioneTavoli.entity.Tavolo;
import com.andy.PrenotazioneTavoli.service.TavoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tavoli")
public class TavoloController {

    @Autowired
    private TavoloService tavoloService;

    @GetMapping
    public List<Tavolo> getAllTavoli() {
        return tavoloService.listaTavoli();
    }

    @GetMapping("/{id}")
    public Tavolo getTavoloById(@PathVariable Long id) {
        return tavoloService.trovaTavoloPerId(id)
                .orElseThrow(() -> new RuntimeException("Tavolo non trovato!"));
    }

    @PostMapping
    public Tavolo createTavolo(@RequestBody Tavolo tavolo) {
        return tavoloService.salvaTavolo(tavolo);
    }

    @DeleteMapping("/{id}")
    public void deleteTavolo(@PathVariable Long id) {
        tavoloService.eliminaTavolo(id);
    }
}
