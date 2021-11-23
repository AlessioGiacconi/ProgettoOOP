package it.univpm.SpringBootApplication.exception;

public class StatsErrorException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatsErrorException() {
		super();
	}
	
	public StatsErrorException(String msg) {
		super(msg);
	}
}
