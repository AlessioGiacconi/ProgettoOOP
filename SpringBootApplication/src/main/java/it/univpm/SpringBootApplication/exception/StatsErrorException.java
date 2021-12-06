package it.univpm.SpringBootApplication.exception;


/**
 * Classe di eccezione che viene lanciata nel caso in cui vengano restituiti risultati errati durante la richiesta delle stats.
 * @author Alessio Giacconi
 * @author Erxhes Dedja
 *
 */
public class StatsErrorException extends Exception{

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * costruttore eccezione che richiama costruttore della superclasse 
	 * @param messaggio
	 */

	public StatsErrorException() {
		super();
	}
	
	public StatsErrorException(String msg) {
		super(msg);
	}
}
