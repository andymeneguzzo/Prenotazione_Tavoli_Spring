package com.andy.PrenotazioneTavoli;

import com.andy.PrenotazioneTavoli.entity.Prenotazione;
import com.andy.PrenotazioneTavoli.entity.Tavolo;
import com.andy.PrenotazioneTavoli.entity.Utente;
import com.andy.PrenotazioneTavoli.repository.PrenotazioneRepository;
import com.andy.PrenotazioneTavoli.repository.TavoloRepository;
import com.andy.PrenotazioneTavoli.repository.UtenteRepository;
import com.andy.PrenotazioneTavoli.service.PrenotazioneService;
import com.andy.PrenotazioneTavoli.service.TavoloService;
import com.andy.PrenotazioneTavoli.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class PrenotazioneTavoliApplication implements CommandLineRunner {

	@Autowired
	private TavoloService tavoloService;
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private PrenotazioneService prenotazioneService;

	@Autowired
	private TavoloRepository tavoloRepository;

	public static void main(String[] args) {
		SpringApplication.run(PrenotazioneTavoliApplication.class, args);
	}

	@Override
	public void run(String... args) {
		if (tavoloRepository.count() == 0) { // Verifica se la tabella è vuota prima di inserire
			tavoloRepository.save(new Tavolo(1, 4, "Sala Principale"));
			tavoloRepository.save(new Tavolo(2, 2, "Terrazza"));
			tavoloRepository.save(new Tavolo(3, 6, "Sala Esterna"));
			System.out.println("Dati iniziali caricati con successo.");
		} else {
			System.out.println("Dati già presenti, nessun inserimento.");
		}
	}
}