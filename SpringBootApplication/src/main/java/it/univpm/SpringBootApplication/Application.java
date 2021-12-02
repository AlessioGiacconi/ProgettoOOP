package it.univpm.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe che si occupa di gestire e avviare tutti i componenti dell'applicazione.
 * @author Alessio Giacconi
 * @author Erxhes Dedja
 *
 */

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
