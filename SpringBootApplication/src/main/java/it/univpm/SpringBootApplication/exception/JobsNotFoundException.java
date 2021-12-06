package it.univpm.SpringBootApplication.exception;


/**
 * Classe di eccezione che viene lanciata se le richieste non vengono soddisfatte o non viene trovato il lavoro.
 * @author Alessio Giacconi
 * @author Erxhes Dedja
 *
 */


public class JobsNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * costruttore eccezione che richiama costruttore della superclasse 
	 * @param messaggio
	 */
	
	public JobsNotFoundException() {
		super();
	}
	
	public JobsNotFoundException(String msg) {
		super(msg);
	}

}
