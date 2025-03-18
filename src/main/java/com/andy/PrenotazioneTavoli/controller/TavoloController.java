package com.andy.PrenotazioneTavoli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.andy.PrenotazioneTavoli.entity.Tavolo;
import com.andy.PrenotazioneTavoli.exception.ResourceNotFoundException;
import com.andy.PrenotazioneTavoli.service.TavoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/tavoli")
public class TavoloController {

    @Autowired
    private TavoloService tavoloService;

    @GetMapping("/tavoli")
    public String mostraTavoli(Model model) {
        List<Tavolo> tavoli = tavoloService.listaTavoli();
        model.addAttribute("tavoli", tavoli);
        return "tavoli";
    }

    @GetMapping
    public List<Tavolo> getAllTavoli() {
        return tavoloService.listaTavoli();
    }

    @GetMapping("/{id}")
    public Tavolo getTavoloById(@PathVariable Long id) {
        return tavoloService.trovaTavoloPerId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tavolo non trovato!"));
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
