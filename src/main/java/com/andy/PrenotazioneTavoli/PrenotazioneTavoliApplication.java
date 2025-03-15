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

	public static void main(String[] args) {
		SpringApplication.run(PrenotazioneTavoliApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("🚀 Avvio test dei Service...");

		// Creazione di un Tavolo
		Tavolo tavolo1 = new Tavolo(1, 4, "Sala Principale");
		Tavolo tavolo2 = new Tavolo(2, 2, "Terrazza");
		tavoloService.aggiungiTavolo(tavolo1);
		tavoloService.aggiungiTavolo(tavolo2);

		System.out.println("✅ Tavoli creati:");
		tavoloService.listaTavoli().forEach(System.out::println);

		// Creazione di un Utente
		Utente cliente = new Utente("Mario Rossi", "mario@gmail.com", "password123", "CLIENTE");
		Utente admin = new Utente("Admin User", "admin@ristorante.com", "admin123", "ADMIN");
		utenteService.registraUtente(cliente);
		utenteService.registraUtente(admin);

		System.out.println("✅ Utenti registrati:");
		utenteService.listaUtenti().forEach(System.out::println);

		// Creazione di una Prenotazione valida
		Prenotazione prenotazione1 = new Prenotazione(
				cliente,
				tavolo1,
				LocalDate.now(),
				LocalTime.of(20, 00),
				2,
				4,
				"Finestra richiesta"
		);

		try {
			prenotazioneService.creaPrenotazione(prenotazione1);
			System.out.println("✅ Prenotazione effettuata con successo!");
		} catch (RuntimeException e) {
			System.out.println("❌ Errore nella prenotazione: " + e.getMessage());
		}

		// Verifica lista prenotazioni
		System.out.println("📌 Lista prenotazioni:");
		prenotazioneService.listaPrenotazioni().forEach(System.out::println);
	}
}