package com.andy.PrenotazioneTavoli;

import com.andy.PrenotazioneTavoli.entity.Tavolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrenotazioneTavoliApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PrenotazioneTavoliApplication.class, args);
	}

	@Override
	public void run(String... args) {

	}
}