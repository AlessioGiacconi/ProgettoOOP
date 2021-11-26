package it.univpm.SpringBootApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Classe di eccezione che viene lanciata per gestire le richieste sbagliate nel body o nel caso di un body non valido.
 * @author Alessio Giacconi
 * @author Erxhes Dedja
 *
 */

public class InvalidBodyException extends Exception{
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * costruttore eccezione, che richiama costruttore della superclasse 
	 * @param messaggio
	 */

	public InvalidBodyException(String msg) {
		
		super();
		
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);
	}
		
}

